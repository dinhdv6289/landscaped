/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.AccountBO;
import Landscaped.Domain.Account;

/**
 *
 * @author BADBOY
 */
public class AccountBean {

    private String username;
    private String password;
    private String msg;

    /** Creates a new instance of AccountBean */
    public AccountBean() {
    }

    public String authencation() {
        try {
            AccountBO accountBO = new AccountBO();
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            if (accountBO.authencation(account)) {
                //   Session.set("user", admin);
                msg = "Login success.";
                return "index";
            }
        } catch (Exception ex) {
            msg = ex.toString();
            return "index";
        }
        msg = "Login failed.";
        return "index";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
