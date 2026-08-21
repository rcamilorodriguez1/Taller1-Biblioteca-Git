/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller1.biblioteca.git;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Jose Rodriguez
 */
public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
         static void menuClientes() {
        int opcion;
        do {
            System.out.println("\n--- GESTION DE CLIENTES ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por id");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = leerEntero();
 
            switch (opcion) {
                case 1: crearCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarClienteMenu(); break;
                case 4: actualizarCliente(); break;
                case 5: eliminarCliente(); break;
                case 0: break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }
 
    // Paso 5.3.2 - CREATE
    static void crearCliente() {
        System.out.print("ID del cliente: ");
        String id = sc.nextLine();
        if (buscarCliente(id) != null) {
            System.out.println("Ya existe un cliente con ese ID.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
 
        clientes.add(new Cliente(id, nombre, telefono, email));
        System.out.println("Cliente creado exitosamente.");
    }
    static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\n-- Lista de Clientes --");
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }
    static void buscarClienteMenu() {
        System.out.print("ID del cliente a buscar: ");
        String id = sc.nextLine();
        Cliente c = buscarCliente(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
        } else {
            System.out.println("Cliente encontrado: " + c);
        }
    }
    static void actualizarCliente() {
        System.out.print("ID del cliente a actualizar: ");
        String id = sc.nextLine();
        Cliente c = buscarCliente(id);
        if (c == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        System.out.print("Nuevo nombre (" + c.getNombre() + "): ");
        String nombre = sc.nextLine();
        if (!nombre.isBlank()) c.setNombre(nombre);
 
        System.out.print("Nuevo telefono (" + c.getTelefono() + "): ");
        String telefono = sc.nextLine();
        if (!telefono.isBlank()) c.setTelefono(telefono);
 
        System.out.print("Nuevo email (" + c.getEmail() + "): ");
        String email = sc.nextLine();
        if (!email.isBlank()) c.setEmail(email);
 
        System.out.println("Cliente actualizado.");
    }
}
