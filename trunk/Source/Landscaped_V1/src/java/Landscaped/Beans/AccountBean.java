/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.AccountBO;
import Landscaped.Domain.Account;
import Landscaped.Domain.Roles;
import Landscaped.Utility.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author BADBOY
 */
public class AccountBean extends Account {

    private String msg;
    private boolean isLogin;
    private String showUserName;
    private static String fileName = "";
    private static Account current;

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
                Session.set("user", account);
                current = accountBO.getAccountByUserName(username);
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

    public void fileUploadListener(FileUploadEvent event) {
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();

        if (!fileName.equals("")) {
            File file = new File(extContext.getRealPath("/AccountImages") + "//" + fileName);
            file.delete();
        }
        Date d = new Date();
        fileName = String.valueOf(d.getYear() + "" + d.getMonth() + 1 + "" + d.getDate() + ""
                + d.getHours() + "" + d.getMinutes() + "" + d.getSeconds() + ".jpg");
        File result = new File(extContext.getRealPath("/AccountImages") + "//" + fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);
            byte[] buffer = new byte[1024];
            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            FacesMessage facesMsg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String register() {
        Roles r = new Roles();
        r.setRoleId(1);
        if (!fileName.equals("")) {
            fileName = "AccountImages/" + fileName;
        }
        Account a = new Account(r, username, password, fileName, compartment, fullName, homePhone, mobilePhone, email, address, true);
        AccountBO accountBO;
        try {
            accountBO = new AccountBO();
            accountBO.addNew(a);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return "sIndex";
    }

    public String updateInfo() {
        try {
            AccountBO accountBO = new AccountBO();
            accountBO.update(current);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return "/index";
    }

    public String logout() {
        Session.invalidate();
        return "/index";
    }

    public String getShowUserName() {
        Account a = (Account) Session.get("user");
        return a.getUsername();
    }

    public boolean getIsLogin() {
        if (Session.get("user") != null) {
            return true;
        }
        return false;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Account getCurrent() {
        return current;
    }

    public void setCurrent(Account current) {
        this.current = current;
    }
}
