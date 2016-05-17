/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.vo;

/**
 *
 * @author APRENDIZ
 */
public class InvitadoVO implements IGenericoVO {
    private int idInvitado;
    private int idUsuario;
    private int idEvento;

    /**
     * @return the idInvitado
     */
    public int getIdInvitado() {
        return idInvitado;
    }

    /**
     * @param idInvitado the idInvitado to set
     */
    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

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
}
