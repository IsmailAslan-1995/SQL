package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_10 {
    public static void answer() throws SQLException {
        //1 - get a connection to DB
        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        //2-create a statement object
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //3- execute a query
        ResultSet resultSet= statement.executeQuery(Constants.TENTH_QUERY);
        //4-process the resultSet
        int count=0;
        while(resultSet.next()){
            count++;
        }
        System.out.println("The number of movies have 3 copies in store 2 is "+count);
    }


}
