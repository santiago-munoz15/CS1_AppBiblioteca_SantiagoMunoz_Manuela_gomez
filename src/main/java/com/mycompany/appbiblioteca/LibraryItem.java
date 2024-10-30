/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

/**
 *
 * @author santy
 */
public abstract class LibraryItem {

    protected String identifier;
    protected String typeMaterial;
    protected String title;
    protected String registrationDate;
    protected int registeredAmount;
    protected int currentQuantity;

    public LibraryItem(String identifier, String typeMaterial, String title, String registrationDate, int registeredAmount, int currentQuantity) {
        this.identifier = identifier;
        this.typeMaterial = typeMaterial;
        this.title = title;
        this.registrationDate = registrationDate;
        this.registeredAmount = registeredAmount;
        this.currentQuantity = currentQuantity;
    }

    public abstract void displayInfo();

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getRegisteredAmount() {
        return registeredAmount;
    }

    public void setRegisteredAmount(int registeredAmount) {
        this.registeredAmount = registeredAmount;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
    
    
    
}
