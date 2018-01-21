package com.memorynotfound.model.security;

/**
 * Created by : Ron Rith
 * Create Date: 01/21/2018.
 */
public class UserRole {
    private Integer userRoleId;
    private String role;
    private User user;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }
    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
