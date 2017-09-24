/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
 * @author darren
 */
@Entity
@Table(name = "BOOKINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookings.findAll", query = "SELECT b FROM Bookings b"),
    @NamedQuery(name = "Bookings.findByBookingId", query = "SELECT b FROM Bookings b WHERE b.bookingId = :bookingId"),
    @NamedQuery(name = "Bookings.findByDateDay", query = "SELECT b FROM Bookings b WHERE b.dateDay = :dateDay"),
    @NamedQuery(name = "Bookings.findByTimeDay", query = "SELECT b FROM Bookings b WHERE b.timeDay = :timeDay")})
public class Bookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_ID")
    private Integer bookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_DAY")
    @Size(max = 100)
    private String dateDay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIME_DAY")
    @Size(max = 100)
    private String timeDay;
    @JoinColumn(name = "CUSTOMER_FK", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customers customerFk;
    @JoinColumn(name = "PACKAGE_FK", referencedColumnName = "PACKAGES_ID")
    @ManyToOne(optional = false)
    private Packages packageFk;

    public Bookings() {
    }

    public Bookings(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Bookings(Integer bookingId, String dateDay, String timeDay) {
        this.bookingId = bookingId;
        this.dateDay = dateDay;
        this.timeDay = timeDay;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getDateDay() {
        return dateDay;
    }

    public void setDateDay(String dateDay) {
        this.dateDay = dateDay;
    }

    public String getTimeDay() {
        return timeDay;
    }

    public void setTimeDay(String timeDay) {
        this.timeDay = timeDay;
    }

    public Customers getCustomerFk() {
        return customerFk;
    }

    public void setCustomerFk(Customers customerFk) {
        this.customerFk = customerFk;
    }

    public Packages getPackageFk() {
        return packageFk;
    }

    public void setPackageFk(Packages packageFk) {
        this.packageFk = packageFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingId != null ? bookingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookings)) {
            return false;
        }
        Bookings other = (Bookings) object;
        if ((this.bookingId == null && other.bookingId != null) || (this.bookingId != null && !this.bookingId.equals(other.bookingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bookings[ bookingId=" + bookingId + " ]";
    }
    
}
