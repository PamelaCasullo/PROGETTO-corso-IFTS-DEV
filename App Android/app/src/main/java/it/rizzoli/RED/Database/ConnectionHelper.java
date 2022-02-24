package it.rizzoli.RED.Database;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionHelper {

    String uname, passw, ip, port, database;


    public Connection connectionClass() throws ClassNotFoundException, SQLException {
        ip = "lorenzodns.ddns.net";
        database = "RED";
        uname = "userRED";
        passw = "^XMX^Xt4dG3Kh4%e$4ErwZU#6";
        port = "3306";
        Class.forName("com.mysql.cj.jdbc.Driver");
        StrictMode.ThreadPolicy pol = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);

        Connection connection = null;
        String connURL = null;

        Class.forName("com.mysql.jdbc.Driver");
        connURL = "jdbc:mysql://" + ip + ":" + port + ";" + "databasename=" + database + ";user=" + uname + ";password=" + passw;
        connection = DriverManager.getConnection(connURL);

        return connection;

        //return conn;
    }
}
