/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.EventoVO;
import com.ejemplosweb.modelo.vo.GenericoVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class EventoDAO extends ConexionBD<EventoVO>{

    public EventoDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    @Override
    public void insertar(EventoVO vo) {
        System.out.println("Insertar Event --> " + vo.toString());
    }

    @Override
    public void modificar(EventoVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(EventoVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EventoVO> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
