/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darren
 */
@Entity
@Table(name = "PACKAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findByPackagesId", query = "SELECT p FROM Packages p WHERE p.packagesId = :packagesId"),
    @NamedQuery(name = "Packages.findByName", query = "SELECT p FROM Packages p WHERE p.name = :name"),
    @NamedQuery(name = "Packages.findByDescription", query = "SELECT p FROM Packages p WHERE p.description = :description"),
    @NamedQuery(name = "Packages.findByDuration", query = "SELECT p FROM Packages p WHERE p.duration = :duration"),
    @NamedQuery(name = "Packages.findByPrice", query = "SELECT p FROM Packages p WHERE p.price = :price")})
public class Packages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PACKAGES_ID")
    private Integer packagesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DURATION")
    @Size(max = 100)
    private String duration;
    @Column(name = "PRICE")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packageFk")
    private Collection<Bookings> bookingsCollection;

    public Packages() {
    }

    public Packages(Integer packagesId) {
        this.packagesId = packagesId;
    }

    public Packages(Integer packagesId, String name, String description) {
        this.packagesId = packagesId;
        this.name = name;
        this.description = description;
    }

    public Integer getPackagesId() {
        return packagesId;
    }

    public void setPackagesId(Integer packagesId) {
        this.packagesId = packagesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Bookings> getBookingsCollection() {
        return bookingsCollection;
    }

    public void setBookingsCollection(Collection<Bookings> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (packagesId != null ? packagesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Packages)) {
            return false;
        }
        Packages other = (Packages) object;
        if ((this.packagesId == null && other.packagesId != null) || (this.packagesId != null && !this.packagesId.equals(other.packagesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Packages[ packagesId=" + packagesId + " ]";
    }
    
}
