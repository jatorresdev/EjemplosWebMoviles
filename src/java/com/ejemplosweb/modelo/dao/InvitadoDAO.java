/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.InvitadoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APRENDIZ
 */
public class InvitadoDAO implements IGenericoDAO<InvitadoVO>  {
    
    Connection cnn;

    public InvitadoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(InvitadoVO vo) throws SQLException {
        String sql = "INSERT INTO invitado (id_usuario, id_evento) VALUES (?, ?)";
        PreparedStatement sentencia = cnn.prepareStatement(sql);

        sentencia.setInt(1, vo.getIdUsuario().getIdUsuario());
        sentencia.setInt(2, vo.getIdEvento().getIdEvento());

        sentencia.executeUpdate();
    }

    @Override
    public void modificar(InvitadoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(InvitadoVO vo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InvitadoVO> consultar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
