/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.vista;

import com.ejemplosweb.controlador.UsuarioControlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.vo.UsuarioVO;
import com.ejemplosweb.vista.utilidades.RespuestaServlets;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/usuario/insertar", "/usuario/modificar", "/usuario/eliminar", "/usuario/consultar"})
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getServletPath().substring(request.getServletPath().lastIndexOf("/") + 1);

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Gson gson = new Gson();
            
            UsuarioControlador controlUsu = new UsuarioControlador();
            UsuarioVO voUsu = new UsuarioVO();
            String id;
            String nombre;
            String apellido;
            String fechaNacimiento;
            String correo;
            String clave;

            switch (accion) {
                case "insertar":
                    nombre = request.getParameter("nombre");
                    apellido = request.getParameter("apellido");
                    fechaNacimiento = request.getParameter("nacimiento");
                    correo = request.getParameter("correo");
                    clave = request.getParameter("clave");
                    
                    voUsu.setNombreUsuario(nombre);
                    voUsu.setApellidoUsuario(apellido);
                    voUsu.setFechaNacimientoUsuario(formato.parse(fechaNacimiento));
                    voUsu.setCorreoUsuario(correo);
                    voUsu.setClaveUsuario(clave);
                    
    
                    controlUsu.insertar(voUsu);
                    controlUsu.terminarTransaccion();
                    
                    RespuestaServlets respuesta = new RespuestaServlets();
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setDatos(voUsu);
                    
                    String json = gson.toJson(respuesta);
                    out.println(json);
                    
                    break;
                case "modificar":
                    id = request.getParameter("id");
                    nombre = request.getParameter("nombre");
                    apellido = request.getParameter("apellido");
                    fechaNacimiento = request.getParameter("nacimiento");
                    correo = request.getParameter("correo");
                    clave = request.getParameter("clave");
                    
                    voUsu.setIdUsuario(Integer.parseInt(id));
                    voUsu.setNombreUsuario(nombre);
                    voUsu.setApellidoUsuario(apellido);
                    voUsu.setFechaNacimientoUsuario(formato.parse(fechaNacimiento));
                    voUsu.setCorreoUsuario(correo);
                    voUsu.setClaveUsuario(clave);
                    
                    controlUsu.modificar(voUsu);
                    controlUsu.terminarTransaccion();
                    
                    RespuestaServlets respuestaMod = new RespuestaServlets();
                    respuestaMod.setCodigo(1);
                    respuestaMod.setMensaje("OK");
                    respuestaMod.setDatos(voUsu);
                    
                    String jsonMod = gson.toJson(respuestaMod);
                    out.println(jsonMod);
                    break;
                case "eliminar":
                    id = request.getParameter("id");
                    
                    voUsu = controlUsu.consultar(Integer.parseInt(id));
                    controlUsu.borrar(voUsu);
                    controlUsu.terminarTransaccion();
                    
                    RespuestaServlets respuestaBorrar = new RespuestaServlets();
                    respuestaBorrar.setCodigo(1);
                    respuestaBorrar.setMensaje("OK");
                    respuestaBorrar.setDatos(voUsu);
                    
                    String jsonBorrar = gson.toJson(respuestaBorrar);
                    out.println(jsonBorrar);
                    
                    break;
                case "consultar":
                    List<UsuarioVO> listado = controlUsu.consultar();
                    RespuestaServlets respuestaConsulta = new RespuestaServlets();
                    respuestaConsulta.setCodigo(1);
                    respuestaConsulta.setMensaje("OK");
                    respuestaConsulta.setDatos(listado);
                    Gson gsonConsulta = new Gson();
                    String jsonConsulta = gsonConsulta.toJson(respuestaConsulta);
                    out.println(jsonConsulta);
                break;

                default:
                    throw new AssertionError();
            }

        } catch (EjemploMovilesException error) {
            error.printStackTrace();
            RespuestaServlets respuesta = new RespuestaServlets();
            respuesta.setCodigo(500);
            respuesta.setMensaje("Error en Actividad del Servlet");
            respuesta.setDatos(null);

            Gson gson = new Gson();
            String json = gson.toJson(respuesta);
            PrintWriter out;
            out = response.getWriter();
            out.println(json);

        }catch(ParseException e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
