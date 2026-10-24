/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reproductormusica;

/**
 *
 * @author moshi
 */
public class Cancion extends Multimedia {
    private String artista;

    public Cancion(String titulo, int duracion, String artista) {
        super(titulo, duracion);
        this.artista = artista;
    }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo: " + getTitulo() + " - " + artista
                + " (" + getDuracion() + "s)");
    }
}