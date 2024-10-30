/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appbiblioteca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author santiago.munoz
 */
public class ManagementMaterials implements Loanable {

    private Material[][] mMaterial;
    Scanner sc = new Scanner(System.in);
    private Material material;

    public ManagementMaterials(Material[][] mMaterial) {
        this.mMaterial = mMaterial;
    }

    //Metodo para Ingresar un libro a la matriz
    public Material[][] addBook() {

        System.out.print("Ingrese el identificador del libro: ");
        String identifier = sc.nextLine();
        System.out.print("Tipo de Material(Libro/Revista/AudioVsiual): ");
        String typeMaterial = sc.nextLine();
        System.out.print("Ingrese el titulo del Material: ");
        String title = sc.nextLine();
        System.out.print("Ingrese la fecha de registro dd/MM/aaa: ");
        String registrationDate = sc.nextLine();

        int registeredAmount = 0;
        int currentQuantity = 0;

        try {
            System.out.print("Ingrese la cantidad: ");
            registeredAmount = sc.nextInt();
            System.out.print("Ingrese cantidad actual: ");
            currentQuantity = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
        } catch (Exception e) {
            System.out.println("Entrada invalida. Por favor, ingrese un numero valido para la cantidad.");
            sc.nextLine(); // Limpiar el buffer
            return this.mMaterial; // Salir del metodo si hay un error de entrada
        }

        material = new Material(identifier, typeMaterial, title, registrationDate, registeredAmount, currentQuantity);

        for (int i = 0; i < this.mMaterial.length; i++) {
            Material idMaterial = this.mMaterial[i][0];
            if (idMaterial == null) {
                this.mMaterial[i][0] = material;
                saveMaterialToFile(material); // Llamar al metodo para guardar en archivo
                System.out.println("\nMaterial añadido y guardado exitosamente.");
                break;
            }
        }
        return this.mMaterial;
    }

    //Metod para Registrar un prestado consultando en la matriz con el identifier del material
    @Override
    public void registerLoan(String identifier) {

        try {
            boolean found = false;
            for (int i = 0; i < this.mMaterial.length; i++) {
                Material material = this.mMaterial[i][0];
                if (material != null && material.getIdentifier().equals(identifier)) {
                    if (material.getCurrentQuantity() > 0) {
                        material.setCurrentQuantity(material.getCurrentQuantity() - 1);
                        System.out.println("Prestamo registrado exitosamente.");
                        found = true;
                        overwriteMaterialFile(); // Actualizar archivo
                    } else {
                        System.out.println("No hay suficientes unidades disponibles.");
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Material no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al registrar el prestamo: " + e.getMessage());
        }
    }

    //Metodo para registrar una devolucion consultando con el identifier del material y sumando la devolucion
    public void registerReturn() {
        // Usar Scanner para pedir el identifier dentro del metodo
        try {
            System.out.print("Ingrese el identificador del material para registrar la devolucion: ");
            String identifier = sc.nextLine();

            boolean found = false;
            for (int i = 0; i < this.mMaterial.length; i++) {
                Material material = this.mMaterial[i][0];
                if (material != null && material.getIdentifier().equals(identifier)) {
                    material.setCurrentQuantity(material.getCurrentQuantity() + 1);
                    System.out.println("\nDevolucion registrada exitosamente. Cantidad disponible actualizada.");
                    found = true;
                    overwriteMaterialFile(); // Actualizar archivo
                    break;
                }
            }

            if (!found) {
                System.out.println("Material no encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar la devolucion: " + e.getMessage());
        }
    }

    public void registerRenewal() {
        // Usar Scanner para pedir el identificador dentro del metodo
        try {
            System.out.println("Ingrese el identificador del material para registrar la renovacion:");
            String identifier = sc.nextLine();

            boolean found = false;
            for (int i = 0; i < this.mMaterial.length; i++) {
                Material material = this.mMaterial[i][0];
                if (material != null && material.getIdentifier().equals(identifier)) {
                    System.out.println("Renovacion registrada exitosamente.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Material no encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar la renovacion: " + e.getMessage());
        }
    }

    //Metodo para consultar el historial de los materiales ingresados y su cantidad actual
    public void consultBooks() {
        for (int i = 0; i < this.mMaterial.length; i++) {
            Material idMaterial = this.mMaterial[i][0];

            if (idMaterial != null) {
                System.out.println("ID: " + idMaterial.getIdentifier() + " Tipo de Material: " + idMaterial.getTypeMaterial() + " Titulo: " + idMaterial.getTitle() + " Cantidad actual: " + idMaterial.getCurrentQuantity());

            }
        }

    }

    // Metodo para guardar el material en un archivo de texto
    private void saveMaterialToFile(Material material) {
        try (FileWriter writer = new FileWriter("materiales.txt", true)) {
            writer.write("Identificador: " + material.getIdentifier() + "\n");
            writer.write("Tipo de Material: " + material.getTypeMaterial() + "\n");
            writer.write("Titulo: " + material.getTitle() + "\n");
            writer.write("Fecha de Registro: " + material.getRegistrationDate() + "\n");
            writer.write("Cantidad Registrada: " + material.getRegisteredAmount() + "\n");
            writer.write("Cantidad Actual: " + material.getCurrentQuantity() + "\n");
            writer.write("---------------------------------------\n");
        } catch (IOException e) {
            System.out.println("Ocurrio un error al guardar el material: " + e.getMessage());
        }
    }

    // Metodo para sobrescribir el archivo con la informacion actualizada de la matriz
    private void overwriteMaterialFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("materiales.txt"))) {
            for (int i = 0; i < this.mMaterial.length; i++) {
                Material material = this.mMaterial[i][0];
                if (material != null) {
                    writer.write("Identificador: " + material.getIdentifier() + "\n");
                    writer.write("Tipo de Material: " + material.getTypeMaterial() + "\n");
                    writer.write("Titulo: " + material.getTitle() + "\n");
                    writer.write("Fecha de Registro: " + material.getRegistrationDate() + "\n");
                    writer.write("Cantidad Registrada: " + material.getRegisteredAmount() + "\n");
                    writer.write("Cantidad Actual: " + material.getCurrentQuantity() + "\n");
                    writer.write("---------------------------------------\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al sobrescribir el archivo: " + e.getMessage());
        }
    }

}
