package Main;

import Clases.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje p1;
        Personaje p2;
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
}
