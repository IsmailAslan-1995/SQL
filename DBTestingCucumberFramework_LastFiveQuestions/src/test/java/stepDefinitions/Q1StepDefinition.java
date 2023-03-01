package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q1StepDefinition {
    private static int count = 0;

    @Given("{string} {string} {string} {string}  should match with the result")
    public void should_match_with_the_result(String customer_id, String first_name, String last_name, String amount) {
        String query = "SELECT customer.customer_id,first_name,last_name,payment.amount FROM customer\n" +
                "            INNER JOIN address ON customer.address_id=address.address_id\n" +
                "            INNER JOIN city ON address.city_id=city.city_id\n" +
                "            INNER JOIN country ON city.country_id=country.country_id\n" +
                "            INNER JOIN payment ON customer.customer_id=payment.customer_id\n" +
                "            WHERE payment.amount=(SELECT MAX(payment.amount) FROM payment)\n" +
                "            GROUP BY customer.customer_id,payment.amount";
        List<Map<String, String>> queryResultMap = DBUtils.getQueryResultMap(query);
        Map<String, String> map = queryResultMap.get(count++);
        Assert.assertEquals(map.get("customer_id") + "", customer_id);
        Assert.assertEquals(map.get("first_name"), first_name);
        Assert.assertEquals(map.get("last_name"), last_name);
        Assert.assertEquals(map.get("amount")+"", amount);

    }
}
