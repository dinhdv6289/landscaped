/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author BADBOY
 */
public class Orders implements java.io.Serializable {

    public int orderId;
    public String shipName;
    public String shipAddress;
    public String shipPhone;
    public String shipEmail;
    public Date dateCreation;
    public Date deliveryDate;
    public boolean state;
    public String notes;
    private Set orderDetails = new HashSet(0);

    public Orders() {
    }

    public Orders(String shipName, String shipAddress, String shipPhone, String shipEmail, Date dateCreation, Date deliveryDate, boolean state, String notes) {
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipPhone = shipPhone;
        this.shipEmail = shipEmail;
        this.dateCreation = dateCreation;
        this.deliveryDate = deliveryDate;
        this.state = state;
        this.notes = notes;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }
}
