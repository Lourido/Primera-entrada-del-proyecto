package Controlador;

import Modelo.*;
import static com.sun.glass.ui.Cursor.setVisible;
import proyectofincurso.JF_Gestion_Parte_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectofincurso.JF_Cabe_Parte_CRUD;

public class ControladorCRUD_Gestion_Parte implements ActionListener, KeyListener {

    JF_Gestion_Parte_CRUD vista_Gestion_Parte_CRUD = new JF_Gestion_Parte_CRUD();
    Gestion_Parte_CRUD modelo_Gestion_Parte_CRUD = new Gestion_Parte_CRUD();

    public ControladorCRUD_Gestion_Parte(JF_Gestion_Parte_CRUD vista_Gestion_Parte, Gestion_Parte_CRUD modelo_Gestion_Parte) {

        this.modelo_Gestion_Parte_CRUD = modelo_Gestion_Parte_CRUD;
        this.vista_Gestion_Parte_CRUD = vista_Gestion_Parte_CRUD;
        // "Escucha" los botones pulsados en la pantalla JF_Gestion_Parte_CRUD
        this.vista_Gestion_Parte_CRUD.jB_Crear.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_Leer.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_Borrar.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jB_OK.addActionListener(this);
        this.vista_Gestion_Parte_CRUD.jCB_Cerrado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCB_Verificado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCE_Cerrado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jCE_Verificado.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jLB_Centro.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jLB_Vehiculo.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTB_Fecha.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTB_Nombre_Trabajador.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Autopista.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Dietas.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Fecha.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Gasoil.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Hextras.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Incidencias.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Otros.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_Vehiculo.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_kmf.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTE_kmi.addKeyListener(this);
        this.vista_Gestion_Parte_CRUD.jTableDatos.addKeyListener(this);
    }

    public void LlenarTabla(JTable tablaLinea_Parte) {
        DefaultTableModel modeloLP = new DefaultTableModel();
        tablaLinea_Parte.setModel(modeloLP);
//      PARA PONER DESDE AQUÍ LOS NOMBRES DE LAS COLUMNAS
        modeloLP.addColumn("Trabajador");
        modeloLP.addColumn("Apellido 1");
        modeloLP.addColumn("Matricula");
        modeloLP.addColumn("Fecha");
        modeloLP.addColumn("Km I.");
        modeloLP.addColumn("Km F.");
        modeloLP.addColumn("G.Gasoil");
        modeloLP.addColumn("G.Autop.");
        modeloLP.addColumn("G.Dietas");
        modeloLP.addColumn("G.Otros");
        modeloLP.addColumn("H.Extras");
        modeloLP.addColumn("Cdo.");
        modeloLP.addColumn("Vrf.");

        Object[] columna = new Object[13];
        // CREO UNA copia del ArrayList de la Base de datos
        // para ahorrar tiempo de búsqueda y conexión
        List<Vista_CP> ListaCopia = new ArrayList<>();
        ListaCopia = (List<Vista_CP>) modelo_Gestion_Parte_CRUD.listVista_CP().clone();

        int numRegistros = ListaCopia.size();

        for (int i = 0; i < numRegistros; i++) {

            columna[0] = ListaCopia.get(i).getNombre();
            columna[1] = ListaCopia.get(i).getApellido1();
            columna[2] = ListaCopia.get(i).getMatricula();

            // ARREGLAR EL FORMATO DE LA FECHA
            String Fecha_YMD = ListaCopia.get(i).getFecha().toString();
            String Fecha_dma = Fecha_YMD.substring(8, 10) + "-" + Fecha_YMD.substring(5, 7) + "-" + Fecha_YMD.substring(0, 4);
            columna[3] = Fecha_dma;

            columna[4] = ListaCopia.get(i).getKm_in();
            columna[5] = ListaCopia.get(i).getKm_fin();
            columna[6] = ListaCopia.get(i).getGasoil();
            columna[7] = ListaCopia.get(i).getAutopista();
            columna[8] = ListaCopia.get(i).getDietas();
            columna[9] = ListaCopia.get(i).getOtros();
            columna[10] = ListaCopia.get(i).getExceso_horas();
            columna[11] = ListaCopia.get(i).isCerrar_parte();
            columna[12] = ListaCopia.get(i).isVerificar_parte();

            modeloLP.addRow(columna);
        }
        JOptionPane.showMessageDialog(null, "Listado terminado");
    }

    public void limpiar() {
        vista_Gestion_Parte_CRUD.jTE_Autopista.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Dietas.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Fecha.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Gasoil.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Incidencias.setText("Incidencias: ");
        vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.setText("");
        vista_Gestion_Parte_CRUD.jTE_Otros.setText(null);
        vista_Gestion_Parte_CRUD.jTE_Vehiculo.setText("");
        vista_Gestion_Parte_CRUD.jTE_kmf.setText(null);
        vista_Gestion_Parte_CRUD.jCB_Cerrado.setSelected(false);
        vista_Gestion_Parte_CRUD.jCB_Verificado.setSelected(false);

        // Para que el cursor se ponga en este campo después de limpiar los datos
        vista_Gestion_Parte_CRUD.jTE_Fecha.requestFocus();
    }

    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {

        // LECTURA de los datos en la tabla
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_Leer) {
            LlenarTabla(vista_Gestion_Parte_CRUD.jTableDatos);
        }

        // MODIFICACIÓN de los datos introducidos
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_Actualizar) {
            int filaEditar = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRowCount();

            if (filaEditar >= 0 && numFilas == 1) {

                // Subo los valores de la fila a los campos de edición
                vista_Gestion_Parte_CRUD.jTE_NombreTrabajador.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                vista_Gestion_Parte_CRUD.jTE_Vehiculo.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 2)));

                // CONVERTIR EL STRING EN DATE     
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String dateInString = vista_Gestion_Parte_CRUD.jTE_Fecha.getText();
                java.sql.Date Fecha = null;
                try {
                    java.util.Date parsed = formatter.parse(dateInString);
                    Fecha = new java.sql.Date(parsed.getTime());
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
                }

                vista_Gestion_Parte_CRUD.jTE_kmi.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 4)));
                vista_Gestion_Parte_CRUD.jTE_kmf.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 5)));
                vista_Gestion_Parte_CRUD.jTE_Gasoil.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 6)));
                vista_Gestion_Parte_CRUD.jTE_Autopista.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 7)));
                vista_Gestion_Parte_CRUD.jTE_Dietas.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 8)));
                vista_Gestion_Parte_CRUD.jTE_Otros.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 9)));
                vista_Gestion_Parte_CRUD.jTE_Hextras.setText(String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaEditar, 8)));
                // PONGO A FALSO LOS VALORES DE CERRADO Y VERIFICADO
                vista_Gestion_Parte_CRUD.jCE_Cerrado.setSelected(false);
                vista_Gestion_Parte_CRUD.jCE_Verificado.setSelected(false);

                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_Gestion_Parte_CRUD.jB_Crear.setEnabled(false);
                vista_Gestion_Parte_CRUD.jB_Borrar.setEnabled(false);
                vista_Gestion_Parte_CRUD.jB_Leer.setEnabled(false);
                vista_Gestion_Parte_CRUD.jB_Salir.setEnabled(false);
                vista_Gestion_Parte_CRUD.jB_Volver.setEnabled(false);

            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        // BORRADO de alguno de los datos
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_Borrar) {
            int filaInicio = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_Gestion_Parte_CRUD.jTableDatos.getSelectedRowCount();
            @SuppressWarnings("unchecked")

            ArrayList<String> listaParte = new ArrayList();
            String matricula = "";

            if (filaInicio >= 0) {
                for (int i = 0; i < numFilas; i++) {
                    matricula = String.valueOf(vista_Gestion_Parte_CRUD.jTableDatos.getValueAt(filaInicio, 3));

                    listaParte.add(matricula);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar este registro de la matrícula " + matricula + " ?");
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
                        modelo_Gestion_Parte_CRUD.eliminarGestion_Parte(matricula);
                    }
                }

                LlenarTabla(vista_Gestion_Parte_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }
        }
        // BOTON de Ok
        if (e.getSource() == vista_Gestion_Parte_CRUD.jB_OK) {
            // CONVERTIR EL STRING DE FECHA EN DATE     
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateInString = vista_Gestion_Parte_CRUD.jTB_Fecha.getText();
            java.sql.Date Fecha = null;
            try {
                java.util.Date parsed = formatter.parse(dateInString);
                Fecha = new java.sql.Date(parsed.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCRUD_Trabajador.class.getName()).log(Level.SEVERE, null, ex);
            }
            Boolean cerrado = Boolean.parseBoolean(vista_Gestion_Parte_CRUD.jCB_Cerrado.getText());
            Boolean verificado = Boolean.parseBoolean(vista_Gestion_Parte_CRUD.jCB_Verificado.getText());
            String matricula = vista_Gestion_Parte_CRUD.jLB_Vehiculo.getSelectedValue();
            String ct = vista_Gestion_Parte_CRUD.jLB_Centro.getSelectedValue();
            String nombre = vista_Gestion_Parte_CRUD.jTB_Nombre_Trabajador.getText();

            // SOLO BUSCA POR FECHA DE MOMENTO Cuando SI QUE hay texto en el campo BUSCAR
            if (!Fecha.equals("")) {
                String fechaString = dateInString;
                DefaultTableModel modeloLP = new DefaultTableModel();
                vista_Gestion_Parte_CRUD.jTableDatos.setModel(modeloLP);

                modeloLP.addColumn("Trabajador");
                modeloLP.addColumn("Apellido 1");
                modeloLP.addColumn("Matricula");
                modeloLP.addColumn("Fecha");
                modeloLP.addColumn("Km I.");
                modeloLP.addColumn("Km F.");
                modeloLP.addColumn("G.Gasoil");
                modeloLP.addColumn("G.Autop.");
                modeloLP.addColumn("G.Dietas");
                modeloLP.addColumn("G.Otros");
                modeloLP.addColumn("H.Extras");
                modeloLP.addColumn("Cdo.");
                modeloLP.addColumn("Vrf.");

                Object[] columna = new Object[13];
                // CREO UNA copia del ArrayList de la Base de datos
                // para ahorrar tiempo de búsqueda y conexión                
                List<Vista_CP> ListaCopia = new ArrayList<>();
                ListaCopia = (List<Vista_CP>) modelo_Gestion_Parte_CRUD.buscarGestion_PartexFecha(Fecha).clone();

                int numRegistros = ListaCopia.size();

                for (int i = 0; i < numRegistros; i++) {

                    columna[0] = ListaCopia.get(i).getNombre();
                    columna[1] = ListaCopia.get(i).getApellido1();
                    columna[2] = ListaCopia.get(i).getMatricula();

                    // ARREGLAR EL FORMATO DE LA FECHA
                    String Fecha_YMD = ListaCopia.get(i).getFecha().toString();
                    String Fecha_dma = Fecha_YMD.substring(8, 10) + "-" + Fecha_YMD.substring(5, 7) + "-" + Fecha_YMD.substring(0, 4);
                    columna[3] = Fecha_dma;

                    columna[4] = ListaCopia.get(i).getKm_in();
                    columna[5] = ListaCopia.get(i).getKm_fin();
                    columna[6] = ListaCopia.get(i).getGasoil();
                    columna[7] = ListaCopia.get(i).getAutopista();
                    columna[8] = ListaCopia.get(i).getDietas();
                    columna[9] = ListaCopia.get(i).getOtros();
                    columna[10] = ListaCopia.get(i).getExceso_horas();
                    columna[11] = ListaCopia.get(i).isCerrar_parte();
                    columna[12] = ListaCopia.get(i).isVerificar_parte();

                    modeloLP.addRow(columna);
                }
                JOptionPane.showMessageDialog(null, "Listado terminado");
            }
            vista_Gestion_Parte_CRUD.jTB_Fecha.setText("");
            vista_Gestion_Parte_CRUD.jCB_Cerrado.setSelected(false);
            vista_Gestion_Parte_CRUD.jCB_Verificado.setSelected(false);
            vista_Gestion_Parte_CRUD.jLB_Vehiculo.setSelectedIndex(0);
            vista_Gestion_Parte_CRUD.jLB_Centro.setSelectedIndex(0);
            vista_Gestion_Parte_CRUD.jTB_Nombre_Trabajador.setText("");

        } else { // NO HAY QUE BUSCAR NADA, SOLO ACTUALIZAR LOS VALORES

            int km_final = Integer.parseInt(vista_Gestion_Parte_CRUD.jTE_kmf.getText());
            Double gasoil = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Gasoil.getText());
            Double autopista = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Autopista.getText());
            Double dietas = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Dietas.getText());
            Double otros = Double.parseDouble(vista_Gestion_Parte_CRUD.jTE_Otros.getText());

            String rptaEdit = modelo_Gestion_Parte_CRUD.editarGestion_Parte(km_final, gasoil, autopista, dietas, otros);

                 if (rptaEdit != null) {
                    JOptionPane.showMessageDialog(null, rptaEdit);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro incorrecto" + e);
                }
            // Limpio los datos del formulario
            limpiar();
            // Vuelvo a habilitar los botones deshabilitados
            vista_Gestion_Parte_CRUD.jB_Crear.setEnabled(true);
            vista_Gestion_Parte_CRUD.jB_Borrar.setEnabled(true);
            vista_Gestion_Parte_CRUD.jB_Leer.setEnabled(true);
            vista_Gestion_Parte_CRUD.jB_Salir.setEnabled(true);
            vista_Gestion_Parte_CRUD.jB_Volver.setEnabled(true);

            // Refresco el listado para que aparezca el cambio hecho
            vista_Gestion_Parte_CRUD.jB_Leer.doClick();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
