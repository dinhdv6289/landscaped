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
public class Product implements java.io.Serializable {

    private int productId;
    private Categories category;
    private Account account;
    private String productName;
    private float price;
    private String description;
    private Date dateCreation;
    private Date dateModify;
    private boolean state;
    private Set pictureProducts = new HashSet(0);

    public Product() {
    }

    public Product(int productId, Categories category, Account account, String productName, float price, String description, Date dateCreation, Date dateModify, boolean state, Set pictureProducts) {
        this.productId = productId;
        this.category = category;
        this.account = account;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateModify = dateModify;
        this.state = state;
        this.pictureProducts = pictureProducts;
    }

    public Set getPictureProducts() {
        return pictureProducts;
    }

    public void setPictureProducts(Set pictureProducts) {
        this.pictureProducts = pictureProducts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
