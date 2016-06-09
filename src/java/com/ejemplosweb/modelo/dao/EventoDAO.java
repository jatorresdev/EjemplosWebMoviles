/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.EventoVO;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            } else {
                throw new SQLException("No ID");
            }
        } catch (Exception e) {
            throw new SQLException("Error al registrar Evento");
        }
    }

    @Override
    public void modificar(EventoVO vo) throws SQLException {
        String sql = "UPDATE evento SET fecha_evento = ?, lugar_evento = ?,"
                + "hora_evento = ?, nombre_evento = ?, nombre_creador = ? WHERE id_evento = ?";
        PreparedStatement sentencia = cnn.prepareStatement(sql);

        sentencia.setDate(1, new java.sql.Date(vo.getFechaEvento().getTime()));
        sentencia.setString(2, vo.getLugarEvento());
        sentencia.setTime(3, new java.sql.Time(vo.getHoraEvento().getTime()));
        sentencia.setString(4, vo.getNombreEvento());
        sentencia.setString(5, vo.getNombreCreador());
        sentencia.setInt(6, vo.getIdEvento());

        sentencia.executeUpdate();
    }

    @Override
    public void borrar(EventoVO vo) throws SQLException {
        String sql = "DELETE FROM evento WHERE id_evento = ?";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        sentencia.setInt(1, vo.getIdEvento());

        sentencia.executeUpdate();
    }

    @Override
    public List<EventoVO> consultar() throws SQLException {
        String sql = "SELECT * FROM evento";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        ArrayList<EventoVO> listaEventos = new ArrayList<>();

        while (resultado.next()) {
            EventoVO vo = new EventoVO();

            vo.setIdEvento(resultado.getInt("id_evento"));
            vo.setFechaEvento(resultado.getDate("fecha_evento"));
            vo.setLugarEvento(resultado.getString("lugar_evento"));
            vo.setHoraEvento(resultado.getDate("hora_evento"));
            vo.setNombreEvento(resultado.getString("nombre_evento"));
            vo.setNombreCreador(resultado.getString("nombre_creador"));
            
            listaEventos.add(vo);
        }

        if (listaEventos.size() == 0) {
            return null;
        }

        return listaEventos;
    }

    public EventoVO consultar(int idEvento) throws SQLException {
        String sql = "SELECT * FROM evento WHERE id_evento = ?";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        sentencia.setInt(1, idEvento);
        ResultSet resultado = sentencia.executeQuery();

        ArrayList<EventoVO> listaEventos = new ArrayList<>();

        if (resultado.next()) {
            EventoVO vo = new EventoVO();

            vo.setIdEvento(resultado.getInt("id_evento"));
            vo.setFechaEvento(resultado.getDate("fecha_evento"));
            vo.setLugarEvento(resultado.getString("lugar_evento"));
            vo.setHoraEvento(resultado.getDate("hora_evento"));
            vo.setNombreEvento(resultado.getString("nombre_evento"));
            vo.setNombreCreador(resultado.getString("nombre_creador"));

            return vo;
        }

        return null;
    }
}
