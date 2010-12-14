/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.BOL;

import Landscaped.DAO.BaseUtil;
import Landscaped.Domain.Account;
import java.util.List;

/**
 *
 * @author BADBOY
 */
public class AccountBO extends BaseUtil<Account> {

    public AccountBO() throws Exception {
    }

    public boolean authencation(Account account) {
        try {
            String query = "[Username]='" + account.getUsername() + "' and [Password]='" + account.getPassword() + "'";

            List<Account> list = getBySQLQuery(query, null, 0);

            if (list.size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.toString();
            return false;
        }
    }

    public Account getAccountByUserName(String username) {
        try {

            String query = "[username]='" + username + "'";
            List<Account> list = getBySQLQuery(query, null, 0);
            return list.get(0);

        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }
}
