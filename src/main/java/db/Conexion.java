package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    /*Ruta y credenciales de nuestra base de datos*/
    private static final String URL = "jdbc:mysql://localhost:3306/MI_FICHA_FAVORITA";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
