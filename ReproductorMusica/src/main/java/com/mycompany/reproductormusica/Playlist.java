/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reproductormusica;

/**
 *
 * @author moshi
 */
public class Playlist {
    private NodoDoble cabeza;
    private NodoDoble cola;
    private NodoDoble actual;
    private int tamanio;

    public Playlist() {
        cabeza = null;
        cola = null;
        actual = null;
        tamanio = 0;
    }

    public void agregarCancion(Cancion c) {
        NodoDoble nuevo = new NodoDoble(c);

        if (cabeza == null) {              // caso 1: lista vacía
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo;
        } else {                           // caso 2: ya hay canciones
            cola.setSiguiente(nuevo);      // el último actual apunta al nuevo
            nuevo.setAnterior(cola);       // el nuevo apunta hacia atrás al último
            cola = nuevo;                  // el nuevo pasa a ser la cola
        }
        tamanio++;
    }

    public void mostrarPlaylist() {
        System.out.println("--- Playlist (" + tamanio + " canciones) ---");
        NodoDoble aux = cabeza;            // empieza en la cabeza
        int i = 1;
        while (aux != null) {              // avanza hasta salir de la lista
            Cancion c = aux.getDato();
            System.out.println(i + ". " + c.getTitulo() + " - " + c.getArtista());
            aux = aux.getSiguiente();
            i++;
        }
    }

    public int getTamanio() {
        return tamanio;
    }
}