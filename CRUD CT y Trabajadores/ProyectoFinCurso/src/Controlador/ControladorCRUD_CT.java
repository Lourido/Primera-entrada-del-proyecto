package Controlador;

import Modelo.*;
import proyectofincurso.JF_CT_CRUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Attribute.ID;

public class ControladorCRUD_CT implements ActionListener, KeyListener {

    JF_CT_CRUD vista_CT_CRUD = new JF_CT_CRUD();
    CT_CRUD modelo_CT_CRUD = new CT_CRUD();

    public ControladorCRUD_CT(JF_CT_CRUD vista_CT_CRUD, CT_CRUD modelo_CT_CRUD) {
        this.modelo_CT_CRUD = modelo_CT_CRUD;
        this.vista_CT_CRUD = vista_CT_CRUD;
        
        this.vista_CT_CRUD.jB_Crear.addActionListener(this);
        this.vista_CT_CRUD.jB_Leer.addActionListener(this);
        this.vista_CT_CRUD.jB_Actualizar.addActionListener(this);
        this.vista_CT_CRUD.jB_Borrar.addActionListener(this);
        this.vista_CT_CRUD.jText_2.addKeyListener(this);
        this.vista_CT_CRUD.jText_3.addKeyListener(this);
        this.vista_CT_CRUD.jText_4.addKeyListener(this);
        this.vista_CT_CRUD.jText_5.addKeyListener(this);
        this.vista_CT_CRUD.jText_6.addKeyListener(this);
        this.vista_CT_CRUD.jText_7.addKeyListener(this);
        this.vista_CT_CRUD.jText_8.addKeyListener(this);
        this.vista_CT_CRUD.jText_Buscar.addKeyListener(this);

    }

    public void Inicializar_CT_CRUD() {

    }

    public void LlenarTabla(JTable tablaCT) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaCT.setModel(modeloT);

        modeloT.addColumn("ID");
        modeloT.addColumn("NOMBRE");
        modeloT.addColumn("CALLE");
        modeloT.addColumn("NUM");
        modeloT.addColumn("C.P.");
        modeloT.addColumn("CIUDAD");
        modeloT.addColumn("PROVINCIA");
        modeloT.addColumn("TELEFONO");

        Object[] columna = new Object[8];

        int numRegistros = modelo_CT_CRUD.listCT().size();

        for (int i = 0; i < numRegistros; i++) {
            columna[0] = modelo_CT_CRUD.listCT().get(i).getID();
            columna[1] = modelo_CT_CRUD.listCT().get(i).getNombre();
            columna[2] = modelo_CT_CRUD.listCT().get(i).getCalle();
            columna[3] = modelo_CT_CRUD.listCT().get(i).getNumero();
            columna[4] = modelo_CT_CRUD.listCT().get(i).getCp();
            columna[5] = modelo_CT_CRUD.listCT().get(i).getCiudad();
            columna[6] = modelo_CT_CRUD.listCT().get(i).getProvincia();
            columna[7] = modelo_CT_CRUD.listCT().get(i).getTelefono();
            modeloT.addRow(columna);
        }
    }

    public void limpiar() {
        vista_CT_CRUD.jText_1.setText(null);
        vista_CT_CRUD.jText_1.setEditable(true);
        vista_CT_CRUD.jText_2.setText("");
        vista_CT_CRUD.jText_3.setText("");
        vista_CT_CRUD.jText_4.setText(null);
        vista_CT_CRUD.jText_5.setText("");
        vista_CT_CRUD.jText_6.setText("");
        vista_CT_CRUD.jText_7.setText("");
        vista_CT_CRUD.jText_8.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista_CT_CRUD.jB_Crear) {
            int ID = Integer.parseInt(vista_CT_CRUD.jText_1.getText());
            String Nombre = vista_CT_CRUD.jText_2.getText();
            String Calle = vista_CT_CRUD.jText_3.getText();
            int Num = Integer.parseInt(vista_CT_CRUD.jText_4.getText());
            String cp = vista_CT_CRUD.jText_5.getText();
            String Ciudad = vista_CT_CRUD.jText_6.getText();
            String Provincia = vista_CT_CRUD.jText_7.getText();
            String Telefono = vista_CT_CRUD.jText_8.getText();

            String rptaRegistro = modelo_CT_CRUD.insertCT(ID, Nombre, Calle, Num, cp, Ciudad, Provincia, Telefono);

            if (rptaRegistro != null) {
                JOptionPane.showMessageDialog(null, rptaRegistro);
            } else {
                JOptionPane.showMessageDialog(null, "Registro incorrecto");
            }
        }
        if (e.getSource() == vista_CT_CRUD.jB_Leer) {
            LlenarTabla(vista_CT_CRUD.jTableDatos);
        }
        if (e.getSource() == vista_CT_CRUD.jB_Actualizar) {
            int filaEditar = vista_CT_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_CT_CRUD.jTableDatos.getSelectedRowCount();
            if (filaEditar > 0 && numFilas == 1) {
                vista_CT_CRUD.jText_1.setText(String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(filaEditar, 0)));
                // Como el ID es clave lo deshabilito para que no pueda modificarse
                vista_CT_CRUD.jText_1.setEditable(false);
                // Deshabilito los botones para que no puedan usarse durante la edición
                vista_CT_CRUD.jB_Crear.setEnabled(false);
                vista_CT_CRUD.jB_Borrar.setEnabled(false);
                vista_CT_CRUD.jB_Leer.setEnabled(false);
                vista_CT_CRUD.jB_Salir.setEnabled(false);
                vista_CT_CRUD.jB_Volver.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar 1 sola fila - por lo menos una" + e);
            }
        }
        if (e.getSource() == vista_CT_CRUD.jB_Borrar) {
            int filaInicio = vista_CT_CRUD.jTableDatos.getSelectedRow();
            int numFilas = vista_CT_CRUD.jTableDatos.getSelectedRowCount();
            ArrayList<String> listaNombre = new ArrayList();
            String nombre = "";
            if (filaInicio > 0) {
                for (int i = 0; i < numFilas; i++) {
                    nombre = String.valueOf(vista_CT_CRUD.jTableDatos.getValueAt(i + filaInicio, 0));
                    listaNombre.add(nombre);
                }
                for (int i = 0; i < numFilas; i++) {
                    int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el registro " + nombre + " ?");
                    // Esta pregunta tiene 3 posibles respuestas:
                    // SI=0  -- NO=1 -- CANCELAR =2
                    if (rptaUsuario == 0) {
                        modelo_CT_CRUD.eliminarCT(nombre);
                    }
                }

                LlenarTabla(vista_CT_CRUD.jTableDatos);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona por lo menos una fila a borrar.");

            }

            if (e.getSource() == vista_CT_CRUD.jB_OK) {
                String Nombre = vista_CT_CRUD.jText_2.getText();
                String Calle = vista_CT_CRUD.jText_3.getText();
                int Num = Integer.parseInt(vista_CT_CRUD.jText_4.getText());
                String cp = vista_CT_CRUD.jText_5.getText();
                String Ciudad = vista_CT_CRUD.jText_6.getText();
                String Provincia = vista_CT_CRUD.jText_7.getText();
                String Telefono = vista_CT_CRUD.jText_8.getText();

                int rptaEdit = modelo_CT_CRUD.editarCT(Nombre, Calle, Num, cp, Ciudad, Provincia, Telefono);
                if (rptaEdit > 0) {
                    JOptionPane.showMessageDialog(null, "Edición Correcta");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR en la EDICIÓN");
                }
                // Borro los datos del formulario
                limpiar();
                // Vuelvo a habilitar los botones deshabilitados
                vista_CT_CRUD.jText_1.setEditable(true);
                vista_CT_CRUD.jB_Crear.setEnabled(true);
                vista_CT_CRUD.jB_Borrar.setEnabled(true);
                vista_CT_CRUD.jB_Leer.setEnabled(true);
                vista_CT_CRUD.jB_Salir.setEnabled(true);
                vista_CT_CRUD.jB_Volver.setEnabled(true);
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Para controlar el texto que se pone en el campo "número" sea un número
        if (e.getSource() == vista_CT_CRUD.jText_4) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource()== vista_CT_CRUD.jText_5){
            String cp = vista_CT_CRUD.jText_5.getText();
            int l = cp.length();
            if (l >5){
                JOptionPane.showMessageDialog(null, "Solo se admiten Códigos Postales de 5 dígitos.");
            }
        }
        
        
        
        if (e.getSource() == vista_CT_CRUD.jText_Buscar) {
            String nombre = vista_CT_CRUD.jText_Buscar.getText();

            DefaultTableModel modeloT = new DefaultTableModel();
            vista_CT_CRUD.jTableDatos.setModel(modeloT);

            modeloT.addColumn("ID");
            modeloT.addColumn("NOMBRE");
            modeloT.addColumn("CALLE");
            modeloT.addColumn("NUM");
            modeloT.addColumn("C.P.");
            modeloT.addColumn("CIUDAD");
            modeloT.addColumn("PROVINCIA");
            modeloT.addColumn("TELEFONO");

            Object[] columna = new Object[8];

            int numRegistros = modelo_CT_CRUD.buscarCTxNombre(nombre).size();

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getID();
                columna[1] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getNombre();
                columna[2] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getCalle();
                columna[3] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getNumero();
                columna[4] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getCp();
                columna[5] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getCiudad();
                columna[6] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getProvincia();
                columna[7] = modelo_CT_CRUD.buscarCTxNombre(nombre).get(i).getTelefono();
                modeloT.addRow(columna);
            }
        }
    }
}
