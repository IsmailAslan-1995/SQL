SELECT customer.first_name, customer.last_name, payment.amount FROM customer 
INNER JOIN payment  ON customer.customer_id = payment.customer_id
WHERE payment.amount = (SELECT MAX(amount) FROM payment);