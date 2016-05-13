package com.ejemplosweb.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author APRENDIZ
 */
public class ConexionBD {
    Connection cnn;
    
    public ConexionBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Connection");
        String url = "jdbc:mysql://localhost/miniface";
        String usuario = "java";
        String pass = "java1234";
        
        this.cnn = DriverManager.getConnection(url, usuario, pass);
    }
    
}
