/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

/**
 *
 * @author santy
 */
public abstract class User {

    protected String ID;
    protected String name1;
    protected String name2;
    protected String lastName1;
    protected String lastName2;
    protected String role;

    public User(String ID, String name1, String name2, String lastName1, String lastName2, String role) {
        this.ID = ID;
        this.name1 = name1;
        this.name2 = name2;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.role = role;
    }

    public abstract void showUserInfo();

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
