CREATE TABLE author (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL UNIQUE,
                        total_sold INT DEFAULT 0
);

CREATE TABLE book (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      genre VARCHAR(100),
                      price DECIMAL(10, 2) NOT NULL,
                      total_sold INT DEFAULT 0,
                      stock INT DEFAULT 100,
                      author_name VARCHAR(255),
                      FOREIGN KEY (author_name) REFERENCES author(name)
);

CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          total_bought INT DEFAULT 0 NOT NULL

);

CREATE TABLE "order" (
                         id SERIAL PRIMARY KEY,
                         customer_id INT NOT NULL,
                         book_id INT NOT NULL,
                         quantity INT NOT NULL DEFAULT 1,
                         order_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         total_price DECIMAL(10, 2) NOT NULL,
                         FOREIGN KEY (customer_id) REFERENCES customer(id),
                         FOREIGN KEY (book_id) REFERENCES book(id)
);


INSERT INTO author (name)
VALUES
    ('J.K. Rowling'),
    ('George R.R. Martin'),
    ('Isaac Asimov'),
    ('Agatha Christie');

INSERT INTO book (title, genre, price,author_name)
VALUES
    ('Harry Potter and the Sorcerer Stone', 'Fantasy', 19.99,'J.K. Rowling'),
    ('A Game of Thrones', 'Fantasy', 25.99,'George R.R. Martin'),
    ('Foundation', 'Science Fiction', 22.50,'Isaac Asimov'),
    ('Murder on the Orient Express', 'Mystery', 12.99,'Agatha Christie');

INSERT INTO customer (name, email)
VALUES
    ('John Doe', 'john.doe@example.com'),
    ('Alice Johnson', 'alice.johnson@example.com');

INSERT INTO "order" (customer_id,book_id,quantity,total_price)
VALUES
    (1,1,0, 45.98),
    (2,2,0, 31.94);
