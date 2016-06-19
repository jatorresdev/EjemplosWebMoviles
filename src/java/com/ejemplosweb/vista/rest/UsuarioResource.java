package com.ejemplosweb.vista.rest;

import com.ejemplosweb.controlador.UsuarioControlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jatorresdev
 */
@Path("Usuario")
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
    @Path("usuarios") 
    @Produces(MediaType.APPLICATION_JSON)
    public List<UsuarioVO> getListaUsuarios() throws EjemploMovilesException {
        try {
            //TODO return proper representation object
            UsuarioControlador control = new UsuarioControlador();
            return control.consultar();
        } catch (EjemploMovilesException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    
    /**
     * PUT method for updating or creating an instance of UsuarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(UsuarioVO content) {
    }
}
