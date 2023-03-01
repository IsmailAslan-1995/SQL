package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Q5StepDefinition {
    private static int count=0;
    @Given("{string} should_match_with_database_data")
    public void should_match_with_database_data(String total_earned_amount) {
        String query="SELECT SUM(payment.amount) AS total_earned_amount FROM  payment\n" +
                "            INNER JOIN staff ON staff.staff_id=payment.staff_id\n" +
                "            WHERE staff.store_id=2";
        List<Map<String,String>> queryResultMap= DBUtils.getQueryResultMap(query);
        Map<String,String> map=queryResultMap.get(count++);

        Assert.assertEquals(map.get("total_earned_amount"),total_earned_amount);
    }
}
