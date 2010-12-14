/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.ProductBO;
import Landscaped.BOL.ShoppingCart;
import Landscaped.BOL.ShoppingCartItem;
import Landscaped.Domain.Product;
import Landscaped.Utility.SendMail;
import Landscaped.Utility.Session;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

/**
 *
 * @author BADBOY
 */
@ManagedBean
@RequestScoped
public class ProductBean extends Product {

    /** Creates a new instance of ProductBean */
    UIData selectedRow;
    Product p = new Product();
    static Product current;
    ProductBO productBO;
    private String showDetails;

    public ProductBean() {
    }
    private List<Product> dataList;

    {
        loadDataList(); // Preload in initialization block.
    }

    private void loadDataList() {
        try {
            productBO = new ProductBO();
            dataList = productBO.getAllProduct();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    private List listProduct;

    {
        loadListProduct(); // Preload in initialization block.
    }

    private void loadListProduct() {
        try {
            productBO = new ProductBO();
            listProduct = productBO.getAllListProduct();
           // SendMail sm = new SendMail();
          // sm.SendMailClient();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public List getListProduct() {
        return listProduct;
    }
    private static List listProductByCategory;

    private void loadListProductByCategory() {
        try {
            productBO = new ProductBO();
            listProductByCategory = productBO.getAllProductByCategory(category);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public List getListProductByCategory() {
        return listProductByCategory;
    }

    public String viewProductByCategory() {

//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("product.xhtml");
//        } catch (IOException ex) {
//            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
        loadListProductByCategory();
        return "product";
    }

    public List<Product> getDataList() {
        return dataList;
    }

    public String getshowDetails() {
        return "productDetails";
    }

    public String viewDetail() {
        return "productDetails";
    }

    public String viewProduct() {
//        try {
//            FacesContext.getCurrentInstance().getExternalContext().redirect("product.xhtml");
//        } catch (IOException ex) {
//            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return "product";
    }

    public String viewBuy() {
        ShoppingCartItem item = new ShoppingCartItem(current.getProductId(), current.getProductName(), current.getPrice());
        if (Session.get("shoppingCart") == null) {
            ShoppingCart cart = new ShoppingCart();
            cart.addCart(item);
            Session.set("shoppingCart", cart);
        } else {
            ShoppingCart cart = (ShoppingCart) Session.get("shoppingCart");
            cart.addCart(item);
        }
        return "sCart";
    }

    public Product getSelected() {
        if (current == null) {
            current = new Product();
        }
        return current;
    }

    public UIData getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(UIData selectedRow) {
        this.selectedRow = selectedRow;
    }

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    public Product getCurrent() {
        return current;
    }

    public void setCurrent(Product current) {
        this.current = current;
    }
}
