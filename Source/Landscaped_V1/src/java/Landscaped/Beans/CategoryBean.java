/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Beans;

import Landscaped.BOL.*;
import Landscaped.Domain.Categories;
import java.util.List;

/**
 *
 * @author BADBOY
 */
public class CategoryBean {

    /** Creates a new instance of CategoryBean */
    public CategoryBean() {
    }
    private List<Categories> listCategory;

    {
        loadListCategory(); // Preload in initialization block.
    }

    private void loadListCategory() {
        try {
            CategoryBO cateBO = new CategoryBO();
            listCategory = cateBO.getMenuCategory();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public List<Categories> getListCategory() {
        return listCategory;
    }
}
