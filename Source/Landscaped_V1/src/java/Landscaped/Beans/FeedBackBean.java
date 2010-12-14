/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.FeedBackBO;
import Landscaped.Domain.FeedBack;
import java.util.Date;

/**
 *
 * @author BADBOY
 */
public class FeedBackBean extends FeedBack {

    /** Creates a new instance of FeedBackBean */
    public FeedBackBean() {
    }

    public String submit() {
        try {
            FeedBack fb = new FeedBack(fullName, address, email, phone, title, content, new Date());
            FeedBackBO fbBO = new FeedBackBO();
            fbBO.addNew(fb);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return "index";
    }
}
