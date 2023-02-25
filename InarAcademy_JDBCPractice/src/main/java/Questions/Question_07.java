package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_07 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.SEVENTH_QUERY);
        System.out.printf("%15s%20s%15s\n","month_name","total_sales","staff_id");
        for(int i=0;i<50;i++){
            System.out.print("-");
        }
        System.out.println();
        while ((resultSet.next())){
            System.out.printf("%15s%20s%15s\n",resultSet.getString("month"),resultSet.getString("total_sales"),resultSet.getString("staff_id"));
        }
    }
}
