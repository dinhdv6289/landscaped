/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Domain;

import java.util.Date;

/**
 *
 * @author BADBOY
 */
public class FeedBack implements java.io.Serializable {

    public int feedBackId;
    public String fullName;
    public String address;
    public String email;
    public String phone;
    public String title;
    public String content;
    public Date dateCreation;

    public FeedBack() {
    }

    public FeedBack(String fullName, String address, String email, String phone, String title, String content, Date dateCreation) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.content = content;
        this.dateCreation = dateCreation;
    }

    public int getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(int feedBackId) {
        this.feedBackId = feedBackId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
