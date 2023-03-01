package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q2StepDefinition {
    private static int count=0;
    @Given("{string} {string} {string} should_match_with_database_data")
    public void should_match_with_database_data(String first_name, String username, String password) {

        String query ="SELECT DISTINCT(staff.first_name),staff.username,staff.password FROM staff\n" +
                "            INNER JOIN inventory ON staff.store_id=inventory.store_id\n" +
                "            INNER JOIN film ON inventory.film_id=film.film_id\n" +
                "            WHERE film.title ='Glass Dying'";
        List<Map<String, String>> queryResultMap = DBUtils.getQueryResultMap(query);
        Map<String, String> map = queryResultMap.get(count++);
        Assert.assertEquals(map.get("first_name"), first_name);
        Assert.assertEquals(map.get("username"), username);
        Assert.assertEquals(map.get("password"), password);
    }
}
