package com.juliocordon_0904_25_15166.servicio;

import com.juliocordon_0904_25_15166.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
 
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (libro != null) {
            libros.add(libro);
        }
    }

    public List<Libro> obtenerLibros() {
        return new ArrayList<>(libros);
    }

    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}