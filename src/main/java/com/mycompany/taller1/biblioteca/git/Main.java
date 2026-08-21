/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller1.biblioteca.git;

/**
 *
 * @author Jose Rodriguez
 */
public class Main {
    static ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] args) {
        static void menuLibros() {
        int opcion;
        do {
            System.out.println("\n--- GESTION DE LIBROS ---");
            System.out.println("1. Crear libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por codigo");
            System.out.println("4. Actualizar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = leerEntero();
 
            switch (opcion) {
                case 1: crearLibro(); break;
                case 2: listarLibros(); break;
                case 3: buscarLibroMenu(); break;
                case 4: actualizarLibro(); break;
                case 5: eliminarLibro(); break;
                case 0: break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }
        static void crearLibro() {
        System.out.print("Codigo del libro: ");
        String codigo = sc.nextLine();
        if (buscarLibro(codigo) != null) {
            System.out.println("Ya existe un libro con ese codigo.");
            return;
        }
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Anio de publicacion: ");
        String anio = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
 
        libros.add(new Libro(codigo, titulo, anio, autor));
        System.out.println("Libro creado exitosamente.");
    }
         static void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        System.out.println("\n-- Lista de Libros --");
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
         static Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equalsIgnoreCase(codigo)) return l;
        }
        return null;
    }
 
    static void buscarLibroMenu() {
        System.out.print("Codigo del libro a buscar: ");
        String codigo = sc.nextLine();
        Libro l = buscarLibro(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
        } else {
            System.out.println("Libro encontrado: " + l);
        }
    }
     static void actualizarLibro() {
        System.out.print("Codigo del libro a actualizar: ");
        String codigo = sc.nextLine();
        Libro l = buscarLibro(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        System.out.print("Nuevo titulo (" + l.getTitulo() + "): ");
        String titulo = sc.nextLine();
        if (!titulo.isBlank()) l.setTitulo(titulo);
 
        System.out.print("Nuevo autor (" + l.getAutor() + "): ");
        String autor = sc.nextLine();
        if (!autor.isBlank()) l.setAutor(autor);
 
        System.out.print("Nuevo anio (" + l.getAnioPublic() + "): ");
        String anio = sc.nextLine();
        if (!anio.isBlank()) l.setAnioPublic(anio);
 
        System.out.println("Libro actualizado.");
    }
     static void eliminarLibro() {
        System.out.print("Codigo del libro a eliminar: ");
        String codigo = sc.nextLine();
        Libro l = buscarLibro(codigo);
        if (l == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        libros.remove(l);
        System.out.println("Libro eliminado.");
    }
}
