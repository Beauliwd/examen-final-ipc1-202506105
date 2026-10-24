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
        public Cancion siguiente() {
        // si no hay canción actual o ya estamos en la cola, no hay siguiente
        if (actual == null || actual.getSiguiente() == null) {
            return null;
        }
        actual = actual.getSiguiente();     // avanza el puntero
        actual.getDato().reproducir();      // reproduce la nueva canción actual
        return actual.getDato();
    }

    public Cancion anterior() {
        // si no hay canción actual o ya estamos en la cabeza, no hay anterior
        if (actual == null || actual.getAnterior() == null) {
            return null;
        }
        actual = actual.getAnterior();      // retrocede el puntero
        actual.getDato().reproducir();
        return actual.getDato();
    }

    public void eliminarActual() {
        if (actual == null) {               // lista vacía, nada que eliminar
            return;
        }

        NodoDoble prev = actual.getAnterior();
        NodoDoble next = actual.getSiguiente();

        if (prev != null) {
            prev.setSiguiente(next);        // el vecino de atrás salta al de adelante
        } else {
            cabeza = next;                  // era la cabeza
        }

        if (next != null) {
            next.setAnterior(prev);         // el vecino de adelante apunta al de atrás
        } else {
            cola = prev;                    // era la cola
        }

        actual.setAnterior(null);           // cortamos el nodo eliminado
        actual.setSiguiente(null);

        // actual pasa al siguiente; si no hay, retrocede; si no hay ninguno, queda null
        actual = (next != null) ? next : prev;
        tamanio--;
    }
}