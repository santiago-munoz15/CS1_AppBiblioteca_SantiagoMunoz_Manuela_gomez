/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.appbiblioteca;

import java.util.Scanner;

/**
 *
 * @author santiago.munoz
 */
public class AppLibrary {

    static Material material;
    static int option;
    static Scanner sc = new Scanner(System.in);
    static Material[][] mMaterial = new Material[6][20];
    static Person[][] mPerson = new Person[6][20];
    

    public static void main(String[] args) {

        do {
            System.out.println("=============================================");
            System.out.println("|BIENVENIDO A LA BIBLIOTECA ALIANZA LITERARIA|");
            System.out.println("=============================================");
            System.out.println("|1. Registrar un material en el catalogo.    |");
            System.out.println("|2. Registrar una persona.                   |");
            System.out.println("|3. Eliminar una persona.                    |");
            System.out.println("|4. Actualizar una persona                   |");
            System.out.println("|5. Registrar un prestamo.                   |");
            System.out.println("|6. Registrar una devolucion.                |");
            System.out.println("|7. Registrar una renovacion.                |");
            System.out.println("|8. Consultar el historial de la biblioteca. |");
            System.out.println("|9. Consultar historial de Personas.         |");
            System.out.println("|10. Salir.                                  |");
            System.out.println("|============================================|");
            System.out.print("Ingresa la opcion: ");
            option = sc.nextInt();
            ManagementMaterials gMateriales = new ManagementMaterials(mMaterial);
            ManagementPerson gPersona = new ManagementPerson(mPerson);
            switch (option) {
                case 1:
                    mMaterial = gMateriales.addBook();
                    break;
                case 2:
                    mPerson = gPersona.addPerson();
                    break;
                case 3:
                    gPersona.deletePerson();// Llama al método directamente eliminar persona
                    break;
                case 4:
                    gPersona.updatePerson();// Llama al método directamente actualizar persona
                    break;
                case 5:
                    gMateriales.registerLoan(); // Llama al método directamente registrar un prestamo
                    break;
                case 6:
                    gMateriales.registerReturn(); // Llama al método directamente registrar devolucion
                    break;
                case 7:
                    gMateriales.registerRenewal(); // Llama al método directamente registrar renovacion
                    break;
                case 8:
                    gMateriales.consultBooks();// Llama al metodo para consultar el historial de libros
                    break;
                case 9:
                    gPersona.personQuery();// Llama al metodo para consultar las personas ingresadas
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
            }

        } while (option != 10);

    }
}
