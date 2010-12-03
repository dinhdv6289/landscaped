/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Domain;

/**
 *
 * @author BADBOY
 */
public class PictureProducts implements java.io.Serializable {

    private int pictureId;
    private Product product;
    private String pathImage;
    private boolean primaryImage;

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public boolean isPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(boolean primaryImage) {
        this.primaryImage = primaryImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
