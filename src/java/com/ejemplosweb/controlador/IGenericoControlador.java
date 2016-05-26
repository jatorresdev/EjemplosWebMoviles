/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.controlador;

import com.ejemplosweb.controlador.excepciones.EjemploMovilesException;
import com.ejemplosweb.modelo.conexion.ConexionBD;
import com.ejemplosweb.modelo.dao.IGenericoDAO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import com.ejemplosweb.utilidades.EMensajesError;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author APRENDIZ
 */
public class IGenericoControlador<I extends IGenericoDAO, J extends IGenericoVO> {

    private I dao;
    private Connection cnn;
    
    public void insertar(J vo) throws EjemploMovilesException {
        try {
            getDao().insertar(vo);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_INSERTAR, ex);
        }
    }

    public void modificar(J vo) throws EjemploMovilesException {
        try {
            getDao().modificar(vo);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_MODIFICAR, ex);
        }
    }

    public void borrar(J vo) throws EjemploMovilesException {
        try {
            getDao().borrar(vo);
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_MODIFICAR, ex);
        }
    }

    public List<J> consultar() throws EjemploMovilesException {
        try {
            return getDao().consultar();
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_MODIFICAR, ex);
        }
    }

    public void terminarTransaccion() throws EjemploMovilesException {
        try {
            ConexionBD.cerrarConexion(this.getCnn());
        } catch (SQLException ex) {
            throw new EjemploMovilesException(EMensajesError.ERROR_DESCONECTANDO_BASE_DATOS, ex);
        }
    }

    /**
     * @return the dao
     */
    protected I getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    protected void setDao(I dao) {
        this.dao = dao;
    }

    /**
     * @return the cnn
     */
    protected Connection getCnn() {
        return cnn;
    }

    /**
     * @param cnn the cnn to set
     */
    protected void setCnn(Connection cnn) {
        this.cnn = cnn;
    }
}
