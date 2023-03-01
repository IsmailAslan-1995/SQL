package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DBUtils;
import utilities.Driver;

public class Hooks {
    @Before
    public void setup(){
        System.out.println("I am setting up the test from the Hooks class!!!");

    }
    @Before ("@db")
    public void setupConnection(){
        System.out.println("I am setting up the DB Connection!!!");

        DBUtils.createConnection();
    }
    @After("@db")
    public void tearDownDBConnection(){
        System.out.println("I am closing the DB Connection!!!");
        DBUtils.destroy();
    }
    @After
    public  void tearDown(Scenario scenario){
        System.out.println("I am reporting the results");
        if(scenario.isFailed()){
            final byte[] screenshot= ((TakesScreenshot)(Driver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Screenshot");
        }
        System.out.println("Closing driver");
        Driver.closeDriver();

    }
}
