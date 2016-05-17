/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.GenericoVO;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class UsuarioDAO extends ConexionBD<UsuarioVO>{

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        super();
        this.getCnn();
    }

    @Override
    public void insertar(UsuarioVO vo) {
        System.out.println("Insertar Usua --> " + vo.toString());
    }

    @Override
    public void modificar(UsuarioVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(UsuarioVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsuarioVO> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
