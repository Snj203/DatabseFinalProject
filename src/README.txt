DB info:
Tables :
        Customer
                Vals:
                    id
                    name
                    email
                    total_bought
                    order_id
        Book
                Vals:
                    id
                    title
                    genre
                    price
                    total_sold
                    stock
                    author_name
        Author
                Vals:
                    id
                    name
                    total_sold
        Order
                Vals:
                    id
                    customer_id
                    book_id
                    quantity
                    order_date
                    total_price
