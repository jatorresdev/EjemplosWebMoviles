package com.ejemplosweb.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection obtenerConexionBD() throws ClassNotFoundException, SQLException {
        Connection cnn;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/miniface";
        String usuario = "java";
        String pass = "java1234";
        cnn = DriverManager.getConnection(url, usuario, pass);
        cnn.setAutoCommit(false);
        return cnn;
    }

    public static void cerrarConexion(Connection cnn) throws SQLException {
        cnn.commit();
        cnn.close();
    }

}
