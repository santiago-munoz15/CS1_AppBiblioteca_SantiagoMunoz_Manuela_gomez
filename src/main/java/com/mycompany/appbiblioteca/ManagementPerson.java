/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        try {
            System.out.print("Ingrese el numero de ID: ");
            String ID = sc.nextLine();
            if (ID.trim().isEmpty()) {
                System.out.println("Error: El ID no puede estar vacio.");
                return this.mPerson;
            }

            System.out.print("Ingrese el nombre 1: ");
            String name1 = sc.nextLine();
            if (name1.trim().isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacio.");
                return this.mPerson;
            }

            System.out.print("Ingrese el nombre 2: ");
            String name2 = sc.nextLine();

            System.out.print("Ingrese el apellido 1: ");
            String lastName1 = sc.nextLine();
            if (lastName1.trim().isEmpty()) {
                System.out.println("Error: El apellido no puede estar vacio.");
                return this.mPerson;
            }

            System.out.print("Ingrese el apellido 2: ");
            String lastName2 = sc.nextLine();

            System.out.print("Ingrese el rol de la persona: ");
            String role = sc.nextLine();
            if (role.trim().isEmpty()) {
                System.out.println("Error: El rol no puede estar vacio.");
                return this.mPerson;
            }

            person = new Person(ID, name1, name2, lastName1, lastName2, role);

            for (int i = 0; i < this.mPerson.length; i++) {
                Person idPerson = this.mPerson[i][0];
                if (idPerson == null) {
                    this.mPerson[i][0] = person;
                    System.out.println("\nGuardado exitosamente");

                    // Guardar en archivo despues de agregar la persona
                    savePersonToFile(person);

                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al ingresar la persona: " + e.getMessage());
        }

        return this.mPerson;

    }

    public void personQuery() {
        for (int i = 0; i < this.mPerson.length; i++) {
            Person idPerson = this.mPerson[i][0];

            if (idPerson != null) {
                System.out.println("Cedula: " + idPerson.getID() + " Nombre1: " + idPerson.getName1() + " Nombre 2: " + idPerson.getName2() + " Apellido1: " + idPerson.getLastName1() + " Apellido2: " + idPerson.getLastName2() + " Rol: " + idPerson.getRole());

            }
        }

    }

    //Metodo para Eliminar una person buscandola con el numero de ID
    public void deletePerson() {
        try {
            System.out.print("Ingrese el numero de ID de la persona a eliminar: ");
            String ID = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < this.mPerson.length; i++) {
                Person idPerson = this.mPerson[i][0];

                if (idPerson != null && idPerson.getID().equals(ID)) {
                    this.mPerson[i][0] = null;
                    System.out.println("Persona con ID " + ID + " eliminada exitosamente.");
                    found = true;
                    // Sobrescribir el archivo despues de eliminar la persona
                    overwritePersonFile();
                    break;
                }
            }

            if (!found) {
                System.out.println("Persona con ID " + ID + " no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al eliminar la persona: " + e.getMessage());
        }
    }

    //Metodo para actualizar una person con el numero de ID
    public void updatePerson() {
        try {
            System.out.print("Ingrese el numero de ID de la person a actualizar: ");
            String ID = sc.nextLine();

            boolean found = false;

            for (int i = 0; i < this.mPerson.length; i++) {
                Person idPerson = this.mPerson[i][0];

                if (idPerson != null && idPerson.getID().equals(ID)) {
                    found = true;

                    // Mostrar los datos actuales de la person
                    System.out.println("Datos actuales:");
                    System.out.println("Nombre 1: " + idPerson.getName1());
                    System.out.println("Nombre 2: " + idPerson.getName2());
                    System.out.println("Apellido 1: " + idPerson.getLastName1());
                    System.out.println("Apellido 2: " + idPerson.getLastName2());
                    System.out.println("Rol: " + idPerson.getRole());

                    // Actualizar los datos
                    System.out.print("Ingrese el nuevo nombre 1 (dejar en blanco para no modificar): ");
                    String newName1 = sc.nextLine();
                    if (!newName1.trim().isEmpty()) {
                        idPerson.setName1(newName1);
                    }

                    System.out.print("Ingrese el nuevo nombre 2 (dejar en blanco para no modificar): ");
                    String newName2 = sc.nextLine();
                    if (!newName2.trim().isEmpty()) {
                        idPerson.setName2(newName2);
                    }

                    System.out.print("Ingrese el nuevo apellido 1 (dejar en blanco para no modificar): ");
                    String newSurname1 = sc.nextLine();
                    if (!newSurname1.trim().isEmpty()) {
                        idPerson.setLastName1(newSurname1);
                    }

                    System.out.print("Ingrese el nuevo apellido 2 (dejar en blanco para no modificar): ");
                    String newSurname2 = sc.nextLine();
                    if (!newSurname2.trim().isEmpty()) {
                        idPerson.setLastName2(newSurname2);
                    }

                    System.out.print("Ingrese el nuevo rol (dejar en blanco para no modificar): ");
                    String newRole = sc.nextLine();
                    if (!newRole.trim().isEmpty()) {
                        idPerson.setRole(newRole);
                    }

                    System.out.println("Datos actualizados exitosamente.");
                    // Sobrescribir el archivo despues de actualizar los datos
                    overwritePersonFile();
                    break;
                }
            }

            if (!found) {
                System.out.println("Persona con ID " + ID + " no encontrada.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al actualizar la persona: " + e.getMessage());
        }
    }

    // Metodo para guardar la informacion de la persona en un archivo .txt
    private void savePersonToFile(Person person) {
        try (FileWriter fileWriter = new FileWriter("personas.txt", true); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            fileWriter.write("Cedula: " + person.getID() + "\n");
            fileWriter.write("Nombre 1: : " + person.getName1() + "\n");
            fileWriter.write("Nombre 2: " + person.getName2() + "\n");
            fileWriter.write("Apellido 1: " + person.getLastName1() + "\n");
            fileWriter.write("Apellido 2: " + person.getLastName2() + "\n");
            fileWriter.write("Rol: " + person.getRole() + "\n");
            fileWriter.write("---------------------------------------\n");
            /*printWriter.println(
                person.getId() + "," +
                person.getName1() + "," +
                person.getName2() + "," +
                person.getLastName1() + "," +
                person.getLastName2() + "," +
                person.getRole()
            );*/
            System.out.println("Informacion guardada en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar en el archivo: " + e.getMessage());
        }
    }

    // Metodo para sobrescribir el archivo con la informacion actualizada de la matriz de personas
    private void overwritePersonFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.txt"))) {
            for (int i = 0; i < this.mPerson.length; i++) {
                Person person = this.mPerson[i][0];
                if (person != null) {
                    writer.write("Cedula: " + person.getID() + "\n");
                    writer.write("Nombre 1: " + person.getName1() + "\n");
                    writer.write("Nombre 2: " + person.getName2() + "\n");
                    writer.write("Apellido 1: " + person.getLastName1() + "\n");
                    writer.write("Apellido 2: " + person.getLastName2() + "\n");
                    writer.write("Rol: " + person.getRole() + "\n");
                    writer.write("---------------------------------------\n");
                }
            }
            System.out.println("Archivo actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrio un error al sobrescribir el archivo: " + e.getMessage());
        }
    }
}
