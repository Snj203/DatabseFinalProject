CRUD Operations Project
This project implements a basic CRUD (Create, Read, Update, Delete) functionality for managing a database with four tables: Customer, Book, Author, and Order. The database is designed to handle data for a book store with customers placing orders for books.

## Database Structure

### Tables:

#### Customer
| Column        | Type     | Description                            |
|---------------|----------|----------------------------------------|
| id            | SERIAL   | Primary Key, Unique ID for the customer|
| name          | VARCHAR  | Name of the customer                  |
| email         | VARCHAR  | Email of the customer (Unique)        |
| total_bought  | INT      | Total number of books bought by the customer |
| order_id      | INT      | Foreign Key reference to `Order` table |

#### Book
| Column        | Type     | Description                            |
|---------------|----------|----------------------------------------|
| id            | SERIAL   | Primary Key, Unique ID for the book    |
| title         | VARCHAR  | Title of the book                     |
| genre         | VARCHAR  | Genre of the book                     |
| price         | DECIMAL  | Price of the book                     |
| total_sold    | INT      | Total number of books sold            |
| stock         | INT      | Number of books in stock              |
| author_name   | VARCHAR  | Name of the book's author             |

#### Author
| Column        | Type     | Description                            |
|---------------|----------|----------------------------------------|
| id            | SERIAL   | Primary Key, Unique ID for the author  |
| name          | VARCHAR  | Name of the author                    |
| total_sold    | INT      | Total number of books sold by the author |

#### Order
| Column        | Type     | Description                            |
|---------------|----------|----------------------------------------|
| id            | SERIAL   | Primary Key, Unique ID for the order   |
| customer_id   | INT      | Foreign Key reference to `Customer` table |
| book_id       | INT      | Foreign Key reference to `Book` table |
| quantity      | INT      | Quantity of books in the order         |
| order_date    | TIMESTAMP| Date and time of the order             |
| total_price   | DECIMAL  | Total price of the order               |

## Features

- **Create**: Add new customers, books, authors, and orders to the database.
- **Read**: Retrieve information about customers, books, authors, and orders.
- **Update**: Modify customer information, book stock and price, author's total sold, and order details.
- **Delete**: Remove customers, books, authors, and orders from the database.

## Technologies Used

- JDBC PostgreSQL (or any other relational database)
- JavaSE 
- Java Swing GUI

## Installation

1. Clone the repository.
2. Set up your PostgreSQL database
3. Create "BookStore" databse in it
4. Modify "./src/QueryService.java" file with your pgsql setting.

## Usage

Run "./src/Main.java" file

## Further Documentation

DBStructure.txt - database structure.
RoutineGuide.txt - GUI explained (buttons field etc).

Java code is explained by comments in it.