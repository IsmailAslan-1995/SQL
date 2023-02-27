package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q4StepDefinitions {
    private static int count=0;
    @Given("{string} {string} {string} should match with database data")
    public void should_match_with_database_data(String country_id, String country, String total_payment_amount) {
        String query="SELECT country.country_id,country.country,SUM(payment.amount) AS total_payment_amount  FROM country\n" +
                "            INNER JOIN city ON city.country_id=country.country_id\n" +
                "            INNER JOIN address  ON address.city_id=city.city_id\n" +
                "            INNER JOIN customer ON customer.address_id=address.address_id\n" +
                "            INNER JOIN payment ON payment.customer_id=customer.customer_id\n" +
                "            GROUP BY country.country_id\n" +
                "            HAVING SUM (payment.amount)>800\n" +
                "            ORDER BY SUM (payment.amount) DESC";
        List<Map<String, String>> queryResultMap= DBUtils.getQueryResultMap(query);
        Map<String,String> map=queryResultMap.get(count++);
        Assert.assertEquals(map.get("country_id"),country_id);
        Assert.assertEquals(map.get("country"),country);
        Assert.assertEquals(map.get("total_payment_amount"),total_payment_amount);

    }
}
