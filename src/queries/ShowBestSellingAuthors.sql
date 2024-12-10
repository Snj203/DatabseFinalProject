SELECT * FROM Author
WHERE
    total_sold IN (
        SELECT DISTINCT total_sold
        FROM Author
        ORDER BY total_sold DESC
        LIMIT {placeholder}
    )
ORDER BY
    total_sold DESC;