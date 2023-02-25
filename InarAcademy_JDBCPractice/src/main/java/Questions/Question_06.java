package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_06 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.SIXTH_QUERY);
        System.out.printf("%15s%15s%15s%10s\n","customer_id","first_name","last_name","amount");
        for(int i=0;i<55;i++){
            System.out.print("-");
        }
        System.out.println();

        while (resultSet.next()){
            System.out.printf("%15s%15s%15s%10s\n",resultSet.getString("customer_id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("amount"));
        }
    }
}
