/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "tasa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasa.findAll", query = "SELECT t FROM Tasa t"),
    @NamedQuery(name = "Tasa.findByIdTasa", query = "SELECT t FROM Tasa t WHERE t.idTasa = :idTasa"),
    @NamedQuery(name = "Tasa.findByDescripcionTasa", query = "SELECT t FROM Tasa t WHERE t.descripcionTasa = :descripcionTasa"),
    @NamedQuery(name = "Tasa.findByTipo", query = "SELECT t FROM Tasa t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tasa.findByInicio", query = "SELECT t FROM Tasa t WHERE t.inicio = :inicio"),
    @NamedQuery(name = "Tasa.findByFin", query = "SELECT t FROM Tasa t WHERE t.fin = :fin")})
public class Tasa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "id_tasa")
    private String idTasa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion_tasa")
    private String descripcionTasa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    private int inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin")
    private int fin;

    public Tasa() {
    }

    public Tasa(String idTasa) {
        this.idTasa = idTasa;
    }

    public Tasa(String idTasa, String descripcionTasa, String tipo, int inicio, int fin) {
        this.idTasa = idTasa;
        this.descripcionTasa = descripcionTasa;
        this.tipo = tipo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getIdTasa() {
        return idTasa;
    }

    public void setIdTasa(String idTasa) {
        this.idTasa = idTasa;
    }

    public String getDescripcionTasa() {
        return descripcionTasa;
    }

    public void setDescripcionTasa(String descripcionTasa) {
        this.descripcionTasa = descripcionTasa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTasa != null ? idTasa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasa)) {
            return false;
        }
        Tasa other = (Tasa) object;
        if ((this.idTasa == null && other.idTasa != null) || (this.idTasa != null && !this.idTasa.equals(other.idTasa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf.modelos.Tasa[ idTasa=" + idTasa + " ]";
    }
    
}
