import os
import json

from flask import Flask, request, jsonify
from langchain_community.llms import Ollama
from langchain_community.vectorstores import Chroma
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain_community.embeddings.fastembed import FastEmbedEmbeddings
from langchain_community.document_loaders import PDFPlumberLoader
from langchain.chains.combine_documents import create_stuff_documents_chain
from langchain.chains import create_retrieval_chain
from langchain.prompts import PromptTemplate

app = Flask(__name__)

folder_path = "db"

cached_llm = Ollama(model="phi3")

embedding = FastEmbedEmbeddings()

text_splitter = RecursiveCharacterTextSplitter(
    chunk_size=1024, chunk_overlap=80, length_function=len, is_separator_regex=False
)

raw_prompt = PromptTemplate.from_template(
    """ 
    <s>[INST] You are a technical assistant good at searching docuemnts. If you do not have an answer from the provided information say so. [/INST] </s>
    [INST] {input}
           Context: {context}
           Answer:
    [/INST]
"""
)

@app.route("/pdf", methods=["POST"])
def pdfPost():

    pdf_names = ['martin_articuloN_2023.pdf', 'ortiz_articulo_2023.pdf', 'murrietaA_articulo_2024.pdf', 'yunis_articulo_2023.pdf', '1-s2.0-S2949824423001143-main.pdf', 'delgado_articulo_2023.pdf', 'fachin_articuloE_2023.pdf', 'tavares_articulo_2023.pdf', 'garcia_articulo_2023.pdf', 'sanjurjo_articulo_2024.pdf', 'mejia_articulo_2023.pdf', 'perez_articuloU_2022.pdf', 'murrieta_articuloA_2023.pdf', 'moorhouse_articulo_2023.pdf', 'Murrieta_articulo_2023n.pdf', 'villalobos_articulo_2024.pdf', 'Hordijk_articulo_2023.pdf', 'householder_articulo_2024.pdf', 'cooper_articulo_2024.pdf', 'becerra_articulo_2024.pdf']
    response = []

    for pdf_file in pdf_names:
        pdf_url = "pdf/" + pdf_file
        loader = PDFPlumberLoader(pdf_url)
        docs = loader.load_and_split()
        print(f"docs len={len(docs)}")

        chunks = text_splitter.split_documents(docs)
        print(f"chunks len={len(chunks)}")

        vector_store = Chroma.from_documents(
            documents=chunks, embedding=embedding, persist_directory=folder_path
        )

        vector_store.persist()

        
    return response


@app.route("/ai", methods=["POST"])
def aiPost():
    print("Post /ai called")
    json_content = request.json
    query = json_content.get("query")

    print(f"query: {query}")

    response = cached_llm.invoke(query)

    print(response)

    response_answer = {"answer": response}
    return response_answer


@app.route("/ask_pdf", methods=["POST"])
def askPDFPost():
    print("Post /ask_pdf called")
    
    json_content = request.json
    query = json_content.get("query")

    print(f"query: {query}")

    print("Loading vector store")
    vector_store = Chroma(persist_directory=folder_path, embedding_function=embedding)

    print("Creating chain")
    retriever = vector_store.as_retriever(
        search_type="similarity_score_threshold",
        search_kwargs={
            "k": 20,
            "score_threshold": 0.1,
        },
    )

    document_chain = create_stuff_documents_chain(cached_llm, raw_prompt)
    chain = create_retrieval_chain(retriever, document_chain)

    result = chain.invoke({"input": query})

    print(result)

    sources = []
    for doc in result["context"]:
        sources.append(
            {"source": doc.metadata["source"], "page_content": doc.page_content}
        )

    response_answer = {"answer": result["answer"], "sources": sources}
    return jsonify(response_answer)



def start_app():
    #pdfPost()
    app.run(host="0.0.0.0", port=8080, debug=True)


if __name__ == "__main__":
    start_app()

