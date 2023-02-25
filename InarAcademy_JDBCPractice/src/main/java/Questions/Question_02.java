package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_02 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.SECOND_QUERY);
        System.out.printf("%15s%15s%50s\n","first_name","username","password");
        for(int i=0;i<80;i++){
            System.out.print("-");
        }
        System.out.println();
        while ((resultSet.next())){
            System.out.printf("%15s%15s%50s\n",resultSet.getString("first_name"),resultSet.getString("username"),resultSet.getString("password"));
        }
    }
}
