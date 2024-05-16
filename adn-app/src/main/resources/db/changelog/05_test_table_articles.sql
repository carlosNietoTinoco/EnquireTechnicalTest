CREATE TABLE articles (
    source_id INT PRIMARY KEY,
    source_name VARCHAR(255),
    author VARCHAR(255),
    title TEXT,
    description TEXT,
    url VARCHAR(255),
    urlToImage VARCHAR(255),
    publishedAt timestamp with time zone,
    content TEXT
);
