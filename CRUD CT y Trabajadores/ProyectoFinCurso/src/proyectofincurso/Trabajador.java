/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofincurso;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Alf
 */
@Entity
@Table(name = "TRABAJADOR", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
    , @NamedQuery(name = "Trabajador.findByIdTrabajador", query = "SELECT t FROM Trabajador t WHERE t.idTrabajador = :idTrabajador")
    , @NamedQuery(name = "Trabajador.findByDni", query = "SELECT t FROM Trabajador t WHERE t.dni = :dni")
    , @NamedQuery(name = "Trabajador.findByNombre", query = "SELECT t FROM Trabajador t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Trabajador.findByApellido1", query = "SELECT t FROM Trabajador t WHERE t.apellido1 = :apellido1")
    , @NamedQuery(name = "Trabajador.findByApellido2", query = "SELECT t FROM Trabajador t WHERE t.apellido2 = :apellido2")
    , @NamedQuery(name = "Trabajador.findByCalle", query = "SELECT t FROM Trabajador t WHERE t.calle = :calle")
    , @NamedQuery(name = "Trabajador.findByPortal", query = "SELECT t FROM Trabajador t WHERE t.portal = :portal")
    , @NamedQuery(name = "Trabajador.findByPiso", query = "SELECT t FROM Trabajador t WHERE t.piso = :piso")
    , @NamedQuery(name = "Trabajador.findByMano", query = "SELECT t FROM Trabajador t WHERE t.mano = :mano")
    , @NamedQuery(name = "Trabajador.findByTelefonoPersonal", query = "SELECT t FROM Trabajador t WHERE t.telefonoPersonal = :telefonoPersonal")
    , @NamedQuery(name = "Trabajador.findByMovilEmpresa", query = "SELECT t FROM Trabajador t WHERE t.movilEmpresa = :movilEmpresa")
    , @NamedQuery(name = "Trabajador.findBySalario", query = "SELECT t FROM Trabajador t WHERE t.salario = :salario")
    , @NamedQuery(name = "Trabajador.findByFechaNacimiento", query = "SELECT t FROM Trabajador t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Trabajador.findByCategor\u00eda", query = "SELECT t FROM Trabajador t WHERE t.categor\u00eda = :categor\u00eda")
    , @NamedQuery(name = "Trabajador.findByCentroTrabajoIdCentro", query = "SELECT t FROM Trabajador t WHERE t.centroTrabajoIdCentro = :centroTrabajoIdCentro")})
public class Trabajador implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRABAJADOR")
    private BigDecimal idTrabajador;
    @Basic(optional = false)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDO_1")
    private String apellido1;
    @Basic(optional = false)
    @Column(name = "APELLIDO_2")
    private String apellido2;
    @Column(name = "CALLE")
    private String calle;
    @Column(name = "PORTAL")
    private String portal;
    @Basic(optional = false)
    @Column(name = "PISO")
    private String piso;
    @Basic(optional = false)
    @Column(name = "MANO")
    private String mano;
    @Column(name = "TELEFONO_PERSONAL")
    private String telefonoPersonal;
    @Basic(optional = false)
    @Column(name = "MOVIL_EMPRESA")
    private String movilEmpresa;
    @Column(name = "SALARIO")
    private BigInteger salario;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "CATEGOR\u00cdA")
    private String categoría;
    @Basic(optional = false)
    @Column(name = "CENTRO_TRABAJO_ID_CENTRO")
    private BigInteger centroTrabajoIdCentro;

    public Trabajador() {
    }

    public Trabajador(BigDecimal idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajador(BigDecimal idTrabajador, String dni, String nombre, String apellido1, String apellido2, String piso, String mano, String movilEmpresa, String categoría, BigInteger centroTrabajoIdCentro) {
        this.idTrabajador = idTrabajador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.piso = piso;
        this.mano = mano;
        this.movilEmpresa = movilEmpresa;
        this.categoría = categoría;
        this.centroTrabajoIdCentro = centroTrabajoIdCentro;
    }

    Trabajador(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8, double aDouble, java.sql.Date date, String string9, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BigDecimal getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(BigDecimal idTrabajador) {
        BigDecimal oldIdTrabajador = this.idTrabajador;
        this.idTrabajador = idTrabajador;
        changeSupport.firePropertyChange("idTrabajador", oldIdTrabajador, idTrabajador);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        String oldDni = this.dni;
        this.dni = dni;
        changeSupport.firePropertyChange("dni", oldDni, dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        String oldApellido1 = this.apellido1;
        this.apellido1 = apellido1;
        changeSupport.firePropertyChange("apellido1", oldApellido1, apellido1);
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        String oldApellido2 = this.apellido2;
        this.apellido2 = apellido2;
        changeSupport.firePropertyChange("apellido2", oldApellido2, apellido2);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        String oldCalle = this.calle;
        this.calle = calle;
        changeSupport.firePropertyChange("calle", oldCalle, calle);
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        String oldPortal = this.portal;
        this.portal = portal;
        changeSupport.firePropertyChange("portal", oldPortal, portal);
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        String oldPiso = this.piso;
        this.piso = piso;
        changeSupport.firePropertyChange("piso", oldPiso, piso);
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        String oldMano = this.mano;
        this.mano = mano;
        changeSupport.firePropertyChange("mano", oldMano, mano);
    }

    public String getTelefonoPersonal() {
        return telefonoPersonal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        String oldTelefonoPersonal = this.telefonoPersonal;
        this.telefonoPersonal = telefonoPersonal;
        changeSupport.firePropertyChange("telefonoPersonal", oldTelefonoPersonal, telefonoPersonal);
    }

    public String getMovilEmpresa() {
        return movilEmpresa;
    }

    public void setMovilEmpresa(String movilEmpresa) {
        String oldMovilEmpresa = this.movilEmpresa;
        this.movilEmpresa = movilEmpresa;
        changeSupport.firePropertyChange("movilEmpresa", oldMovilEmpresa, movilEmpresa);
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        BigInteger oldSalario = this.salario;
        this.salario = salario;
        changeSupport.firePropertyChange("salario", oldSalario, salario);
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        Date oldFechaNacimiento = this.fechaNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        changeSupport.firePropertyChange("fechaNacimiento", oldFechaNacimiento, fechaNacimiento);
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        String oldCategoría = this.categoría;
        this.categoría = categoría;
        changeSupport.firePropertyChange("categor\u00eda", oldCategoría, categoría);
    }

    public BigInteger getCentroTrabajoIdCentro() {
        return centroTrabajoIdCentro;
    }

    public void setCentroTrabajoIdCentro(BigInteger centroTrabajoIdCentro) {
        BigInteger oldCentroTrabajoIdCentro = this.centroTrabajoIdCentro;
        this.centroTrabajoIdCentro = centroTrabajoIdCentro;
        changeSupport.firePropertyChange("centroTrabajoIdCentro", oldCentroTrabajoIdCentro, centroTrabajoIdCentro);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajador != null ? idTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idTrabajador == null && other.idTrabajador != null) || (this.idTrabajador != null && !this.idTrabajador.equals(other.idTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofincurso.Trabajador[ idTrabajador=" + idTrabajador + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
