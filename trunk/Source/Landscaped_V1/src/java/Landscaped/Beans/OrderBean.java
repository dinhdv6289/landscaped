/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.OrderBO;
import Landscaped.BOL.OrderDetailsBO;
import Landscaped.BOL.ShoppingCart;
import Landscaped.BOL.ShoppingCartItem;
import Landscaped.Domain.OrderDetails;
import Landscaped.Domain.Orders;
import Landscaped.Domain.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BADBOY
 */
public class OrderBean extends Orders {

    /** Creates a new instance of OrderBean */
    public OrderBean() {
    }

    public String registerOrder() {
        if (ShoppingCart.cart != null) {
            Orders o = new Orders(shipName, shipAddress, shipPhone, shipEmail, new Date(), new Date(), true, notes);
            OrderBO orderBO;
            try {
                orderBO = new OrderBO();
                orderBO.addNew(o);
                OrderDetails ord;
                Product p;
                o.orderId = orderBO.getNewOrderInsert();

                OrderDetailsBO ordBO = new OrderDetailsBO();
                ShoppingCartItem[] items = ShoppingCart.getShoppingCartItems();
                for (ShoppingCartItem shoppingCartItem : items) {
                    ord = new OrderDetails();
                    p = new Product();
                    p.setProductId(shoppingCartItem.getProductId());
                    ord.setProduct(p);
                    ord.setOrders(o);
                    ord.setPrice(shoppingCartItem.getPrice());
                    ord.setQuantity(shoppingCartItem.getAmount());
                    ord.setTotalPrice(shoppingCartItem.getSubPrice());
                    ordBO.addNew(ord);
                }
                ShoppingCart.cart.clear();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
        return "sIndex";
    }
}
