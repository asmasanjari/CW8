CREATE DATABASE library;
\connect library;

CREATE TABLE members
(
    id    integer PRIMARY KEY,
    name  VARCHAR(50),
    email VARCHAR(100)

);
CREATE TABLE book
(
    id     integer PRIMARY KEY,
    name   VARCHAR(50),
    author VARCHAR(50)


);
CREATE TABLE lond
(
    id         integer primary key,
    memberId   integer references members (id),
    bookID     integer references book (id),
    borrowDate DATE,
    returnDate DATE
);
