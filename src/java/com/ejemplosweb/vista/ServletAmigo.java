/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.vista;

import com.ejemplosweb.controlador.AmigoControlador;
import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.vista.utilidades.RespuestaServlets;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletAmigo", urlPatterns = {"/amigo/insertar", "/amigo/modificar", "/amigo/eliminar", "/amigo/consultar"})
public class ServletAmigo extends HttpServlet {

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

            AmigoControlador controlAmigo = new AmigoControlador();

            switch (accion) {
                case "insertar":
                    out.println("Inserttando");
                    RespuestaServlets respuesta = new RespuestaServlets();
                    respuesta.setCodigo(500);
                    respuesta.setMensaje("Probando Insert");
                    respuesta.setDatos(null);
                    Gson gson = new Gson();
                    String json = gson.toJson(respuesta);
                    out.println(json);
                    break;
                case "modificar":
                    out.println("Modificando * * ** * ** ");
                    break;
                case "eliminar":
                    out.println("Eliminando");
                    break;
                case "consultar":
                    List<AmigoVO> listado = controlAmigo.consultar();
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
