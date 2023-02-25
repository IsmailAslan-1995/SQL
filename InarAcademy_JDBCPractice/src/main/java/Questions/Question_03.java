package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_03 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.THIRD_QUERY);
        System.out.printf("%15s%15s\n","top_5_categories","film_number");
        for(int i=0;i<30;i++){
            System.out.print("-");
        }
        System.out.println();
        while ((resultSet.next())){
            System.out.printf("%15s%15s\n",resultSet.getString("top_5_categories"),resultSet.getString("film_number"));
        }
    }
}

