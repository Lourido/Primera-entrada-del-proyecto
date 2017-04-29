package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CT_CRUD {


    public CT_CRUD() {
    }

    @SuppressWarnings("UseSpecificCatch")
    
    public String insertCT(int Id, String P_CT_nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {
        
        String rptaRegistro = null;
        
        try {
            Connection accesoDB = Conexion.getConexion();
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_CT(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, Id);
            cs.setString(2, P_CT_nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaRegistro = "Registro ACTUALIZADO";               
            }

            Conexion.exitConexion();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return rptaRegistro;
    }

    public ArrayList<CT> listCT() {
        ArrayList listaCT = new ArrayList();
        CT ct;
        try {
            Connection accesoDB = Conexion.getConexion();
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
            Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaCT;
    }

    public String editarCT(int Id, String nombre, String calle, int numero, String cp, String ciudad, String provincia, String telefono) {
        
        String rptaEdit =null;
        int numFil = 0;

        try {
            Connection accesoDB = Conexion.getConexion();
            
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_CT(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setInt(1, Id);
            cs.setString(2, nombre);
            cs.setString(3, calle);
            cs.setInt(4, numero);
            cs.setString(5, cp);
            cs.setString(6, ciudad);
            cs.setString(7, provincia);
            cs.setString(8, telefono);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";               
            }

            Conexion.exitConexion();
        
        } catch (Exception e) {
        }
        
        return rptaEdit;
    }

    public int eliminarCT(int Id) {
        int numFil = 0;

        try {
            Connection accesoDB = Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_CT(?)}");
            cs.setInt(1,Id);

            numFil = cs.executeUpdate();
            Conexion.exitConexion();

        } catch (SQLException ex) {
            Logger.getLogger(CT_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<CT> buscarCTxNombre(String nombreBuscado) {
        ArrayList<CT> listaCT = new ArrayList();
        CT ct;
        try {
            Connection accesoDB = Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CENTRO_TRABAJO WHERE NOMBRE LIKE (?)");
            ps.setString(1, nombreBuscado);
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
            Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaCT;
    }

}
