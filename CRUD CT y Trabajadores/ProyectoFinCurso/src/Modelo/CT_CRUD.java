package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CT_CRUD {

    Conexion conexion;

    public CT_CRUD() {
        conexion = new Conexion();
    }

    public String insertCT(int ID, String nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {
        String rptaRegistro = null;

        try {
            Connection accesoDB = conexion.getConnection();
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("(CALL P_INSERT_CT(?,?,?,?,?,?,?,?) ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, ID);
            cs.setString(2, nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro insertado";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }

    public ArrayList<CT> listCT() {
        ArrayList listaCT = new ArrayList();
        CT ct;
        try {
            Connection accesoDB = conexion.getConnection();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CENTRO_TRABAJO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct = new CT();
                ct.setID(rs.getInt(1));
                ct.setNombre(rs.getString(2));
                ct.setCalle(rs.getString(3));
                ct.setNumero(rs.getInt(4));
                ct.setCp(rs.getString(5));
                ct.setCiudad(rs.getString(6));
                ct.setProvincia(rs.getString(7));
                ct.setTelefono(rs.getString(8));
                listaCT.add(ct);
            }

        } catch (Exception e) {

        }
        return listaCT;
    }

    public int editarCT(String nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {
        int numFil = 0;

        try {
            Connection accesoDB = conexion.getConnection();
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO EDICION(?,?,?,?,?,?,?) ");
            cs.setString(1, nombre);
            cs.setString(2, calle);
            cs.setInt(3, numero);
            cs.setString(4, cp);
            cs.setString(5, ciudad);
            cs.setString(6, provincia);
            cs.setString(7, telefono);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public int eliminarCT(String nombre) {
        int numFil = 0;

        try {
            Connection accesoDB = conexion.getConnection();
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO BORRADO(?) ");
            cs.setString(1,nombre);

            numFil = cs.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<CT> buscarCTxNombre(String nombre) {
        ArrayList<CT> listaCT = new ArrayList();
        CT ct;
        try {
            Connection accesoDB = conexion.getConnection();
            CallableStatement cs = accesoDB.prepareCall("(CALL PROCEDIMIENTO BUSQUEDA(?) ");
            cs.setString(1, nombre);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ct = new CT();
                ct.setID(rs.getInt(1));
                ct.setNombre(rs.getString(2));
                ct.setCalle(rs.getString(3));
                ct.setNumero(rs.getInt(4));
                ct.setCp(rs.getString(5));
                ct.setCiudad(rs.getString(6));
                ct.setProvincia(rs.getString(7));
                ct.setTelefono(rs.getString(8));
                listaCT.add(ct);
            }

        } catch (Exception e) {

        }
        return listaCT;
    }

}
