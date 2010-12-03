/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Domain;

/**
 *
 * @author BADBOY
 */
public class Categories implements java.io.Serializable {

    private int categoryId;
    private String categoryName;
    private String description;

    public Categories() {
    }

    public Categories(int categoryId, String categoryName, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
