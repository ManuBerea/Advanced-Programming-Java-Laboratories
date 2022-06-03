drop table words;

CREATE TABLE words (
  id INT NOT NULL PRIMARY KEY,
  word_name VARCHAR2(30) NOT NULL,
  word_language VARCHAR2(30) NOT NULL,
  word_difficulty VARCHAR2(30) NOT NULL
)
/