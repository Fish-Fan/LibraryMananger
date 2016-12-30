package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by yanfeng-mac on 2016/12/29.
 */
public class ConnectionMananger {
    public static Connection getConnection() {
       Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///RUNOOB","root","1225");

        }
        catch (Exception exc){
            exc.printStackTrace();
        }
        return connection;

    }
}
