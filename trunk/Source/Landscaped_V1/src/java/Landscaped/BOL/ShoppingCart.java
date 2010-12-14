/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.BOL;

import java.util.Hashtable;

/**
 *
 * @author BADBOY
 */
public class ShoppingCart {

    public final static int AMOUNT = 1;
    public static Hashtable<Integer, ShoppingCartItem> cart;

    public ShoppingCart() {
        cart = new Hashtable<Integer, ShoppingCartItem>();
    }

    public void addCart(ShoppingCartItem item) {
        if (cart.containsKey(item.getProductId())) {
            ShoppingCartItem cartItem = cart.get(item.getProductId());
            cartItem.setAmount(cartItem.getAmount() + 1);
            cartItem.setSubPrice(cartItem.getAmount() * item.getPrice());
        } else {
            item.setAmount(AMOUNT);
            item.setSubPrice(item.getPrice());
            cart.put(item.getProductId(), item);
        }
    }

    public static ShoppingCartItem[] getShoppingCartItems() {
        return cart.values().toArray(new ShoppingCartItem[cart.size()]);
    }

    public void emptyShoppingCart() {
        cart.clear();
        cart = new Hashtable<Integer, ShoppingCartItem>();
    }

    public static void updateCart(int id, int amount) {
        if (cart.containsKey(id)) {
            ShoppingCartItem cartItem = cart.get(id);
            cartItem.setAmount(cartItem.getAmount() + 1);
            cartItem.setSubPrice(cartItem.getAmount() * cartItem.getPrice());
        }
    }

    public static void removeCartItem(int id) {
        if (cart.containsKey(id)) {
            cart.remove(id);
        }
    }

    public static float getTotals() {
        float total = 0.0f;
        for (ShoppingCartItem item : cart.values()) {
            total += item.getSubPrice();
        }
        return total;
    }
}
