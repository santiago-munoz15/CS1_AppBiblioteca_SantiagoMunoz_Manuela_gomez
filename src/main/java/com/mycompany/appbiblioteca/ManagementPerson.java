/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

import java.util.Scanner;

/**
 *
 * @author santiago.munoz
 */
public class ManagementPerson {

    private Person[][] mPerson;
    Scanner sc = new Scanner(System.in);
    private Person person;

    public ManagementPerson(Person[][] mPerson) {
        this.mPerson = mPerson;
    }

    //Metodo para ingresar una person
    public Person[][] addPerson() {

        System.out.print("Ingrese el numero de ID: ");
        String ID = sc.nextLine();
        System.out.print("Ingrese el nombre 1: ");
        String name1 = sc.nextLine();
        System.out.print("Ingrese el nombre 2: ");
        String name2 = sc.nextLine();
        System.out.print("Ingrese el apellido 1: ");
        String lastName1 = sc.nextLine();
        System.out.print("Ingrese el apellido 2: ");
        String lastName2 = sc.nextLine();
        System.out.print("Ingrese el rol de la persona: ");
        String role = sc.nextLine();

        person = new Person(ID, name1, name2, lastName1, lastName2, role);

        for (int i = 0; i < this.mPerson.length; i++) {
            Person idPerson = this.mPerson[i][0];
            if (idPerson == null) {
                this.mPerson[i][0] = person;
                System.out.println("\nGuardado exitosamente");
                break;
            }
        }
        return this.mPerson;

    }

    public void personQuery() {
        for (int i = 0; i < this.mPerson.length; i++) {
            Person idPerson = this.mPerson[i][0];

            if (idPerson != null) {
                System.out.println("Cedula: " + idPerson.getId() + " Nombre1: " + idPerson.getName1() + " Nombre 2: " + idPerson.getName2() + " Apellido1: " + idPerson.getLastName1() + " Apellido2: " + idPerson.getLastName2() + " Rol: " + idPerson.getRole());

            }
        }

    }

    //Metodo para Eliminar una person buscandola con el numero de ID
    public void deletePerson() {
        System.out.print("Ingrese el numero de ID de la persona a eliminar: ");
        String ID = sc.nextLine();

        boolean found = false;

        for (int i = 0; i < this.mPerson.length; i++) {
            Person idPerson = this.mPerson[i][0];

            if (idPerson != null && idPerson.getId().equals(ID)) {
                this.mPerson[i][0] = null;  // Eliminar la person al poner el valor en null
                System.out.println("Persona con ID " + ID + " eliminada exitosamente.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Persona con ID " + ID + " no encontrada.");
        }
    }

    //Metodo para actualizar una person con el numero de ID
    public void updatePerson() {
        System.out.print("Ingrese el numero de ID de la person a actualizar: ");
        String ID = sc.nextLine();

        boolean found = false;

        // Buscar la persona por la cedula
        for (int i = 0; i < this.mPerson.length; i++) {
            Person idPerson = this.mPerson[i][0];

            if (idPerson != null && idPerson.getId().equals(ID)) {
                found = true;

                // Mostrar los datos actuales de la person
                System.out.print("Datos actuales:");
                System.out.print("Nombre 1: " + idPerson.getName1());
                System.out.print("Nombre 2: " + idPerson.getName2());
                System.out.print("Apellido 1: " + idPerson.getLastName1());
                System.out.print("Apellido 2: " + idPerson.getLastName2());
                System.out.print("Rol: " + idPerson.getRole());

                // Actualizar los datos
                //Se solicita ingresar un nuevo dato y se añade con el .setNombre
                System.out.print("Ingrese el nuevo nombre 1 (dejar en blanco para no modificar): ");
                String newName1 = sc.nextLine();
                if (!newName1.isEmpty()) { // is.Empty verifica si una cadena existe pero no contiene caracteres
                    idPerson.setName1(newName1);
                }

                System.out.print("Ingrese el nuevo nombre 2 (dejar en blanco para no modificar): ");
                String newName2 = sc.nextLine();
                if (!newName2.isEmpty()) { // is.Empty verifica si una cadena existe pero no contiene caracteres
                    idPerson.setName2(newName2);
                }

                System.out.print("Ingrese el nuevo apellido 1 (dejar en blanco para no modificar): ");
                String newSurname1 = sc.nextLine();
                if (!newSurname1.isEmpty()) { // is.Empty verifica si una cadena existe pero no contiene caracteres
                    idPerson.setLastName1(newSurname1);
                }

                System.out.print("Ingrese el nuevo apellido 2 (dejar en blanco para no modificar): ");
                String newSurname2 = sc.nextLine();
                if (!newSurname2.isEmpty()) { // is.Empty verifica si una cadena existe pero no contiene caracteres
                    idPerson.setLastName2(newSurname2);
                }

                System.out.print("Ingrese el nuevo role (dejar en blanco para no modificar): ");
                String newRole = sc.nextLine();
                if (!newRole.isEmpty()) { // is.Empty verifica si una cadena existe pero no contiene caracteres
                    idPerson.setRole(newRole);
                }

                System.out.println("Datos actualizados exitosamente.");
                break;
            }
        }

        if (!found) {
            System.out.println("Persona con ID " + ID + " no encontrada.");
        }
    }
}
