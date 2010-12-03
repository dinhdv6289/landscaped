/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Landscaped.Domain;

/**
 *
 * @author BADBOY
 */
public class Roles implements java.io.Serializable {

    private int roleId;
    private String roleName;
    private String description;

    public Roles() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
