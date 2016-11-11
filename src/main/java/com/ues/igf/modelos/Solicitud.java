/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf.modelos;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByNumero", query = "SELECT s FROM Solicitud s WHERE s.numero = :numero"),
    @NamedQuery(name = "Solicitud.findByNombreSolicitante", query = "SELECT s FROM Solicitud s WHERE s.nombreSolicitante = :nombreSolicitante"),
    @NamedQuery(name = "Solicitud.findByNumeroContSolicitante", query = "SELECT s FROM Solicitud s WHERE s.numeroContSolicitante = :numeroContSolicitante"),
    @NamedQuery(name = "Solicitud.findByNitSolicitante", query = "SELECT s FROM Solicitud s WHERE s.nitSolicitante = :nitSolicitante"),
    @NamedQuery(name = "Solicitud.findByFecha", query = "SELECT s FROM Solicitud s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre_solicitante")
    private String nombreSolicitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_cont_solicitante")
    private int numeroContSolicitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "nit_solicitante")
    private String nitSolicitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;

    public Solicitud() {
    }

    public Solicitud(String numero) {
        this.numero = numero;
    }

    public Solicitud(String numero, String nombreSolicitante, int numeroContSolicitante, String nitSolicitante, Date fecha) {
        this.numero = numero;
        this.nombreSolicitante = nombreSolicitante;
        this.numeroContSolicitante = numeroContSolicitante;
        this.nitSolicitante = nitSolicitante;
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public int getNumeroContSolicitante() {
        return numeroContSolicitante;
    }

    public void setNumeroContSolicitante(int numeroContSolicitante) {
        this.numeroContSolicitante = numeroContSolicitante;
    }

    public String getNitSolicitante() {
        return nitSolicitante;
    }

    public void setNitSolicitante(String nitSolicitante) {
        this.nitSolicitante = nitSolicitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf.modelos.Solicitud[ numero=" + numero + " ]";
    }
    
}
