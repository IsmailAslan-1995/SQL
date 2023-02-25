package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_01 {
    public static void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet= statement.executeQuery(Constants.FIRST_QUERY);
        System.out.printf("%25s%30s\n","full_name","rental_date");
        for(int i=0;i<55;i++){
            System.out.print("-");
        }
        System.out.println();
        while ((resultSet.next())){
            System.out.printf("%25s%30s\n",resultSet.getString("full_name"),resultSet.getString("rental_date"));
        }
    }

}

