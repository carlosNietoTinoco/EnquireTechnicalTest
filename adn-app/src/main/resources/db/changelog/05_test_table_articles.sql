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

INSERT INTO articles (source_id, source_name, author, title, description, url, urlToImage, publishedAt, content) VALUES
('1', 'Yahoo Entertainment', 'Kris Holt', 'What to expect at Google I/O 2024: Gemini, Android 15 and more', 'It''s almost that time again, folks: we''re about to find out about some of Google''s big ideas for the year ahead at its I/O developer conference . Most of the big news will come from the opening keynote on May 14, which will almost certainly give us more info…', 'https://consent.yahoo.com/v2/collectConsent?sessionId=1_cc-session_11faefe9-a920-4ee3-a025-d5bb2fd50453', 'None', '2024-05-06T17:45:35Z', 'If you click ''Accept all'', we and our partners, including 237 who are part of the IAB Transparency &amp; Consent Framework, will also store and/or access information on a device (in other words, use … [+678 chars]');

