
INSERT INTO "order" (customer_id, book_id, quantity,total_price)
VALUES
    ({placeholder0},{placeholder1},{placeholder2},0);

UPDATE "order"
SET total_price = (SELECT SUM(price) * {placeholder2} FROM book)
WHERE id = {placeholder1};

UPDATE customer
SET total_bought = total_bought + {placeholder2}
    WHERE id = {placeholder0};

UPDATE book
SET total_sold =total_sold + {placeholder2}
    WHERE id = {placeholder1};

UPDATE book
SET stock = stock - {placeholder2}
    WHERE id = {placeholder1};

UPDATE author
SET total_sold = total_sold + {placeholder2}
    WHERE name = (SELECT DISTINCT author_name FROM book WHERE id = {placeholder1}) ;