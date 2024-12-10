UPDATE customer
SET total_bought = total_bought - (SELECT SUM(quantity) FROM "order" WHERE book_id IN (
    SELECT id FROM book WHERE author_name in (SELECT name FROM author WHERE id = {placeholder})));

DELETE FROM "order"
WHERE book_id IN (SELECT id FROM book WHERE author_name in (SELECT name FROM author WHERE id = {placeholder}));

DELETE FROM book
WHERE author_name = (SELECT name FROM author WHERE id = {placeholder});

DELETE FROM author
WHERE name = (SELECT name FROM author WHERE id = {placeholder});