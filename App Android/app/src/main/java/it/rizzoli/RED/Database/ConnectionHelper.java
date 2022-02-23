package it.rizzoli.RED.Database;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {

    Connection conn;
    String uname, passw, ip, port, database;

    public Connection connectionClass() {
        ip="lorenzodns.ddns.net";
        database="RED";
        uname="userRED";
        passw="^XMX^Xt4dG3Kh4%e$4ErwZU#6";
        port="3306";

        StrictMode.ThreadPolicy pol =  new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(pol);

        Connection connection = null;
        String connURL = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connURL="jdbc:mysql://"+ip+":"+port+";"+"databasename="+database+";user="+uname+";password="+passw;
            connection= DriverManager.getConnection(connURL);



        }catch (Exception exceptionx) {
            Log.e("Error",exceptionx.getMessage());
        }

        return connection;


    }
}
