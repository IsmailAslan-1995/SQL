package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_08 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.EIGHTH_QUERY);
        while(resultSet.next()){
            System.out.println("address : "+resultSet.getString("address")+"\ncity    : "+resultSet.getString("city")+"\ncountry : "+resultSet.getString("country"));

        }

    }
}
