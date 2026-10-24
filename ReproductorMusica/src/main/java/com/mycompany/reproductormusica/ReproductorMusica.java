/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reproductormusica;

/**
 *
 * @author moshi
 */
public class ReproductorMusica {

    public static void main(String[] args) {
        Cancion c1 = new Cancion("Canción 1", 180, "Artista A");
        Cancion c2 = new Cancion("Canción 2", 200, "Artista B");
        Cancion c3 = new Cancion("Canción 3", 220, "Artista C");

        Playlist playlist = new Playlist();
        playlist.agregarCancion(c1);
        playlist.agregarCancion(c2);
        playlist.agregarCancion(c3);

        playlist.mostrarPlaylist();   // lista inicial con 3 canciones
        playlist.siguiente();         // reproduce la 2
        playlist.siguiente();         // reproduce la 3
        playlist.anterior();          // reproduce la 2
        playlist.eliminarActual();    // elimina la 2
        playlist.mostrarPlaylist();   // quedan la 1 y la 3
    }
}