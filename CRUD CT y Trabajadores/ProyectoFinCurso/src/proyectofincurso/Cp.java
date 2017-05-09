/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofincurso;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "CP", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Cp.findAll", query = "SELECT c FROM Cp c")
    , @NamedQuery(name = "Cp.findByFecha", query = "SELECT c FROM Cp c WHERE c.cpPK.fecha = :fecha")
    , @NamedQuery(name = "Cp.findByKmInicio", query = "SELECT c FROM Cp c WHERE c.kmInicio = :kmInicio")
    , @NamedQuery(name = "Cp.findByKmFinal", query = "SELECT c FROM Cp c WHERE c.kmFinal = :kmFinal")
    , @NamedQuery(name = "Cp.findByGastoGasoil", query = "SELECT c FROM Cp c WHERE c.gastoGasoil = :gastoGasoil")
    , @NamedQuery(name = "Cp.findByGastoAutopista", query = "SELECT c FROM Cp c WHERE c.gastoAutopista = :gastoAutopista")
    , @NamedQuery(name = "Cp.findByGastoDietas", query = "SELECT c FROM Cp c WHERE c.gastoDietas = :gastoDietas")
    , @NamedQuery(name = "Cp.findByOtrosGastos", query = "SELECT c FROM Cp c WHERE c.otrosGastos = :otrosGastos")
    , @NamedQuery(name = "Cp.findByIncidenciasPosibles", query = "SELECT c FROM Cp c WHERE c.incidenciasPosibles = :incidenciasPosibles")
    , @NamedQuery(name = "Cp.findByExcesoHoras", query = "SELECT c FROM Cp c WHERE c.excesoHoras = :excesoHoras")
    , @NamedQuery(name = "Cp.findByCerrarLogis", query = "SELECT c FROM Cp c WHERE c.cerrarLogis = :cerrarLogis")
    , @NamedQuery(name = "Cp.findByVerificaci\u00f3nAdmin", query = "SELECT c FROM Cp c WHERE c.verificaci\u00f3nAdmin = :verificaci\u00f3nAdmin")
    , @NamedQuery(name = "Cp.findByTrabajadorIdTrabajador", query = "SELECT c FROM Cp c WHERE c.cpPK.trabajadorIdTrabajador = :trabajadorIdTrabajador")
    , @NamedQuery(name = "Cp.findByVehiculoMatricula", query = "SELECT c FROM Cp c WHERE c.vehiculoMatricula = :vehiculoMatricula")})
public class Cp implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CpPK cpPK;
    @Basic(optional = false)
    @Column(name = "KM_INICIO")
    private BigInteger kmInicio;
    @Basic(optional = false)
    @Column(name = "KM_FINAL")
    private BigInteger kmFinal;
    @Column(name = "GASTO_GASOIL")
    private BigInteger gastoGasoil;
    @Column(name = "GASTO_AUTOPISTA")
    private BigInteger gastoAutopista;
    @Column(name = "GASTO_DIETAS")
    private BigInteger gastoDietas;
    @Column(name = "OTROS_GASTOS")
    private BigInteger otrosGastos;
    @Column(name = "INCIDENCIAS_POSIBLES")
    private String incidenciasPosibles;
    @Column(name = "EXCESO_HORAS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date excesoHoras;
    @Basic(optional = false)
    @Column(name = "CERRAR_LOGIS")
    private Character cerrarLogis;
    @Basic(optional = false)
    @Column(name = "VERIFICACI\u00d3N_ADMIN")
    private Character verificaciónAdmin;
    @Basic(optional = false)
    @Column(name = "VEHICULO_MATRICULA")
    private String vehiculoMatricula;

    public Cp() {
    }

    public Cp(CpPK cpPK) {
        this.cpPK = cpPK;
    }

    public Cp(CpPK cpPK, BigInteger kmInicio, BigInteger kmFinal, Character cerrarLogis, Character verificaciónAdmin, String vehiculoMatricula) {
        this.cpPK = cpPK;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.cerrarLogis = cerrarLogis;
        this.verificaciónAdmin = verificaciónAdmin;
        this.vehiculoMatricula = vehiculoMatricula;
    }

    public Cp(Date fecha, BigInteger trabajadorIdTrabajador) {
        this.cpPK = new CpPK(fecha, trabajadorIdTrabajador);
    }

    public CpPK getCpPK() {
        return cpPK;
    }

    public void setCpPK(CpPK cpPK) {
        this.cpPK = cpPK;
    }

    public BigInteger getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(BigInteger kmInicio) {
        BigInteger oldKmInicio = this.kmInicio;
        this.kmInicio = kmInicio;
        changeSupport.firePropertyChange("kmInicio", oldKmInicio, kmInicio);
    }

    public BigInteger getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(BigInteger kmFinal) {
        BigInteger oldKmFinal = this.kmFinal;
        this.kmFinal = kmFinal;
        changeSupport.firePropertyChange("kmFinal", oldKmFinal, kmFinal);
    }

    public BigInteger getGastoGasoil() {
        return gastoGasoil;
    }

    public void setGastoGasoil(BigInteger gastoGasoil) {
        BigInteger oldGastoGasoil = this.gastoGasoil;
        this.gastoGasoil = gastoGasoil;
        changeSupport.firePropertyChange("gastoGasoil", oldGastoGasoil, gastoGasoil);
    }

    public BigInteger getGastoAutopista() {
        return gastoAutopista;
    }

    public void setGastoAutopista(BigInteger gastoAutopista) {
        BigInteger oldGastoAutopista = this.gastoAutopista;
        this.gastoAutopista = gastoAutopista;
        changeSupport.firePropertyChange("gastoAutopista", oldGastoAutopista, gastoAutopista);
    }

    public BigInteger getGastoDietas() {
        return gastoDietas;
    }

    public void setGastoDietas(BigInteger gastoDietas) {
        BigInteger oldGastoDietas = this.gastoDietas;
        this.gastoDietas = gastoDietas;
        changeSupport.firePropertyChange("gastoDietas", oldGastoDietas, gastoDietas);
    }

    public BigInteger getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(BigInteger otrosGastos) {
        BigInteger oldOtrosGastos = this.otrosGastos;
        this.otrosGastos = otrosGastos;
        changeSupport.firePropertyChange("otrosGastos", oldOtrosGastos, otrosGastos);
    }

    public String getIncidenciasPosibles() {
        return incidenciasPosibles;
    }

    public void setIncidenciasPosibles(String incidenciasPosibles) {
        String oldIncidenciasPosibles = this.incidenciasPosibles;
        this.incidenciasPosibles = incidenciasPosibles;
        changeSupport.firePropertyChange("incidenciasPosibles", oldIncidenciasPosibles, incidenciasPosibles);
    }

    public Date getExcesoHoras() {
        return excesoHoras;
    }

    public void setExcesoHoras(Date excesoHoras) {
        Date oldExcesoHoras = this.excesoHoras;
        this.excesoHoras = excesoHoras;
        changeSupport.firePropertyChange("excesoHoras", oldExcesoHoras, excesoHoras);
    }

    public Character getCerrarLogis() {
        return cerrarLogis;
    }

    public void setCerrarLogis(Character cerrarLogis) {
        Character oldCerrarLogis = this.cerrarLogis;
        this.cerrarLogis = cerrarLogis;
        changeSupport.firePropertyChange("cerrarLogis", oldCerrarLogis, cerrarLogis);
    }

    public Character getVerificaciónAdmin() {
        return verificaciónAdmin;
    }

    public void setVerificaciónAdmin(Character verificaciónAdmin) {
        Character oldVerificaciónAdmin = this.verificaciónAdmin;
        this.verificaciónAdmin = verificaciónAdmin;
        changeSupport.firePropertyChange("verificaci\u00f3nAdmin", oldVerificaciónAdmin, verificaciónAdmin);
    }

    public String getVehiculoMatricula() {
        return vehiculoMatricula;
    }

    public void setVehiculoMatricula(String vehiculoMatricula) {
        String oldVehiculoMatricula = this.vehiculoMatricula;
        this.vehiculoMatricula = vehiculoMatricula;
        changeSupport.firePropertyChange("vehiculoMatricula", oldVehiculoMatricula, vehiculoMatricula);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpPK != null ? cpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cp)) {
            return false;
        }
        Cp other = (Cp) object;
        if ((this.cpPK == null && other.cpPK != null) || (this.cpPK != null && !this.cpPK.equals(other.cpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofincurso.Cp[ cpPK=" + cpPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
