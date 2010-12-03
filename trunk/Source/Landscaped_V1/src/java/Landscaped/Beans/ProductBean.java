/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.ProductBO;
import Landscaped.Domain.Product;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author BADBOY
 */
@ManagedBean
@RequestScoped
public class ProductBean {

    /** Creates a new instance of ProductBean */
    ProductBO productBO;

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
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public List getListProduct() {
        return listProduct;
    }

    public List<Product> getDataList() {
        return dataList;
    }
}
