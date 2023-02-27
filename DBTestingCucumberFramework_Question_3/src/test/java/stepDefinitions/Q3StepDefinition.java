package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q3StepDefinition {
    private static int count=0;
    @Given("{string} {string} {string} should match with database data")
    public void should_match_with_database_data(String address, String city, String country) {
        String query="SELECT address.address,city.city,country.country FROM store\n" +
                "            INNER JOIN  address ON store.address_id=address.address_id\n" +
                "            INNER JOIN city ON address.city_id=city.city_id\n" +
                "            INNER JOIN country ON city.country_id=country.country_id\n" +
                "            WHERE store.store_id=2";
        List<Map<String,String>> queryResultMap=DBUtils.getQueryResultMap(query);
        Map<String,String> map=queryResultMap.get(count++);

        Assert.assertEquals(map.get("address"),address);
        Assert.assertEquals(map.get("city"),city);
        Assert.assertEquals(map.get("country"),country);
    }
}
