FROM ollama/ollama:latest AS build

COPY ./run-ollama.sh /tmp/run-ollama.sh
COPY ./run-app.sh /tmp/run-app.sh

WORKDIR /tmp

RUN chmod +x run-ollama.sh \
    && ./run-ollama.sh
    
RUN chmod +x run-app.sh

RUN mkdir -p /workspace
WORKDIR /workspace
COPY / /workspace/ai-api

RUN apt-get update && \
    apt-get install -y python3.11  python3-pip
    
RUN pip install fastembed langchain langchain_community PyMuPDF chromadb Flask

WORKDIR /workspace/ai-api
    
EXPOSE 8080

ENTRYPOINT ["/tmp/run-app.sh"]
