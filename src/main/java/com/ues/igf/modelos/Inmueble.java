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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "inmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i"),
    @NamedQuery(name = "Inmueble.findByClaveCatastral", query = "SELECT i FROM Inmueble i WHERE i.claveCatastral = :claveCatastral"),
    @NamedQuery(name = "Inmueble.findByDireccion", query = "SELECT i FROM Inmueble i WHERE i.direccion = :direccion"),
    @NamedQuery(name = "Inmueble.findByTipoInmueble", query = "SELECT i FROM Inmueble i WHERE i.tipoInmueble = :tipoInmueble"),
    @NamedQuery(name = "Inmueble.findByTipoAlumbrado", query = "SELECT i FROM Inmueble i WHERE i.tipoAlumbrado = :tipoAlumbrado"),
    @NamedQuery(name = "Inmueble.findByComercio", query = "SELECT i FROM Inmueble i WHERE i.comercio = :comercio"),
    @NamedQuery(name = "Inmueble.findByValor", query = "SELECT i FROM Inmueble i WHERE i.valor = :valor"),
    @NamedQuery(name = "Inmueble.findByMetros", query = "SELECT i FROM Inmueble i WHERE i.metros = :metros"),
    @NamedQuery(name = "Inmueble.findBySuperficie", query = "SELECT i FROM Inmueble i WHERE i.superficie = :superficie"),
    @NamedQuery(name = "Inmueble.findByObservaciones", query = "SELECT i FROM Inmueble i WHERE i.observaciones = :observaciones")})
public class Inmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clave_catastral")
    private String claveCatastral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_inmueble")
    private String tipoInmueble;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo_alumbrado")
    private String tipoAlumbrado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comercio")
    private boolean comercio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metros")
    private double metros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "superficie")
    private double superficie;
    @Size(max = 250)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_contribuyente", referencedColumnName = "id_contribuyente")
    @ManyToOne
    private Contribuyente idContribuyente;
    @JoinColumn(name = "identificador_impuesto", referencedColumnName = "identificador_impuesto")
    @ManyToOne
    private Impuesto identificadorImpuesto;

    public Inmueble() {
    }

    public Inmueble(String claveCatastral) {
        this.claveCatastral = claveCatastral;
    }

    public Inmueble(String claveCatastral, String direccion, String tipoInmueble, String tipoAlumbrado, boolean comercio, double valor, double metros, double superficie) {
        this.claveCatastral = claveCatastral;
        this.direccion = direccion;
        this.tipoInmueble = tipoInmueble;
        this.tipoAlumbrado = tipoAlumbrado;
        this.comercio = comercio;
        this.valor = valor;
        this.metros = metros;
        this.superficie = superficie;
    }

    public String getClaveCatastral() {
        return claveCatastral;
    }

    public void setClaveCatastral(String claveCatastral) {
        this.claveCatastral = claveCatastral;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getTipoAlumbrado() {
        return tipoAlumbrado;
    }

    public void setTipoAlumbrado(String tipoAlumbrado) {
        this.tipoAlumbrado = tipoAlumbrado;
    }

    public boolean getComercio() {
        return comercio;
    }

    public void setComercio(boolean comercio) {
        this.comercio = comercio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Contribuyente getIdContribuyente() {
        return idContribuyente;
    }

    public void setIdContribuyente(Contribuyente idContribuyente) {
        this.idContribuyente = idContribuyente;
    }

    public Impuesto getIdentificadorImpuesto() {
        return identificadorImpuesto;
    }

    public void setIdentificadorImpuesto(Impuesto identificadorImpuesto) {
        this.identificadorImpuesto = identificadorImpuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveCatastral != null ? claveCatastral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.claveCatastral == null && other.claveCatastral != null) || (this.claveCatastral != null && !this.claveCatastral.equals(other.claveCatastral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf.modelos.Inmueble[ claveCatastral=" + claveCatastral + " ]";
    }
    
}
