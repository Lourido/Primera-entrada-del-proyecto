/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofincurso;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Alf
 */
@Embeddable
public class AvisoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "TRABAJADOR_ID_TRABAJADOR")
    private BigInteger trabajadorIdTrabajador;
    @Basic(optional = false)
    @Column(name = "CP_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpFecha;
    @Basic(optional = false)
    @Column(name = "CP_TRABAJADOR_ID_TRABAJADOR")
    private BigInteger cpTrabajadorIdTrabajador;

    public AvisoPK() {
    }

    public AvisoPK(BigInteger trabajadorIdTrabajador, Date cpFecha, BigInteger cpTrabajadorIdTrabajador) {
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
        this.cpFecha = cpFecha;
        this.cpTrabajadorIdTrabajador = cpTrabajadorIdTrabajador;
    }

    public BigInteger getTrabajadorIdTrabajador() {
        return trabajadorIdTrabajador;
    }

    public void setTrabajadorIdTrabajador(BigInteger trabajadorIdTrabajador) {
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
    }

    public Date getCpFecha() {
        return cpFecha;
    }

    public void setCpFecha(Date cpFecha) {
        this.cpFecha = cpFecha;
    }

    public BigInteger getCpTrabajadorIdTrabajador() {
        return cpTrabajadorIdTrabajador;
    }

    public void setCpTrabajadorIdTrabajador(BigInteger cpTrabajadorIdTrabajador) {
        this.cpTrabajadorIdTrabajador = cpTrabajadorIdTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trabajadorIdTrabajador != null ? trabajadorIdTrabajador.hashCode() : 0);
        hash += (cpFecha != null ? cpFecha.hashCode() : 0);
        hash += (cpTrabajadorIdTrabajador != null ? cpTrabajadorIdTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvisoPK)) {
            return false;
        }
        AvisoPK other = (AvisoPK) object;
        if ((this.trabajadorIdTrabajador == null && other.trabajadorIdTrabajador != null) || (this.trabajadorIdTrabajador != null && !this.trabajadorIdTrabajador.equals(other.trabajadorIdTrabajador))) {
            return false;
        }
        if ((this.cpFecha == null && other.cpFecha != null) || (this.cpFecha != null && !this.cpFecha.equals(other.cpFecha))) {
            return false;
        }
        if ((this.cpTrabajadorIdTrabajador == null && other.cpTrabajadorIdTrabajador != null) || (this.cpTrabajadorIdTrabajador != null && !this.cpTrabajadorIdTrabajador.equals(other.cpTrabajadorIdTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofincurso.AvisoPK[ trabajadorIdTrabajador=" + trabajadorIdTrabajador + ", cpFecha=" + cpFecha + ", cpTrabajadorIdTrabajador=" + cpTrabajadorIdTrabajador + " ]";
    }
    
}
