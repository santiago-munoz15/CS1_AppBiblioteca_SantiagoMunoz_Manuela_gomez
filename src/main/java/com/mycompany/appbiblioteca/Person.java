/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

/**
 *
 * @author santiago.munoz
 */
public class Person extends User {

    public Person(String ID, String name1, String name2, String lastName1, String lastName2, String role) {
        super(ID, name1, name2, lastName1, lastName2, role);
    }

    @Override
    public void showUserInfo() {
        System.out.println("Cedula: " + ID + " Nombre1: " + name1 + " Nombre2: " + name2 + " Apellido1: " + lastName1 + " Apellido2: " + lastName2 + " Rol: " + role);
    }

}
