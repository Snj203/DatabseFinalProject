SELECT * FROM Book
WHERE
    total_sold IN (
        SELECT DISTINCT total_sold
        FROM Book
        ORDER BY total_sold DESC
        LIMIT {placeholder}
    )
ORDER BY
    total_sold DESC;