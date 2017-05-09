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
@Table(name = "AVISO", catalog = "", schema = "SYSTEM")
@NamedQueries({
    @NamedQuery(name = "Aviso.findAll", query = "SELECT a FROM Aviso a")
    , @NamedQuery(name = "Aviso.findByFechaAviso", query = "SELECT a FROM Aviso a WHERE a.fechaAviso = :fechaAviso")
    , @NamedQuery(name = "Aviso.findByTexto", query = "SELECT a FROM Aviso a WHERE a.texto = :texto")
    , @NamedQuery(name = "Aviso.findByTrabajadorIdTrabajador", query = "SELECT a FROM Aviso a WHERE a.avisoPK.trabajadorIdTrabajador = :trabajadorIdTrabajador")
    , @NamedQuery(name = "Aviso.findByCpFecha", query = "SELECT a FROM Aviso a WHERE a.avisoPK.cpFecha = :cpFecha")
    , @NamedQuery(name = "Aviso.findByCpTrabajadorIdTrabajador", query = "SELECT a FROM Aviso a WHERE a.avisoPK.cpTrabajadorIdTrabajador = :cpTrabajadorIdTrabajador")})
public class Aviso implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvisoPK avisoPK;
    @Basic(optional = false)
    @Column(name = "FECHA_AVISO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAviso;
    @Basic(optional = false)
    @Column(name = "TEXTO")
    private String texto;

    public Aviso() {
    }

    public Aviso(AvisoPK avisoPK) {
        this.avisoPK = avisoPK;
    }

    public Aviso(AvisoPK avisoPK, Date fechaAviso, String texto) {
        this.avisoPK = avisoPK;
        this.fechaAviso = fechaAviso;
        this.texto = texto;
    }

    public Aviso(BigInteger trabajadorIdTrabajador, Date cpFecha, BigInteger cpTrabajadorIdTrabajador) {
        this.avisoPK = new AvisoPK(trabajadorIdTrabajador, cpFecha, cpTrabajadorIdTrabajador);
    }

    public AvisoPK getAvisoPK() {
        return avisoPK;
    }

    public void setAvisoPK(AvisoPK avisoPK) {
        this.avisoPK = avisoPK;
    }

    public Date getFechaAviso() {
        return fechaAviso;
    }

    public void setFechaAviso(Date fechaAviso) {
        Date oldFechaAviso = this.fechaAviso;
        this.fechaAviso = fechaAviso;
        changeSupport.firePropertyChange("fechaAviso", oldFechaAviso, fechaAviso);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        String oldTexto = this.texto;
        this.texto = texto;
        changeSupport.firePropertyChange("texto", oldTexto, texto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avisoPK != null ? avisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviso)) {
            return false;
        }
        Aviso other = (Aviso) object;
        if ((this.avisoPK == null && other.avisoPK != null) || (this.avisoPK != null && !this.avisoPK.equals(other.avisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofincurso.Aviso[ avisoPK=" + avisoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
