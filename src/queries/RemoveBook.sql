UPDATE customer
SET total_bought = total_bought - (SELECT SUM(quantity) FROM "order" WHERE book_id = {placeholder});

UPDATE author
SET total_sold = total_sold - (SELECT SUM(quantity) FROM "order" WHERE book_id = {placeholder})
WHERE name IN (SELECT author_name FROM book WHERE id IN
    (SELECT book_id FROM "order" WHERE book_id = {placeholder}));

DELETE FROM "order"
WHERE book_id = {placeholder};

DELETE FROM book
WHERE id = {placeholder};