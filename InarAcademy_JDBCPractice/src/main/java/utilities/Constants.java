package utilities;

public class Constants {
    public static final String QUERY ="SELECT title FROM  film";
    public static String ZEROTH_QUERY ="SELECT TO_CHAR(joindate,'Month') AS month, COUNT(*) AS member_amount\n" +
            "                FROM cd.members\n" +
            "                GROUP BY month\n" +
            "                ORDER BY member_amount  DESC\n" +
            "                LIMIT 1;";
    public static final String FIRST_QUERY ="SELECT CONCAT(customer.first_name,' ',customer.last_name) AS full_name,rental.rental_date FROM actor\n" +
            "INNER JOIN film_actor ON  actor.actor_id=film_actor.actor_id\n" +
            "INNER JOIN inventory ON film_actor.film_id=inventory.film_id\n" +
            "INNER JOIN rental ON inventory.inventory_id=rental.inventory_id\n" +
            "INNER JOIN customer ON rental.customer_id=customer.customer_id\n" +
            "WHERE actor.first_name='Ed' AND actor.last_name='Chase'\n" +
            "ORDER BY rental.rental_date DESC\n" +
            "LIMIT 3";

    public static final String SECOND_QUERY ="SELECT DISTINCT(staff.first_name),staff.username,staff.password FROM staff\n" +
            "INNER JOIN inventory ON staff.store_id=inventory.store_id\n" +
            "INNER JOIN film ON inventory.film_id=film.film_id\n" +
            "WHERE film.title ='Glass Dying'";
    public static final String THIRD_QUERY ="SELECT category.name AS  top_5_categories,COUNT(category.name) AS film_number FROM inventory\n" +
            "INNER JOIN film_category ON inventory.film_id=film_category.film_id\n" +
            "INNER JOIN category ON category.category_id=film_category.category_id\n" +
            "WHERE inventory.store_id=1\n" +
            "GROUP BY category.name\n" +
            "HAVING COUNT(category.name)>150\n" +
            "ORDER BY COUNT(category.name) DESC\n" +
            "LIMIT 5\n";
    public static final  String FOURTH_QUERY ="SELECT country.country_id,country.country,SUM(payment.amount) AS total_payment_amount  FROM country\n" +
            "INNER JOIN city ON city.country_id=country.country_id\n" +
            "INNER JOIN address  ON address.city_id=city.city_id\n" +
            "INNER JOIN customer ON customer.address_id=address.address_id\n" +
            "INNER JOIN payment ON payment.customer_id=customer.customer_id\n" +
            "GROUP BY country.country_id\n" +
            "HAVING SUM (payment.amount)>800\n" +
            "ORDER BY SUM (payment.amount) DESC";
    public static final String FIFTH_QUERY ="SELECT SUM(payment.amount) AS total_earned_amount FROM  payment\n" +
            "INNER JOIN staff ON staff.staff_id=payment.staff_id\n" +
            "WHERE staff.store_id=2;\n";
    public static final String SIXTH_QUERY ="SELECT customer.customer_id,first_name,last_name,payment.amount FROM customer\n" +
            "INNER JOIN address ON customer.address_id=address.address_id\n" +
            "INNER JOIN city ON address.city_id=city.city_id\n" +
            "INNER JOIN country ON city.country_id=country.country_id\n" +
            "INNER JOIN payment ON customer.customer_id=payment.customer_id\n" +
            "WHERE payment.amount=(SELECT MAX(payment.amount) FROM payment)\n" +
            "GROUP BY customer.customer_id,payment.amount";
    public static final String SEVENTH_QUERY ="SELECT DISTINCT( TO_CHAR(rental.rental_date,'Month')) AS Month,\n" +
            "COUNT(EXTRACT (MONTH FROM rental.rental_date))AS total_sales,staff.staff_id FROM staff\n" +
            "INNER JOIN rental \n" +
            "ON staff.staff_id=rental.staff_id\n" +
            "GROUP BY TO_CHAR((rental.rental_date),'Month'),staff.staff_id\n" +
            "ORDER BY staff.staff_id";
    public static final String EIGHTH_QUERY ="SELECT address.address,city.city,country.country FROM store\n" +
            "INNER JOIN  address ON store.address_id=address.address_id\n" +
            "INNER JOIN city ON address.city_id=city.city_id\n" +
            "INNER JOIN country ON city.country_id=country.country_id\n" +
            "WHERE store.store_id=2\n";
    public static  final String NINTH_QUERY ="SELECT film.film_id,film.title,COUNT(inventory.film_id) AS copy_number FROM film\n" +
            "INNER JOIN inventory \n" +
            "ON film.film_id=inventory.film_id\n" +
            "WHERE inventory.store_id=1\n" +
            "GROUP BY film.film_id\n" +
            "HAVING  COUNT(film.film_id) =(SELECT COUNT(inventory.film_id) FROM inventory\n" +
            "\t\t\t\t\t\t\t  WHERE inventory.store_id=1\n" +
            "\t\t\t\t\t\t\t  GROUP BY film_id\n" +
            "\t\t\t\t\t\t\t  ORDER BY COUNT(film_id) DESC LIMIT 1)\n" +
            "ORDER BY film.film_id ";
    public static final String TENTH_QUERY ="SELECT COUNT(film_id) FROM inventory\n" +
            "WHERE store_id=2\n" +
            "GROUP BY film_id\n" +
            "HAVING COUNT(film_id)=3";


}
