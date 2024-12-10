SELECT * FROM Book
WHERE
    stock IN (
        SELECT stock
        FROM Book
        ORDER BY stock ASC
        LIMIT {placeholder}
    )
ORDER BY
    stock ASC;