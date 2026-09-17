CREATE
DATABASE library;
\connect
library;

CREATE TABLE members
(
    id    serial PRIMARY KEY,
    name  VARCHAR(50),
    email VARCHAR(100)

);
CREATE TABLE book
(
    id     serial PRIMARY KEY,
    name   VARCHAR(50),
    author VARCHAR(50)


);
CREATE TABLE lond
(
    id         serial primary key,
    memberId   integer references members (id),
    bookID     integer references book (id),
    borrowDate DATE,
    returnDate DATE
);
