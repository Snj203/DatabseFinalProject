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
    ('Margaret Atwood'),
    ('Neil Gaiman'),
    ('Haruki Murakami'),
    ('Kurt Vonnegut'),
    ('Orson Scott Card'),
    ('Philip K. Dick'),
    ('Douglas Adams'),
    ('Terry Pratchett'),
    ('George Orwell'),
    ('Jane Austen'),
    ('Leo Tolstoy'),
    ('Victor Hugo'),
    ('Charles Dickens'),
    ('Raymond Carver'),
    ('William Faulkner'),
    ('John Steinbeck'),
    ('H.G. Wells'),
    ('Emily Brontë'),
    ('Virginia Woolf'),
    ('Sylvia Plath');

INSERT INTO book (title, genre, price, author_name)
VALUES
    ('The Handmaids Tale', 'Dystopian', 18.50, 'Margaret Atwood'),
    ('Good Omens', 'Fantasy', 20.00, 'Neil Gaiman'),
    ('Kafka on the Shore', 'Magical Realism', 22.99, 'Haruki Murakami'),
    ('Slaughterhouse-Five', 'Science Fiction', 16.75, 'Kurt Vonnegut'),
    ('Enders Game', 'Science Fiction', 18.99, 'Orson Scott Card'),
    ('Do Androids Dream of Electric Sheep', 'Science Fiction', 20.50, 'Philip K. Dick'),
    ('The Hitchhikers Guide to the Galaxy', 'Science Fiction', 17.99, 'Douglas Adams'),
    ('Discworld', 'Fantasy', 19.50, 'Terry Pratchett'),
    ('1984', 'Dystopian', 14.99, 'George Orwell'),
    ('Pride and Prejudice', 'Romance', 12.99, 'Jane Austen'),
    ('War and Peace', 'Historical Fiction', 24.99, 'Leo Tolstoy'),
    ('Les Miserables', 'Historical Fiction', 23.50, 'Victor Hugo'),
    ('Great Expectations', 'Classic', 15.00, 'Charles Dickens'),
    ('What We Talk About When We Talk About Love', 'Short Stories', 13.50, 'Raymond Carver'),
    ('As I Lay Dying', 'Southern Gothic', 16.00, 'William Faulkner'),
    ('The Grapes of Wrath', 'Historical Fiction', 19.99, 'John Steinbeck'),
    ('The Invisible Man', 'Science Fiction', 18.25, 'H.G. Wells'),
    ('Wuthering Heights', 'Romantic Fiction', 16.75, 'Emily Brontë'),
    ('Mrs Dalloway', 'Modernism', 14.50, 'Virginia Woolf'),
    ('The Bell Jar', 'Psychological Fiction', 15.99, 'Sylvia Plath'),
    ('Oryx and Crake', 'Dystopian', 21.50, 'Margaret Atwood'),
    ('Neverwhere', 'Urban Fantasy', 19.99, 'Neil Gaiman'),
    ('Norwegian Wood', 'Romance', 17.50, 'Haruki Murakami'),
    ('Cats Cradle', 'Satire', 14.75, 'Kurt Vonnegut'),
    ('Speaker for the Dead', 'Science Fiction', 18.99, 'Orson Scott Card'),
    ('The Man in the High Castle', 'Alternate History', 21.99, 'Philip K. Dick'),
    ('So Long, and Thanks for All the Fish', 'Science Fiction', 16.00, 'Douglas Adams'),
    ('The Colour of Magic', 'Fantasy', 17.75, 'Terry Pratchett'),
    ('Animal Farm', 'Political Satire', 10.99, 'George Orwell'),
    ('Sense and Sensibility', 'Romance', 13.50, 'Jane Austen'),
    ('Anna Karenina', 'Classic', 22.00, 'Leo Tolstoy'),
    ('The Hunchback of Notre-Dame', 'Historical Fiction', 20.50, 'Victor Hugo'),
    ('David Copperfield', 'Classic', 18.75, 'Charles Dickens'),
    ('Short Cuts', 'Short Stories', 16.25, 'Raymond Carver'),
    ('Light in August', 'Southern Gothic', 17.00, 'William Faulkner'),
    ('East of Eden', 'Historical Fiction', 19.50, 'John Steinbeck'),
    ('The Time Machine', 'Science Fiction', 13.00, 'H.G. Wells'),
    ('Jane Eyre', 'Gothic Romance', 15.99, 'Emily Brontë'),
    ('To the Lighthouse', 'Modernist Fiction', 16.50, 'Virginia Woolf'),
    ('Ariel', 'Poetry', 12.00, 'Sylvia Plath');


INSERT INTO customer (name, email)
VALUES
    ('John Doe', 'john.doe@example.com'),
    ('Alice Johnson', 'alice.johnson@example.com'),
    ('Sam Williams', 'sam.williams@example.com'),
    ('Olivia Davis', 'olivia.davis@example.com'),
    ('Michael Brown', 'michael.brown@example.com'),
    ('Sophia Wilson', 'sophia.wilson@example.com'),
    ('Daniel Lee', 'daniel.lee@example.com'),
    ('Emma Young', 'emma.young@example.com'),
    ('James King', 'james.king@example.com'),
    ('Isabella Martinez', 'isabella.martinez@example.com'),
    ('Matthew Gonzalez', 'matthew.gonzalez@example.com'),
    ('Charlotte Anderson', 'charlotte.anderson@example.com'),
    ('Lucas Thomas', 'lucas.thomas@example.com'),
    ('Amelia Jackson', 'amelia.jackson@example.com'),
    ('Alexander White', 'alexander.white@example.com'),
    ('Mia Harris', 'mia.harris@example.com'),
    ('Benjamin Clark', 'benjamin.clark@example.com'),
    ('Ella Lewis', 'ella.lewis@example.com'),
    ('Jackson Walker', 'jackson.walker@example.com'),
    ('Ava Robinson', 'ava.robinson@example.com'),
    ('Ethan Scott', 'ethan.scott@example.com');

INSERT INTO "order" (customer_id,book_id,quantity,total_price)
VALUES
    (1,1,0, 45.98),
    (2,2,0, 31.94);
