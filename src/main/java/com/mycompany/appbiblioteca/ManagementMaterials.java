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
public class ManagementMaterials {

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
        System.out.print("Ingrese la cantidad: ");
        int registeredAmount = sc.nextInt();
        System.out.print("Ingrese cantidad actual: ");
        int currentQuantity = sc.nextInt();

        material = new Material(identifier, typeMaterial, title, registrationDate, registeredAmount, currentQuantity);

        for (int i = 0; i < this.mMaterial.length; i++) {
            Material idMaterial = this.mMaterial[i][0];
            if (idMaterial == null) {
                this.mMaterial[i][0] = material;
                break;
            }
        }
        return this.mMaterial;
    }

    //Metod para Registrar un prestado consultando en la matriz con el identifier del material
    public void registerLoan() {
        // Usar Scanner para pedir el identifier dentro del metodo
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el identificador del material para registrar el prestamo:");
        String identifier = sc.nextLine(); // Lee el identifier del usuario

        // Logica del prestamo
        for (int i = 0; i < this.mMaterial.length; i++) {
            Material material = this.mMaterial[i][0];
            if (material != null && material.getIdentifier().equals(identifier)) {
                if (material.getCurrentQuantity() > 0) {
                    material.setCurrentQuantity(material.getCurrentQuantity() - 1);
                    System.out.println("Prestamo registrado exitosamente. Se actualiza la cantidad disponible.");
                    // Aqui podrias agregar logica para registrar en un historial de prestamos
                } else {
                    System.out.println("No hay suficientes unidades disponibles para el prestamo.");
                }
                break;
            }
        }
    }

    //Metodo para registrar una devolucion consultando con el identifier del material y sumando la devolucion
    public void registerReturn() {
        // Usar Scanner para pedir el identifier dentro del metodo
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el identificador del material para registrar la devolucion:");
        String identifier = sc.nextLine(); // Lee el identificador del material

        // Aqui se realiza la logica para hacer la devolucion
        for (int i = 0; i < this.mMaterial.length; i++) {
            Material material = this.mMaterial[i][0];
            if (material != null && material.getIdentifier().equals(identifier)) {
                material.setCurrentQuantity(material.getCurrentQuantity() + 1);
                System.out.println("Devolucion registrada exitosamente. Cantidad disponible actualizada.");

                break;
            }
        }
    }

    public void registerRenewal() {
        // Usar Scanner para pedir el identificador dentro del metodo
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el identificador del material para registrar la renovacion:");
        String identifier = sc.nextLine(); // Lee el identifier del usuario

        // Logica de la renovacion
        for (int i = 0; i < this.mMaterial.length; i++) {
            Material material = this.mMaterial[i][0];
            if (material != null && material.getIdentifier().equals(identifier)) {
                // Si existe un prestamo, se podra actualizar una fecha de devolucion
                System.out.println("Renovacion registrada exitosamente.");
                break;
            }
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

}
