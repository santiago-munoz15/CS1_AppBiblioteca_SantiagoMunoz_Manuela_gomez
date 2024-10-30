/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

/**
 *
 * @author santiago.munoz
 */
public class Material extends LibraryItem {

    private String typeMaterial;

    public Material(String identifier, String typeMaterial, String title, String registrationDate, int registeredAmount, int currentQuantity) {
        super(identifier, typeMaterial, title, registrationDate, registeredAmount, currentQuantity);
        this.typeMaterial = typeMaterial;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + identifier + " Tipo de Material: " + typeMaterial + " Titulo: " + title + " Cantidad actual: " + currentQuantity);
    }
}
