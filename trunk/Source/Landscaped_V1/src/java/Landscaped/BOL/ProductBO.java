/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.BOL;

import Landscaped.DAO.BaseUtil;
import Landscaped.Domain.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BADBOY
 */
public class ProductBO extends BaseUtil<Product> {

    public ProductBO() throws Exception {
    }

    public List<Product> getAllProduct() {
        String[] sort = new String[]{"productId desc"};
        try {
            List<Product> listProduct = getBySQLQuery(sort, 0);
            return listProduct;
        } catch (Exception ex) {
            ex.toString();
            return null;
        }
    }

    public List getAllListProduct() {
        List list = null;
        String[] sort = new String[]{"productId desc"};
        String sql = "from Product";
        String query = "from Product as p,PictureProducts as pp  "
                + "where p.productId = pp.product.productId "
                + "and pp.primaryImage =1";
        try {
            list = excecuteSQlQuery(query);
            return list;
        } catch (Exception ex) {
            ex.getMessage();
            return null;
        }
    }
}
