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
public class AmigoVO implements IGenericoVO {
    private UsuarioVO idUsuario1;
    private UsuarioVO idUsuario2;

    /**
     * @return the idUsuario1
     */
    public UsuarioVO getIdUsuario1() {
        return idUsuario1;
    }

    /**
     * @param idUsuario1 the idUsuario1 to set
     */
    public void setIdUsuario1(UsuarioVO idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    /**
     * @return the idUsuario2
     */
    public UsuarioVO getIdUsuario2() {
        return idUsuario2;
    }

    /**
     * @param idUsuario2 the idUsuario2 to set
     */
    public void setIdUsuario2(UsuarioVO idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }
}
