package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection(){
        try {
            connection= DriverManager.getConnection(ConfigReader.getProperty("DBurl"),ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
            System.out.println("DB Connection is created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void executeQuery(String query){
        try {
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet=statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void destroy(){

        if (resultSet != null) {

            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
    public static List<Map<String,String>> getQueryResultMap(String query){
        executeQuery(query);
        List<Map<String,String>> rowList=new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd=resultSet.getMetaData();
            while (resultSet.next()){
                Map<String,String> colNameValueMAp=new HashMap<>();
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    colNameValueMAp.put(rsmd.getColumnName(i),resultSet.getString(i));
                }
                rowList.add(colNameValueMAp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowList;
    }
}


