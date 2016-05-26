/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.utilidades;

/**
 *
 * @author APRENDIZ
 */
public enum EMensajesError {
    ERROR_BASE_DATOS("Error intentando conectar a la base de datos"),
    ERROR_DESCONECTANDO_BASE_DATOS("Error intentando desconectar a la base de datos"),
    ERROR_INSERTAR("Error al intentar insertar datos en la base de datos"),
    ERROR_MODIFICAR("Error al intentar modificar datos en la base de datos"),
    ERROR_BORRAR("Error al intentar borrar los datos en la base de datos"),
    ERROR_CONSULTAR("Error al intentar consultar los datos en la base de datos"),
    ERROR_DRIVER_NO_ENCONTRADO("Error: Driver base de datos no encontrado");
    
    String mensaje;
    
    private EMensajesError(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getMensaje() {
        return mensaje;
    }
}
