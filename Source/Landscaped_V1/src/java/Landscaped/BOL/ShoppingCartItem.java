/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.BOL;

import Landscaped.Domain.Product;

/**
 *
 * @author BADBOY
 */
public class ShoppingCartItem extends Product {

    private int amount;
    private float subPrice;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(int proId, String proName, float price) {
        super(proId, proName, price);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getSubPrice() {
        return subPrice;
    }

    public void setSubPrice(float subPrice) {
        this.subPrice = subPrice;
    }
}
