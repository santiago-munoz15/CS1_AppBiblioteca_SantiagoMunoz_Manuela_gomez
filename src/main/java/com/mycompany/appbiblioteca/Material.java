/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

/**
 *
 * @author santiago.munoz
 */
public class Material {

    String identifier;
    String title;
    String registrationDate;
    String typeMaterial;
    int registeredAmount;
    int currentQuantity;

    //Metodo constructor
    public Material(String identifier, String title, String typeMaterial, String registrationDate, int registeredAmount, int currentQuantity) {
        this.identifier = identifier;
        this.title = title;
        this.typeMaterial = typeMaterial;
        this.registrationDate = registrationDate;
        this.registeredAmount = registeredAmount;
        this.currentQuantity = currentQuantity;
    }

    //Setters y Getters
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

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

}
