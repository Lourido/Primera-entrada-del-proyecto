
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Gestion_Parte_CRUD {
  
    public Gestion_Parte_CRUD() {
    }
    
    // FALTA AÑADIR EL TRABAJADOR
    public String insertGestion_Parte(java.sql.Date fecha, int id_trabajador, String matricula, int km_ini, int km_fin) {
        
        String rptaGestion_Parte = null;
        
        try {
            Connection accesoDB = Conexion.getConexion();
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Gestion_Parte(?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS
            cs.setDate(1, fecha);
            cs.setInt(2, id_trabajador);
            cs.setString(3, matricula);
            cs.setInt(4, km_ini);
            cs.setInt(5, km_fin);
            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaGestion_Parte = "Registro ACTUALIZADO";               
            }
            cs.close();
            Conexion.exitConexion();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return rptaGestion_Parte;
    }

    // UTILIZO una VISTA de las Cabeceras para tener todos los datos
    public ArrayList<Vista_CP> listVista_CP() {
        ArrayList listaVista_CP = new ArrayList();
        Vista_CP vista_cp;
        try {
            Connection accesoDB = Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP_VISTA");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vista_cp = new Vista_CP();
                vista_cp.setFecha(rs.getDate(1));
                vista_cp.setKm_in(rs.getInt(2));
                vista_cp.setKm_fin(rs.getInt(3));
                vista_cp.setGasoil(rs.getDouble(4));
                vista_cp.setAutopista(rs.getDouble(5));
                vista_cp.setDietas(rs.getDouble(6));
                vista_cp.setOtros(rs.getDouble(7));
                vista_cp.setIncidencias(rs.getString(8));
                vista_cp.setExceso_horas(rs.getDate(9));
                vista_cp.setCerrar_parte(rs.getBoolean(10));
                vista_cp.setVerificar_parte(rs.getBoolean(11));
                vista_cp.setId_trabajador(rs.getInt(12));
                vista_cp.setMatricula(rs.getString(13));
                
                listaVista_CP.add(vista_cp);
            }
            ps.close();
            rs.close();
            Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaVista_CP;
    }
        public ArrayList<Vehiculo> listVehiculo() {
        ArrayList listaVehiculo = new ArrayList();
        Vehiculo vehiculo;
        try {
            Connection accesoDB = Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM VEHICULO");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString(1));
                vehiculo.setMarca(rs.getString(2));
                vehiculo.setModelo(rs.getString(3));
                vehiculo.setColor(rs.getString(4));
                vehiculo.setKms(rs.getInt(5));

                listaVehiculo.add(vehiculo);
            }
            ps.close();
            rs.close();
            Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaVehiculo;
    }


    public String editarGestion_Parte(int km_fin, double gasoil, double autopista, double dietas, double otros) {
        
        String rptaEdit =null;
        int numFil = 0;

        try {
            Connection accesoDB = Conexion.getConexion();
            
            // LLAMADA AL PROCEDIMIENTO ALMACENADO EN ORACLE
            CallableStatement cs = accesoDB.prepareCall("{CALL P_IN_EDIT_Gestion_Parte(?,?,?,?,?,?,?,?)} ");
            // SE RELLENAN TODOS LOS PARAMETROS            
            cs.setInt(1, km_fin);
            cs.setDouble(2, gasoil);
            cs.setDouble(3, autopista);
            cs.setDouble(4, dietas);
            cs.setDouble(5, otros);

            int numFila = cs.executeUpdate();
            if (numFila > 0) {
                rptaEdit = "Registro ACTUALIZAZO";               
            }
            cs.close();
            Conexion.exitConexion();
        
        } catch (Exception e) {
        }
        
        return rptaEdit;
    }

    public int eliminarGestion_Parte(String matricula) {
        int numFil = 0;

        try {
            Connection accesoDB = Conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{CALL P_DELETE_Gestion_Parte(?)}");
            cs.setString(1,matricula);

            numFil = cs.executeUpdate();
            cs.close();
            Conexion.exitConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Gestion_Parte_CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFil;
    }

    public ArrayList<Vista_CP> buscarGestion_PartexFecha(java.sql.Date fechaBuscado) {
        ArrayList<Vista_CP> listaGestion_Parte = new ArrayList();
        Vista_CP vista_cp;
        try {
            Connection accesoDB = Conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM CP_VISTA WHERE FECHA = (?)");
            ps.setDate(1, fechaBuscado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vista_cp = new Vista_CP();
                vista_cp.setFecha(rs.getDate(1));
                vista_cp.setKm_in(rs.getInt(2));
                vista_cp.setKm_fin(rs.getInt(3));
                vista_cp.setGasoil(rs.getDouble(4));
                vista_cp.setAutopista(rs.getDouble(5));
                vista_cp.setDietas(rs.getDouble(6));
                vista_cp.setOtros(rs.getDouble(7));
                vista_cp.setIncidencias(rs.getString(8));
                vista_cp.setExceso_horas(rs.getDate(9));
                vista_cp.setCerrar_parte(rs.getBoolean(10));
                vista_cp.setVerificar_parte(rs.getBoolean(11));
                vista_cp.setId_trabajador(rs.getInt(12));
                vista_cp.setMatricula(rs.getString(13));                
                listaGestion_Parte.add(vista_cp);
            }
            ps.close();
            rs.close();
            Conexion.exitConexion();

        } catch (Exception e) {

        }
        return listaGestion_Parte;
    }    
    
}
