CREATE TABLE author (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        total_sold INT DEFAULT 0
);

CREATE TABLE book (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      genre VARCHAR(100),
                      price DECIMAL(10, 2) NOT NULL,
                      total_sold INT DEFAULT 0,
                      stock INT DEFAULT 100
);

CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          total_bought INT DEFAULT 0
);

CREATE TABLE "order" (
                         id SERIAL PRIMARY KEY,
                         customer_id INT NOT NULL,
                         order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         total_price DECIMAL(10, 2) NOT NULL,
                         FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE Book_Author (
                             book_id INT NOT NULL,
                             author_id INT NOT NULL,
                             PRIMARY KEY (book_id, author_id),
                             FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE,
                             FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);

CREATE TABLE Book_Order (
                            book_id INT NOT NULL,
                            order_id INT NOT NULL,
                            quantity INT NOT NULL DEFAULT 1,
                            PRIMARY KEY (book_id, order_id),
                            FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE,
                            FOREIGN KEY (order_id) REFERENCES "order"(id) ON DELETE CASCADE
);

INSERT INTO author (name)
VALUES
    ('J.K. Rowling'),
    ('George R.R. Martin'),
    ('Isaac Asimov'),
    ('Agatha Christie');

INSERT INTO book (title, genre, price)
VALUES
    ('Harry Potter and the Sorcerer Stone', 'Fantasy', 19.99),
    ('A Game of Thrones', 'Fantasy', 25.99),
    ('Foundation', 'Science Fiction', 22.50),
    ('Murder on the Orient Express', 'Mystery', 12.99);

INSERT INTO book_Author (book_id, author_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);

INSERT INTO customer (name, email)
VALUES
    ('John Doe', 'john.doe@example.com'),
    ('Alice Johnson', 'alice.johnson@example.com');

INSERT INTO "order" (customer_id, total_price)
VALUES
    (1, 45.98),
    (2, 31.94);

INSERT INTO Book_Order (book_id, order_id, quantity)
VALUES
    (1, 1, 2),
    (2, 1, 1);