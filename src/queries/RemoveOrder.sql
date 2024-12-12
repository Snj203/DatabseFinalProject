
UPDATE book
SET total_sold = total_sold - (SELECT quantity FROM "order" WHERE id = {placeholder});

UPDATE customer
SET total_bought = total_bought - (SELECT quantity FROM "order" WHERE id = {placeholder});

UPDATE author
SET total_sold = total_sold - (SELECT quantity FROM "order" WHERE id = {placeholder})
WHERE name IN (SELECT author_name FROM book WHERE id =
    (SELECT book_id FROM "order" WHERE id = {placeholder}));

DELETE FROM "order"
WHERE id = {placeholder};