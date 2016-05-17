/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.modelo.vo.EventoVO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import com.sun.xml.rpc.encoding.GenericObjectSerializer;
import java.sql.Connection;
import java.util.ArrayList;

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
            //new ConexionBD();
            
             Connection cnn = ConexionBD.obtenerConexionBD();
            
            UsuarioDAO daoUsu = new UsuarioDAO(cnn);
            UsuarioVO voUsu = new UsuarioVO();
            EventoVO voEvent = new EventoVO();
            AmigoVO voAmigo = new AmigoVO();
            daoUsu.insertar(voUsu);
            EventoDAO daoEvent = new EventoDAO(cnn);
            AmigoDAO daoAmi = new AmigoDAO(cnn);
            daoAmi.insertar(voAmigo);
            daoEvent.insertar(voEvent);

            ConexionBD.cerrarConexion(cnn);
            
            
        }catch(ClassNotFoundException e){
            System.out.println("No se encontro el Driver de Mysql");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    
}
