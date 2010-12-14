/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.ShoppingCart;
import Landscaped.BOL.ShoppingCartItem;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author BADBOY
 */
public class ShoppingCartBean {

    /** Creates a new instance of ShoppingCartBean */
    ShoppingCartItem[] items;
    float totalPrice;
    int amount;
    int productId;

    public ShoppingCartBean() {
    }

    public ShoppingCartItem[] getItems() {
        if (ShoppingCart.cart != null) {
            return ShoppingCart.cart.values().toArray(new ShoppingCartItem[ShoppingCart.cart.size()]);
        }
        return null;
    }

    public String updateCart() {
        try {
            ShoppingCart.updateCart(productId, amount);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error message", "Lỗi cập nhập giỏ hàng");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return "shoppingCart";
    }

    public String removeCart() {
        ShoppingCart.removeCartItem(productId);
        return "shoppingCart";
    }

    public String removeAllCart() {
        ShoppingCart.cart.clear();
        return "shoppingCart";
    }

    public void setItems(ShoppingCartItem[] items) {
        this.items = items;
    }

    public float getTotalPrice() {
        return ShoppingCart.getTotals();
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
