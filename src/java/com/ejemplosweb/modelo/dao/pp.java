/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.modelo.vo.EventoVO;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import com.ejemplosweb.modelo.vo.InvitadoVO;
import java.sql.Connection;
import java.text.SimpleDateFormat;

/**
 *
 * @author Fabian
 */
public class pp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection cnn = ConexionBD.obtenerConexionBD();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a");
            
            System.out.println("Iniciando");
            
            // Usuario
            UsuarioVO voUsu = new UsuarioVO();
            voUsu.setNombreUsuario("Angel");
            voUsu.setApellidoUsuario("Torres");
            voUsu.setCorreoUsuario("jatorresdev@gmail.com");
            voUsu.setClaveUsuario("123456");
            voUsu.setFechaNacimientoUsuario(formato.parse("20/12/1990"));
            
            UsuarioVO voUsu2 = new UsuarioVO();
            voUsu2.setNombreUsuario("Christian");
            voUsu2.setApellidoUsuario("Valbuena");
            voUsu2.setCorreoUsuario("cavalbuena@misena.edu.co");
            voUsu2.setClaveUsuario("12345678");
            voUsu2.setFechaNacimientoUsuario(formato.parse("21/12/1990"));
            
            UsuarioDAO daoUsu = new UsuarioDAO(cnn);
            daoUsu.insertar(voUsu);
            
            UsuarioDAO daoUsu2 = new UsuarioDAO(cnn);
            daoUsu2.insertar(voUsu2);
            
            // Evento
            EventoVO voEvent = new EventoVO();
            voEvent.setFechaEvento(formato.parse("23/05/2016"));
            voEvent.setLugarEvento("Sena 53");
            voEvent.setHoraEvento(formatoHora.parse("05:30 pm"));
            voEvent.setNombreEvento("Arquitectura");
            voEvent.setNombreCreador("Fabian P");
            
            EventoDAO daoEvent = new EventoDAO(cnn);
            daoEvent.insertar(voEvent);
            
            // Amigo
            AmigoVO voAmigo = new AmigoVO();
            voAmigo.setIdUsuario1(voUsu);
            voAmigo.setIdUsuario2(voUsu2);

            AmigoDAO daoAmi = new AmigoDAO(cnn);
            daoAmi.insertar(voAmigo);
            
            // Invitado
            InvitadoVO voInvitado = new InvitadoVO();
            voInvitado.setIdUsuario(voUsu2);
            voInvitado.setIdEvento(voEvent);
            
            InvitadoDAO daoInvitado = new InvitadoDAO(cnn);
            daoInvitado.insertar(voInvitado);
           
            ConexionBD.cerrarConexion(cnn);
            
            System.out.println("Fin");

        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro el Driver de Mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
