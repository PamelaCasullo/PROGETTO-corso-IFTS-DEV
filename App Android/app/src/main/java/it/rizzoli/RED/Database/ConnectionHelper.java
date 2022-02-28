package it.rizzoli.RED.Database;


import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*TODO look at https://github.com/wynsryd/android-mysql-example for help*/

public class ConnectionHelper {


    String DNS = "lorenzodns.ddns.net";
    String DATABASE = "RED";
    String USERNAME = "userRED";
    String PASSWORD = "^XMX^Xt4dG3Kh4%e$4ErwZU#6";
    String PORT = "3306";

    private static ConnectionHelper _instance;

    public static ConnectionHelper getInstance() {
        if(_instance == null) _instance = new ConnectionHelper();
        return _instance;
    }

    private Connection connection;

    public ConnectionHelper() {
        StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://lorenzodns.ddns.net:3306/RED",USERNAME,PASSWORD);
            Log.e("Info","Connection Opened");
        } catch (SQLException | ClassNotFoundException exception) {
            Log.e("Error","ERROR");
            exception.printStackTrace();
        }

    }
    public Connection getConnection() {
        return connection;
    }

}
