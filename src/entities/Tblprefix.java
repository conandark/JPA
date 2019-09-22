/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author x-tion
 */
@Entity
@Table(name = "tblprefix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblprefix.findAll", query = "SELECT t FROM Tblprefix t"),
    @NamedQuery(name = "Tblprefix.findByTblprefixId", query = "SELECT t FROM Tblprefix t WHERE t.tblprefixId = :tblprefixId"),
    @NamedQuery(name = "Tblprefix.findByName", query = "SELECT t FROM Tblprefix t WHERE t.name = :name")})
public class Tblprefix implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tblprefix_id")
    private Integer tblprefixId;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblprefixId")
    private List<Tblcustomer> tblcustomerList;

    public Tblprefix() {
        this.name = "Default";
    }

    public Tblprefix(Integer tblprefixId) {
        this.tblprefixId = tblprefixId;
    }

    public Integer getTblprefixId() {
        return tblprefixId;
    }

    public void setTblprefixId(Integer tblprefixId) {
        this.tblprefixId = tblprefixId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Tblcustomer> getTblcustomerList() {
        return tblcustomerList;
    }

    public void setTblcustomerList(List<Tblcustomer> tblcustomerList) {
        this.tblcustomerList = tblcustomerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblprefixId != null ? tblprefixId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblprefix)) {
            return false;
        }
        Tblprefix other = (Tblprefix) object;
        if ((this.tblprefixId == null && other.tblprefixId != null) || (this.tblprefixId != null && !this.tblprefixId.equals(other.tblprefixId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tblprefix[ tblprefixId=" + tblprefixId + " ]";
    }

}
