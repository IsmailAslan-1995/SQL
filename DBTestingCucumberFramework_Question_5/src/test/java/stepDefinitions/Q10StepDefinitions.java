package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q10StepDefinitions {
    private static int count=0;
    @Given("{string} should_match_with_database_data")
    public void should_match_with_database_data(String total_copy_number) {
        String query="SELECT COUNT(film_id) FROM inventory\n" +
                "WHERE store_id=2\n" +
                "GROUP BY film_id\n" +
                "HAVING COUNT(film_id)=3";
        List<Map<String,String>> queryResultMap= DBUtils.getQueryResultMap(query);
        Map<String,String> map=queryResultMap.get(count++);
        Assert.assertEquals(queryResultMap.size()+"",total_copy_number);
    }
}
