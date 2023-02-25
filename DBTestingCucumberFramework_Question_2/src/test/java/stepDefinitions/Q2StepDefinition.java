package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;


public class Q2StepDefinition {
    private static int count=0;
    @Given("{string} {string} {string} should match with database data")
    public void should_match_with_database_data(String month, String total_sales, String staff_id) {
        String query="SELECT DISTINCT( TO_CHAR(rental.rental_date,'Month')) AS Month,\n" +
                "            COUNT(EXTRACT (MONTH FROM rental.rental_date))AS total_sales,staff.staff_id FROM staff\n" +
                "            INNER JOIN rental \n" +
                "            ON staff.staff_id=rental.staff_id\n" +
                "            GROUP BY TO_CHAR((rental.rental_date),'Month'),staff.staff_id\n" +
                "            ORDER BY staff.staff_id";
        List<Map<String, String>> queryResultMap= DBUtils.getQueryResultMap(query);
        Map<String,String> map=queryResultMap.get(count++);
        Assert.assertEquals(map.get("month").trim(),month.trim());
        Assert.assertEquals(map.get("total_sales").trim(),total_sales.trim());
        Assert.assertEquals(map.get("staff_id").trim(),staff_id.trim());

    }
}
