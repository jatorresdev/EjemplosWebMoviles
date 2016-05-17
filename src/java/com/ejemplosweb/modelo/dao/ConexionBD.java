package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.GenericoVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class ConexionBD <I extends GenericoVO> {
    
    Connection cnn;
    
    public Connection getCnn(){
        return cnn;
    }
    
    public ConexionBD() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/miniface";
        String usuario = "java";
        String pass = "java1234";
        this.cnn = DriverManager.getConnection(url,usuario,pass);
        this.cnn.setAutoCommit(false);
    }
    
    public void cerrarConexion() throws SQLException{
        cnn.commit();
        cnn.close();
    }
    
    public abstract void insertar(I vo);
    
    public abstract void modificar(I vo);
    
    public abstract void borrar(I vo);
    
    public abstract List<I> consultar();
}
