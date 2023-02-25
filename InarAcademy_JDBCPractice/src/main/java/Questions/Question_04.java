package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_04 {
    public static void answer() throws SQLException {


        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.FOURTH_QUERY);
        System.out.printf("%15s%20s%25s\n","country_id","country","total_payment_amount");
        for(int i=0;i<60;i++){
            System.out.print("-");
        }
        System.out.println();
        while ((resultSet.next())){
            System.out.printf("%15s%20s%25s\n",resultSet.getString("country_id"),resultSet.getString("country"),resultSet.getString("total_payment_amount"));
        }
    }
}
