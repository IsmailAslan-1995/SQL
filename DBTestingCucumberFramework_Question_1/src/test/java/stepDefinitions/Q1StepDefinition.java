package stepDefinitions;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;
public class Q1StepDefinition {
    private static int count=0;
    @Given("{string} {string} {string} {string} {string} should_match_with_database_data")
    public void should_match_with_database_data(String customer_id, String full_name, String city, String country,  String sum) {
        String query="SELECT customer.customer_id, CONCAT(customer.first_name ,' ',customer.last_name) AS full_name,city.city, country.country,SUM(payment.amount) FROM payment  \n" +
                "                INNER JOIN customer  ON customer.customer_id = payment.customer_id\n" +
                "                INNER JOIN address  ON address.address_id = customer.address_id\n" +
                "                INNER JOIN city  ON address.city_id = city.city_id\n" +
                "                INNER JOIN country  ON city.country_id = country.country_id\n" +
                "                GROUP BY customer.customer_id, city.city_id,country.country \n" +
                "                ORDER BY SUM(amount) DESC limit 10;";
        List<Map<String,String>> queryResultMap= DBUtils.getQueryResultMap(query);
        Map<String,String> map=queryResultMap.get(count++);

        Assert.assertEquals(map.get("customer_id"),customer_id);
        Assert.assertEquals(map.get("full_name"),full_name);
        Assert.assertEquals(map.get("city"),city);
        Assert.assertEquals(map.get("country"),country);
        Assert.assertEquals(map.get("sum"),sum);

    }
}
