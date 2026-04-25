package com.juliocordon_0904_25_15166;

public class Libro {
    private String titulo;
    private String autor;
    private int yearPublicacion;

    public Libro(String titulo, String autor, int yearPublicacion) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser null ni vacío");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser null ni vacío");
        }
        if (yearPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicación debe ser mayor que 0");
        }

        this.titulo = titulo;
        this.autor = autor;
        this.yearPublicacion = yearPublicacion;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getYearPublicacion() { return yearPublicacion; }

    public boolean esAntiguo() {
        return this.yearPublicacion < 2000;
    }

    @Override
    public String toString() {
        return String.format("'%s' por %s (%d)", titulo, autor, yearPublicacion);
    }
}