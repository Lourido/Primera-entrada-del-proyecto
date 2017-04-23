package Modelo;

import java.sql.*;

public class Conexion {

    public Conexion() {

    }

    public Connection getConnection() {
        Connection con = null;

        try {
            String className = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@//192.168.56.101:1521/xe";
            String user = "SYSTEM";
            String password = "root";

            Class.forName(className).newInstance();
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {

        }
        return con;
    }
}
