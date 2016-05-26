 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.controlador.excepciones;

import com.ejemplosweb.utilidades.EMensajesError;

/**
 *
 * @author APRENDIZ
 */
public class EjemploMovilesException extends Exception {
    private String mensaje;
    
    public EjemploMovilesException(EMensajesError message, Throwable cause) {
        super(message.getMensaje() + cause.getMessage(), cause);
        this.mensaje = message.getMensaje();
    }

    public String getMensaje() {
        return mensaje;
    }
    
}
