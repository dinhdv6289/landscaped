/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Utility;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BADBOY
 */
public class Session {

    public Session() {
    }

    public static void set(String key, Object value) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute(key, value);
    }

    public static Object get(String key) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        return session.getAttribute(key);
    }

    public static void invalidate() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
    }
}
