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
public class CpPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "TRABAJADOR_ID_TRABAJADOR")
    private BigInteger trabajadorIdTrabajador;

    public CpPK() {
    }

    public CpPK(Date fecha, BigInteger trabajadorIdTrabajador) {
        this.fecha = fecha;
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getTrabajadorIdTrabajador() {
        return trabajadorIdTrabajador;
    }

    public void setTrabajadorIdTrabajador(BigInteger trabajadorIdTrabajador) {
        this.trabajadorIdTrabajador = trabajadorIdTrabajador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (trabajadorIdTrabajador != null ? trabajadorIdTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CpPK)) {
            return false;
        }
        CpPK other = (CpPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.trabajadorIdTrabajador == null && other.trabajadorIdTrabajador != null) || (this.trabajadorIdTrabajador != null && !this.trabajadorIdTrabajador.equals(other.trabajadorIdTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofincurso.CpPK[ fecha=" + fecha + ", trabajadorIdTrabajador=" + trabajadorIdTrabajador + " ]";
    }
    
}
