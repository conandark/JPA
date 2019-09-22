/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author x-tion
 */
@Entity
@Table(name = "tblcustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcustomer.findAll", query = "SELECT t FROM Tblcustomer t"),
    @NamedQuery(name = "Tblcustomer.findByTblcustomerId", query = "SELECT t FROM Tblcustomer t WHERE t.tblcustomerId = :tblcustomerId"),
    @NamedQuery(name = "Tblcustomer.findByName", query = "SELECT t FROM Tblcustomer t WHERE t.name = :name"),
    @NamedQuery(name = "Tblcustomer.findBySurname", query = "SELECT t FROM Tblcustomer t WHERE t.surname = :surname")})
public class Tblcustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tblcustomer_id")
    private Integer tblcustomerId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @JoinColumn(name = "tblprefix_id", referencedColumnName = "tblprefix_id")
    @ManyToOne(optional = false)
    private Tblprefix tblprefixId;

    public Tblcustomer() {
    }

    public Tblcustomer(Integer tblcustomerId) {
        this.tblcustomerId = tblcustomerId;
    }

    public Integer getTblcustomerId() {
        return tblcustomerId;
    }

    public void setTblcustomerId(Integer tblcustomerId) {
        this.tblcustomerId = tblcustomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Tblprefix getTblprefixId() {
        return tblprefixId;
    }

    public void setTblprefixId(Tblprefix tblprefixId) {
        this.tblprefixId = tblprefixId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblcustomerId != null ? tblcustomerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcustomer)) {
            return false;
        }
        Tblcustomer other = (Tblcustomer) object;
        if ((this.tblcustomerId == null && other.tblcustomerId != null) || (this.tblcustomerId != null && !this.tblcustomerId.equals(other.tblcustomerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tblcustomer[ tblcustomerId=" + tblcustomerId + " ]";
    }
    
}
