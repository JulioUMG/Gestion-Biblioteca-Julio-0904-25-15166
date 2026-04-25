package com.juliocordon_0904_25_15166;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE GESTION DE BIBLIOTECA ---");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Ver todos los libros");
            System.out.println("3. Buscar libro por titulo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        agregarLibroMenu(miBiblioteca, sc);
                        break;
                    case 2:
                        imprimirLibrosMenu(miBiblioteca);
                        break;
                    case 3:
                        buscarLibroMenu(miBiblioteca, sc);
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        } while (opcion != 4);

        sc.close();
    }


    private static void agregarLibroMenu(Biblioteca biblioteca, Scanner sc) {
        try {
            System.out.print("Ingrese titulo: ");
            String titulo = sc.nextLine();
            System.out.print("Ingrese autor: ");
            String autor = sc.nextLine();
            System.out.print("Ingrese anio: ");//lo puse asi para que no se vea feo xdd
            int year = Integer.parseInt(sc.nextLine());

            Libro nuevo = new Libro(titulo, autor, year);
            biblioteca.agregarLibro(nuevo);
            System.out.println("Libro agregado!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void imprimirLibrosMenu(Biblioteca biblioteca) {
        List<Libro> lista = biblioteca.obtenerLibros();
        if (lista.isEmpty()) {
            System.out.println("No hay libros.");
        } else {
            for (Libro l : lista) {
                System.out.println((l.esAntiguo() ? "[Antiguo] " : "[Nuevo] ") + l.getTitulo());
            }
        }
    }

    private static void buscarLibroMenu(Biblioteca biblioteca, Scanner sc) {
        System.out.print("Titulo a buscar: ");
        String busqueda = sc.nextLine();
        Libro encontrado = biblioteca.buscarPorTitulo(busqueda);
        
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getTitulo() + " de " + encontrado.getAutor());
        } else {
            System.out.println("No se encontro el libro.");
        }
    }
}