package edu.epam.finalproject.entity;

public enum UserRole {
    CLIENT(1), BUTLER(2), OWNER(3);
    private int roleId;

    UserRole(int id) {
        roleId = id;
    }
    public int getRoleId(){
        return roleId;
    }
}
