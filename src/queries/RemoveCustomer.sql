UPDATE book
SET total_sold = total_sold - (SELECT SUM(quantity) FROM "order" WHERE customer_id = {placeholder});

UPDATE author
SET total_sold = total_sold - (SELECT SUM(quantity) FROM "order" WHERE customer_id = {placeholder})
WHERE name IN (SELECT author_name FROM book WHERE id IN
    (SELECT book_id FROM "order" WHERE customer_id = {placeholder}));

DELETE FROM "order"
WHERE customer_id = {placeholder};

DELETE FROM customer
WHERE id = {placeholder};