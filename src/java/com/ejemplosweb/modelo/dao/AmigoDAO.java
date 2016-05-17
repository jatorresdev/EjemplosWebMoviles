package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AmigoDAO implements IGenericoDAO<AmigoVO>{

    Connection cnn;

    public AmigoDAO(Connection cnn) {
        this.cnn = cnn;
    }
     
     
    
    public boolean agregarDatos(){
        return false;
    }

    @Override
    public void insertar(AmigoVO vo) {
       System.out.println("Insertar Amigo --> " + vo.toString());
    }

    @Override
    public void modificar(AmigoVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(AmigoVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AmigoVO> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
}
