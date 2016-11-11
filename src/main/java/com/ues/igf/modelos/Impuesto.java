/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "impuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impuesto.findAll", query = "SELECT i FROM Impuesto i"),
    @NamedQuery(name = "Impuesto.findByDescripcion", query = "SELECT i FROM Impuesto i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Impuesto.findByValor", query = "SELECT i FROM Impuesto i WHERE i.valor = :valor"),
    @NamedQuery(name = "Impuesto.findByIdentificadorImpuesto", query = "SELECT i FROM Impuesto i WHERE i.identificadorImpuesto = :identificadorImpuesto")})
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "_valor")
    private double valor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificador_impuesto")
    private Integer identificadorImpuesto;
    @OneToMany(mappedBy = "identificadorImpuesto")
    private List<Inmueble> inmuebleList;

    public Impuesto() {
    }

    public Impuesto(Integer identificadorImpuesto) {
        this.identificadorImpuesto = identificadorImpuesto;
    }

    public Impuesto(Integer identificadorImpuesto, String descripcion, double valor) {
        this.identificadorImpuesto = identificadorImpuesto;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getIdentificadorImpuesto() {
        return identificadorImpuesto;
    }

    public void setIdentificadorImpuesto(Integer identificadorImpuesto) {
        this.identificadorImpuesto = identificadorImpuesto;
    }

    @XmlTransient
    public List<Inmueble> getInmuebleList() {
        return inmuebleList;
    }

    public void setInmuebleList(List<Inmueble> inmuebleList) {
        this.inmuebleList = inmuebleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificadorImpuesto != null ? identificadorImpuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impuesto)) {
            return false;
        }
        Impuesto other = (Impuesto) object;
        if ((this.identificadorImpuesto == null && other.identificadorImpuesto != null) || (this.identificadorImpuesto != null && !this.identificadorImpuesto.equals(other.identificadorImpuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf.modelos.Impuesto[ identificadorImpuesto=" + identificadorImpuesto + " ]";
    }
    
}
