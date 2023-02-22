SELECT cd.facilities.name,COUNT(DISTINCT(cd.bookings.memid)) FROM cd.facilities
INNER JOIN cd.bookings
ON cd.facilities.facid=cd.bookings.facid
WHERE cd.bookings.memid IN (
SELECT DISTINCT cd.members.memid FROM cd.members)
GROUP BY cd.facilities.name
ORDER BY COUNT(DISTINCT(cd.bookings.memid)) DESC
LIMIT 1;

