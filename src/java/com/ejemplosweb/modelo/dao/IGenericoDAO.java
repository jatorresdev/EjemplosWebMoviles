/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.IGenericoVO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Fabian
 */
public interface IGenericoDAO<I extends IGenericoVO> {
    
    
    public void insertar(I vo);

    public void modificar(I vo);

    public void borrar(I vo);

    public List<I> consultar();

}
