/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.BOL;

import Landscaped.DAO.BaseUtil;
import Landscaped.Domain.Orders;
import java.util.List;

/**
 *
 * @author BADBOY
 */
public class OrderBO extends BaseUtil<Orders> {

    public OrderBO() throws Exception {
    }

    public int getNewOrderInsert() {
        List list = null;
        try {
            String sql = "select max(orderId) from Orders";
            list = excecuteSQlQuery(sql);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return Integer.parseInt(String.valueOf(list.get(0)));
    }
}
