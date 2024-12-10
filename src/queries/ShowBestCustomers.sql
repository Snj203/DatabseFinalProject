SELECT * FROM Customer
WHERE
    total_bought IN (
        SELECT DISTINCT total_bought
        FROM customer
        ORDER BY total_bought DESC
        LIMIT {placeholder}
    )
ORDER BY
    total_bought DESC;