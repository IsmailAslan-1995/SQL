package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_00 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("exercisesDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet=statement.executeQuery(Constants.ZEROTH_QUERY);
        while(resultSet.next()){
            System.out.println(resultSet.getString("month")+ "\t"+resultSet.getString("member_amount"));

        }
    }
}
