/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Domain;

/**
 *
 * @author BADBOY
 */
public class Account implements java.io.Serializable {

    public int accountId;
    public Roles roles;
    public String username;
    public String password;
    public String picture;
    public String compartment;
    public String fullName;
    public String homePhone;
    public String mobilePhone;
    public String email;
    public String address;
    public boolean state;

    public Account() {
    }

    public Account(Roles roles, String username, String password, String picture, String compartment, String fullName, String homePhone, String mobilePhone, String email, String address, boolean state) {
        this.roles = roles;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.compartment = compartment;
        this.fullName = fullName;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.address = address;
        this.state = state;
    }

    public Account(int accountId, String username, String password, String picture, String compartment, String homePhone, String mobilePhone, String email, String address) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.compartment = compartment;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompartment() {
        return compartment;
    }

    public void setCompartment(String compartment) {
        this.compartment = compartment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
