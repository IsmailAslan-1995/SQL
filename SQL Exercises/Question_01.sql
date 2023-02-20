
SELECT phone FROM address
INNER JOIN customer
ON address.address_id=customer.address_id
WHERE customer.first_name='Pamela' AND customer.last_name='Baker'

