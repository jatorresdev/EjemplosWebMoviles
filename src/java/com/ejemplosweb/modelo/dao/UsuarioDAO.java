/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

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
public class UsuarioDAO implements IGenericoDAO<UsuarioVO> {

    Connection cnn;

    public UsuarioDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(UsuarioVO vo) throws SQLException {
        String sql = "INSERT INTO usuario (nombre_usuario, apellido_usuario,"
                + "fecha_nacimiento_usuario, correo_usuario, clave_usuario) VALUES (?,?,?,?,?)";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        sentencia.setString(1, vo.getNombreUsuario());
        sentencia.setString(2, vo.getApellidoUsuario());
        sentencia.setDate(3, new java.sql.Date(vo.getFechaNacimientoUsuario().getTime()));
        sentencia.setString(4, vo.getCorreoUsuario());
        sentencia.setString(5, vo.getClaveUsuario());

        sentencia.executeUpdate();

        try (ResultSet generatedKeys = sentencia.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                vo.setIdUsuario(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("No ID");
            }
        } catch (Exception e) {
            throw new SQLException("Error al registrar usuario");
        }
    }

    @Override
    public void modificar(UsuarioVO vo) throws SQLException {
        String sql = "UPDATE usuario SET nombre_usuario = ?, apellido_usuario = ?,"
                + "fecha_nacimiento_usuario = ?, correo_usuario = ?, clave_usuario = ? WHERE id_usuario = ?";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        sentencia.setString(1, vo.getNombreUsuario());
        sentencia.setString(2, vo.getApellidoUsuario());
        sentencia.setDate(3, new java.sql.Date(vo.getFechaNacimientoUsuario().getTime()));
        sentencia.setString(4, vo.getCorreoUsuario());
        sentencia.setString(5, vo.getClaveUsuario());
        sentencia.setInt(6, vo.getIdUsuario());

        sentencia.executeUpdate();
    }

    @Override
    public void borrar(UsuarioVO vo) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        sentencia.setInt(1, vo.getIdUsuario());

        sentencia.executeUpdate();
    }

    @Override
    public List<UsuarioVO> consultar() throws SQLException {
        String sql = "SELECT * FROM usuario";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();

        while (resultado.next()) {
            UsuarioVO vo = new UsuarioVO();

            vo.setIdUsuario(resultado.getInt("id_usuario"));
            vo.setNombreUsuario(resultado.getString("nombre_usuario"));
            vo.setApellidoUsuario(resultado.getString("apellido_usuario"));
            vo.setFechaNacimientoUsuario(resultado.getDate("fecha_nacimiento_usuario"));
            vo.setCorreoUsuario(resultado.getString("correo_usuario"));
            vo.setClaveUsuario(resultado.getString("clave_usuario"));
            
            listaUsuarios.add(vo);
        }

        if (listaUsuarios.size() == 0) {
            return null;
        }

        return listaUsuarios;
    }

    public UsuarioVO consultar(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        PreparedStatement sentencia = cnn.prepareStatement(sql);
        sentencia.setInt(1, idUsuario);
        ResultSet resultado = sentencia.executeQuery();

        if (resultado.next()) {
            UsuarioVO vo = new UsuarioVO();

            vo.setIdUsuario(resultado.getInt("id_usuario"));
            vo.setNombreUsuario(resultado.getString("nombre_usuario"));
            vo.setApellidoUsuario(resultado.getString("apellido_usuario"));
            vo.setFechaNacimientoUsuario(resultado.getDate("fecha_nacimiento_usuario"));
            vo.setCorreoUsuario(resultado.getString("correo_usuario"));
            vo.setClaveUsuario(resultado.getString("clave_usuario"));

            return vo;
        }

        return null;
    }
}
