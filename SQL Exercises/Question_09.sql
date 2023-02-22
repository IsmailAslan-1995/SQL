SELECT district , SUM(payment.amount) AS amount FROM customer
INNER JOIN payment
ON customer.customer_id=payment.customer_id
INNER JOIN address
ON customer.address_id=address.address_id
GROUP BY district
ORDER BY amount DESC
LIMIT 1;









