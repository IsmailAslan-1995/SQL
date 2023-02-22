SELECT COUNT(*) AS guest_number
FROM cd.bookings table1
INNER JOIN cd.facilities table2 
ON table1.facid = table2.facid
WHERE table1.memid = 0;
SELECT * FROM cd.facilities




