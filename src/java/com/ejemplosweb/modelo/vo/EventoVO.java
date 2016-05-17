/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.vo;

import java.util.Date;

/**
 *
 * @author APRENDIZ
 */
public class EventoVO implements IGenericoVO {
    private int idEvento;
    private Date fechaEvento;
    private String lugarEvento;
    private Date horaEvento;
    private String nombreEvento;
    private String nombreCreador;

    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the fechaEvento
     */
    public Date getFechaEvento() {
        return fechaEvento;
    }

    /**
     * @param fechaEvento the fechaEvento to set
     */
    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    /**
     * @return the lugarEvento
     */
    public String getLugarEvento() {
        return lugarEvento;
    }

    /**
     * @param lugarEvento the lugarEvento to set
     */
    public void setLugarEvento(String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    /**
     * @return the horaEvento
     */
    public Date getHoraEvento() {
        return horaEvento;
    }

    /**
     * @param horaEvento the horaEvento to set
     */
    public void setHoraEvento(Date horaEvento) {
        this.horaEvento = horaEvento;
    }

    /**
     * @return the nombreEvento
     */
    public String getNombreEvento() {
        return nombreEvento;
    }

    /**
     * @param nombreEvento the nombreEvento to set
     */
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    /**
     * @return the nombreCreador
     */
    public String getNombreCreador() {
        return nombreCreador;
    }

    /**
     * @param nombreCreador the nombreCreador to set
     */
    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }
}
