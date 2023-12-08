package ConexionBD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection conection = null;
    String user = "root";
    String password = "xtab781+"; 
    String database = "gameshop_final";
    String ip = "localhost";
    String puerto = "3306";

    String dir = "jdbc:mysql://" + ip + ":" + puerto + "/" + database;

    public Connection setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection(dir, user, password);
            //System.out.println("Conexion exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Conexion FALLIDA");
        }
        return conection;
    }

    public void closeConnection() {
        try {
            if (conection != null) {
                conection.close();
            }
        } catch (SQLException e) {
        }
    }
}
