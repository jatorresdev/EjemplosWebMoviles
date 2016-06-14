/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.ejemplosweb.vista.ws;

import com.ejemplosweb.controlador.UsuarioControlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author APRENDIZ
 */
@WebService(serviceName = "UsuarioWebService")
public class UsuarioWebService {
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "insertar")
    public UsuarioVO insertar(@WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "fechaNacimiento") String fechaNacimiento,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "clave") String clave) throws EjemploMovilesException, ParseException {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        UsuarioVO voUsu = new UsuarioVO();
        voUsu.setNombreUsuario(nombre);
        voUsu.setApellidoUsuario(apellido);
        voUsu.setFechaNacimientoUsuario(formato.parse(fechaNacimiento));
        voUsu.setCorreoUsuario(correo);
        voUsu.setClaveUsuario(clave);
        
        UsuarioControlador controlUsu = new UsuarioControlador();
        controlUsu.insertar(voUsu);
        controlUsu.terminarTransaccion();
        
        return voUsu;
    }
    
    @WebMethod(operationName = "modificar")
    public UsuarioVO modificar(@WebParam(name = "id") int id,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "fechaNacimiento") String fechaNacimiento,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "clave") String clave) throws EjemploMovilesException, ParseException {
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        UsuarioVO voUsu = new UsuarioVO();
        voUsu.setIdUsuario(id);
        voUsu.setNombreUsuario(nombre);
        voUsu.setApellidoUsuario(apellido);
        voUsu.setFechaNacimientoUsuario(formato.parse(fechaNacimiento));
        voUsu.setCorreoUsuario(correo);
        voUsu.setClaveUsuario(clave);
        
        UsuarioControlador controlUsu = new UsuarioControlador();
        controlUsu.modificar(voUsu);
        controlUsu.terminarTransaccion();
        
        return voUsu;
    }
    
    @WebMethod(operationName = "eliminar")
    public UsuarioVO eliminar(@WebParam(name = "id") int id) throws EjemploMovilesException {
        UsuarioControlador controlUsu = new UsuarioControlador();
        UsuarioVO voUsu = controlUsu.consultar(id);
        controlUsu.borrar(voUsu);
        controlUsu.terminarTransaccion();
        
        return voUsu;
    }
    
    @WebMethod(operationName = "consultarTodos")
    public List<UsuarioVO> consultarTodos() throws EjemploMovilesException {
        UsuarioControlador controlUsu = new UsuarioControlador();
        List<UsuarioVO> lista = controlUsu.consultar();
        
        return lista;
    }
    
    @WebMethod(operationName = "consultar")
    public UsuarioVO consultar(@WebParam(name = "id") int id) throws EjemploMovilesException {
        UsuarioControlador controlUsu = new UsuarioControlador();
        UsuarioVO voUsu = controlUsu.consultar(id);
        
        return voUsu;
    }
}
