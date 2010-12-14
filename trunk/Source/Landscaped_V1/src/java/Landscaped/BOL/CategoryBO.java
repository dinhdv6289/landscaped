/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.BOL;

import Landscaped.DAO.BaseUtil;
import Landscaped.Domain.Categories;
import java.util.List;

/**
 *
 * @author BADBOY
 */
public class CategoryBO extends BaseUtil<Categories> {

    public CategoryBO() throws Exception {
    }

    public List<Categories> getMenuCategory() {
        String[] sort = new String[]{"categoryId desc"};
        try {
            List<Categories> listCategory = getBySQLQuery(sort, 0);
            return listCategory;
        } catch (Exception ex) {
            ex.toString();
            return null;
        }
    }
}
