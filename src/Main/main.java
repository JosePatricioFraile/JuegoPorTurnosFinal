package Main;

import Clases.*;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje p1;
        Personaje p2;

        //BaseDatos.loadDriver();
        //BaseDatos.connect();
        //ArrayList<Personaje> personajes = new ArrayList();
        //personajes.add(p1);
        //personajes.add(p2);
        //crearJugadores(personajes);

        System.out.println("Nombre del jugador 1");
        String nombre1 = sc.next();
        System.out.println("Que clase quieres caballero(1), mago(2) o asesino(3)?");
        int eleccionPersonaje = sc.nextInt();
        if (eleccionPersonaje == 1) {
            p1 = new Caballero(nombre1);
        } else if (eleccionPersonaje == 2) {
            p1 = new Mago(nombre1);
        } else {
            p1 = new Asesino(nombre1);
        }

        System.out.println("Nombre del jugador 2");
        String nombre2 = sc.next();
        System.out.println("Que clase quieres caballero(1), mago(2) o asesino(3)?");
        eleccionPersonaje = sc.nextInt();
        if (eleccionPersonaje == 1) {
            p2 = new Caballero(nombre2);
        } else if (eleccionPersonaje == 2) {
            p2 = new Mago(nombre2);
        } else {
            p2 = new Asesino(nombre2);
        }

        //BaseDatos.insertJugador(p1.getNombre(), p1.getTipo());
        //BaseDatos.insertJugador(p2.getNombre(), p2.getTipo());
        pelea(p1, p2);
    }

    public static void pelea(Personaje p1, Personaje p2) {
        System.out.println("Empieza la pelea entre " + p1.getNombre() + " y " + p2.getNombre());
        do {
            p1.siguienteMovimiento(p2);
            p2.checkGanador();
            p2.siguienteMovimiento(p1);
            p1.checkGanador();
            p1.stats();
            p2.stats();
        } while (p1.getConVida() && p2.getConVida());
        if (p1.getConVida()) {
            System.out.println("Ha ganado " + p1.getNombre());
        } else {
            System.out.println("Ha ganado " + p2.getNombre());
        }
    }

    /*public static void crearJugadores(ArrayList<Personaje> personajes) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        for (Personaje personaje : personajes) {
            System.out.println("Nombre del jugador " + i);
            String nombre = sc.next();
            System.out.println("Que clase quieres caballero(1), mago(2), asesino(3)");
            int eleccionPersonaje = sc.nextInt();
            asignarRol(personaje, eleccionPersonaje, nombre);
            i++;
        }
    }

    public static void asignarRol(Personaje p, int eleccionPersonaje, String nombre) {
        switch (eleccionPersonaje) {
            case 1:
                p = new Caballero(nombre);
                break;
            case 2:
                p = new Mago(nombre);
                break;
            case 3:
                p = new Asesino(nombre);
                break;
        }
    }*/
}

