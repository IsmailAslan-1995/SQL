SELECT cd.facilities.name, COUNT(cd.facilities.name) AS booking_amount FROM cd.facilities 
INNER JOIN cd.bookings
ON cd.facilities.facid=cd.bookings.facid
GROUP BY cd.facilities.name
ORDER BY COUNT(cd.facilities.name) DESC
LIMIT 1;
