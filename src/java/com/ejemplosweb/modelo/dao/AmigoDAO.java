package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.modelo.vo.GenericoVO;
import java.sql.SQLException;
import java.util.List;

public class AmigoDAO extends ConexionBD<AmigoVO>{

    public AmigoDAO() throws ClassNotFoundException, SQLException {
        super();
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
