package com.ejemplosweb.modelo.dao;

import com.ejemplosweb.modelo.vo.AmigoVO;
import com.ejemplosweb.modelo.vo.IGenericoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AmigoDAO implements IGenericoDAO<AmigoVO> {

    Connection cnn;

    public AmigoDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(AmigoVO vo) throws SQLException {
        String sql = "INSERT INTO amigo (id_usuario1, id_usuario2) VALUES (?,?)";
        PreparedStatement sentencia = cnn.prepareStatement(sql);

        sentencia.setInt(1, vo.getIdUsuario1().getIdUsuario());
        sentencia.setInt(2, vo.getIdUsuario2().getIdUsuario());

        sentencia.executeUpdate();
    }

    @Override
    public void modificar(AmigoVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(AmigoVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AmigoVO> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
