package com.ejemplosweb.vista.rest;

import com.ejemplosweb.controlador.UsuarioControlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jatorresdev
 */
@Path("usuario")
public class UsuarioResource {
    
    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of UsuarioResource
     */
    public UsuarioResource() {
    }
    
    /**
     * Retrieves representation of an instance of com.ejemplosweb.UsuarioResource
     * @return an instance of com.ejemplosweb.modelo.vo.UsuarioVO
     */
    @GET
    //@Path("consultar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioVO> consultarUsuarios() throws EjemploMovilesException {
        UsuarioControlador control = new UsuarioControlador();
        return control.consultar();
    }
    
    @GET
    @Path("consultar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioVO consultarUsuario(@PathParam("id") int id) throws EjemploMovilesException{
        UsuarioControlador controlUsu = new UsuarioControlador();
        UsuarioVO voUsu = controlUsu.consultar(id);
        
        return voUsu;
    }
    
    @PUT
    @Path("/modificar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public UsuarioVO actualizarUsuario(@FormParam("id") int id,
            @FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("correo") String correo,
            @FormParam("clave") String clave) throws EjemploMovilesException, ParseException {
        
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
    
    @POST
    @Path("/insertar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public UsuarioVO insertarUsuario(@FormParam("nombre") String nombre,
            @FormParam("apellido") String apellido,
            @FormParam("fechaNacimiento") String fechaNacimiento,
            @FormParam("correo") String correo,
            @FormParam("clave") String clave) throws EjemploMovilesException, ParseException {
        
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
    
    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioVO eliminarUsuario(@PathParam("id") int id) throws EjemploMovilesException{
        UsuarioControlador controlUsu = new UsuarioControlador();
        UsuarioVO voUsu = controlUsu.consultar(id);
        controlUsu.borrar(voUsu);
        controlUsu.terminarTransaccion();
        
        return voUsu;
    }
}
