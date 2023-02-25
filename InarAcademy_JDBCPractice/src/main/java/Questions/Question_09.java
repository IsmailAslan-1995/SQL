package Questions;

import utilities.ConfigurationsReader;
import utilities.Constants;

import java.sql.*;

public class Question_09 {
    public static  void answer() throws SQLException {

        Connection connection= DriverManager.getConnection(ConfigurationsReader.getProperty("dvdRentalDbURL"),ConfigurationsReader.getProperty("username"),ConfigurationsReader.getProperty("password"));
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        ResultSet resultSet= statement.executeQuery(Constants.NINTH_QUERY);
        System.out.printf("%10s%10s%40s%15s\n","count","film_id","title","copy_number");
        for(int i=0;i<75;i++){
            System.out.print("-");
        }
        System.out.println();
        int count=1;
        while(resultSet.next()){
            System.out.printf("%10d%10s%40s%15s\n",count++,resultSet.getString("film_id"),resultSet.getString("title"),resultSet.getString("copy_number"));

        }
    }
}
