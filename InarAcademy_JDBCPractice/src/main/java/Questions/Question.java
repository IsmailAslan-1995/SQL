package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question {
    public static void answer() throws SQLException {
        //1 - get a connection to DB
        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        //2-create a statement object
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //3- execute a query

        ResultSet resultSet= statement.executeQuery(Constants.QUERY);

        //4-process the resultSet
        int count=1;
        while(resultSet.next()){
            System.out.println(count++ +" : "+resultSet.getString("title"));

        }
    }
}
