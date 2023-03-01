package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q3StepDefinition {
    private static int count=0;
    @Given("{string} {string} should_match_with_database_data")
    public void should_match_with_database_data(String top_5_categories, String film_number) {
        String query ="SELECT category.name AS  top_5_categories,COUNT(category.name) AS film_number FROM inventory\n" +
                "            INNER JOIN film_category ON inventory.film_id=film_category.film_id\n" +
                "            INNER JOIN category ON category.category_id=film_category.category_id \n" +
                "            WHERE inventory.store_id=1\n" +
                "            GROUP BY category.name\n" +
                "            HAVING COUNT(category.name)>150\n" +
                "            ORDER BY COUNT(category.name) DESC\n" +
                "            LIMIT 5";
        List<Map<String, String>> queryResultMap = DBUtils.getQueryResultMap(query);
        Map<String, String> map = queryResultMap.get(count++);
        Assert.assertEquals(map.get("top_5_categories"), top_5_categories);
        Assert.assertEquals(map.get("film_number"), film_number);

    }

}
