CREATE TABLE book (
  book_id VARCHAR(255) UNIQUE NOT NULL,

  isbn_10 VARCHAR(255),
  isbn_13 VARCHAR(255),
  title VARCHAR(255) NOT NULL,
  authors VARCHAR(255),
  publisher VARCHAR(255),
  published_date VARCHAR(255),
  page_count INTEGER,
  thumbnail VARCHAR(255),

  PRIMARY KEY (book_id)
);

CREATE TABLE book_status (
  status_id INTEGER NOT NULL,
  status_value VARCHAR(255) NOT NULL,
  PRIMARY KEY (status_id)
);

CREATE TABLE owner_book (
  book_id VARCHAR(255) NOT NULL,
  owner_id VARCHAR(255) NOT NULL,

  rating REAL DEFAULT '0.0',
  status_id INTEGER DEFAULT '0',
  wishlist BOOLEAN DEFAULT '0',

  PRIMARY KEY (book_id, owner_id),
  FOREIGN KEY (status_id) REFERENCES book_status(status_id),
  FOREIGN KEY (book_id) REFERENCES book(book_id)
);

-- Required inserts
INSERT INTO book_status (status_id, status_value) VALUES ('0', 'Unread');
INSERT INTO book_status (status_id, status_value) VALUES ('1', 'In Progress');
INSERT INTO book_status (status_id, status_value) VALUES ('2', 'Read');
INSERT INTO book_status (status_id, status_value) VALUES ('3', 'On Hold');
INSERT INTO book_status (status_id, status_value) VALUES ('4', 'Abandoned');


-- Sample data
INSERT INTO book (book_id, title) VALUES ('1', 'Enemy Of The Nation');
INSERT INTO book (book_id, title) VALUES ('2', 'Robot Of The Plague');
INSERT INTO book (book_id, title) VALUES ('3', 'Officers Without Time');
INSERT INTO book (book_id, title) VALUES ('4', 'Rats Of Joy');
INSERT INTO book (book_id, title) VALUES ('5', 'Gangsters And Pirates');
INSERT INTO book (book_id, title) VALUES ('6', 'Tower Without Sin');
INSERT INTO book (book_id, title) VALUES ('7', 'Name With Silver');
INSERT INTO book (book_id, title) VALUES ('8', 'Drinking At Dreams');
INSERT INTO book (book_id, title) VALUES ('9', 'Lion Of The Lost Ones');

INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '1');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '2');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '3');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '4');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '5');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '6');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '7');
INSERT INTO owner_book (owner_id, book_id) VALUES ('10212300184566291', '8');

-- Set a book rating
UPDATE owner_book SET rating = :rating 
WHERE owner_id = :ownerId AND book_id = :bookId;

-- Set a book status
UPDATE owner_book SET status_id = :statusId 
WHERE owner_id = :ownerId AND book_id = :bookId;