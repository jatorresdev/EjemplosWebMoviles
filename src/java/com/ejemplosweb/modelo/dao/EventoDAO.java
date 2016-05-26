/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.EventoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabian
 */
public class EventoDAO implements IGenericoDAO<EventoVO> {

    Connection cnn;

    public EventoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(EventoVO vo) throws SQLException {
        String sql = "INSERT INTO evento (fecha_evento, lugar_evento,"
                + "hora_evento, nombre_evento, nombre_creador) VALUES (?,?,?,?,?)";
        PreparedStatement sentencia = cnn.prepareStatement(sql);

        sentencia.setDate(1, new java.sql.Date(vo.getFechaEvento().getTime()));
        sentencia.setString(2, vo.getLugarEvento());
        sentencia.setTime(3, new java.sql.Time(vo.getHoraEvento().getTime()));
        sentencia.setString(4, vo.getNombreEvento());
        sentencia.setString(5, vo.getNombreCreador());

        sentencia.executeUpdate();
        
        try (ResultSet generatedKeys = sentencia.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                vo.setIdEvento(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("No ID");
            }
        } catch (Exception e) {
            throw new SQLException("Error al registrar Evento");
        }
    }

    @Override
    public void modificar(EventoVO vo) {
//        String sql = "UPDATE evento SET fecha_evento = ?, lugar_evento = ?,"
//                + "hora_evento = ?, nombre_evento = ?, nombre_creador = ? WHERE id_usuario = ?";
//        PreparedStatement sentencia = cnn.prepareStatement(sql);
//        sentencia.setString(1, vo.getNombreUsuario());
//        sentencia.setString(2, vo.getApellidoUsuario());
//        sentencia.setDate(3, new java.sql.Date(vo.getFechaNacimientoUsuario().getTime()));
//        sentencia.setString(4, vo.getCorreoUsuario());
//        sentencia.setString(5, vo.getClaveUsuario());
//        sentencia.setInt(6, vo.getIdUsuario());
//
//        sentencia.executeUpdate();
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
