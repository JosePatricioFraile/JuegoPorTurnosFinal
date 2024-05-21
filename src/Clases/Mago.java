package Clases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Mago extends Personaje {
    protected int mana;

    public Mago(String nombre) {
        super(nombre, 20, 10, 10, 8, "Mago");
        this.mana = 10;
    }

    @Override
    public void ataqueSimple(Personaje enemigo) { //coste 5
        System.out.println("Ataque simple de " + nombre);
        enemigo.salud -= daño - (enemigo.getArmadura() / 2);
        resistencia -= 5;
        System.out.println("Vida del enemigo: " + enemigo.getSalud());
    }

    @Override
    public void ataqueFuerte(Personaje enemigo) { //coste 10
        System.out.println("Ataque fuerte de " + nombre);
        enemigo.salud -= (daño * 2) - (enemigo.getArmadura() / 2);
        resistencia -= 10;
    }

    @Override
    public void stats() {
        System.out.println("Las estadísticas de " + nombre + " son Salud: " + salud + ", daño: " + daño + ", resistencia: " + resistencia + ", armadura: " + armadura + ", mana: " + mana);
    }


    public void MovimientoEspecial(Personaje enemigo) { //coste 5 resistencia, 10 mana
        System.out.println("Ataque con magia de " + nombre);
        enemigo.salud -= (daño * (mana / 5)) - (enemigo.getArmadura() / 2);
        resistencia -= 5;
        mana -= 10;
    }

    @Override
    public void siguienteMovimiento(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que quieres hacer?");
        System.out.println("1. Ataque simple");
        System.out.println("2. Ataque fuerte");
        System.out.println("3. Ataque con magia");
        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                if (resistencia < 5) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Mago.this.getNombre() + " ha usado ataque simple");
                    Mago.this.ataqueSimple(enemigo);
                    System.out.println("Estas son las estadisticas despues del ataque: ");
                }
                break;
            case 2:
                if (resistencia < 10) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Mago.this.getNombre() + " ha usado ataque fuerte");
                    Mago.this.ataqueFuerte(enemigo);
                    System.out.println("Estas son las estadisticas despues del ataque: ");
                }
                break;
            case 3:
                if (resistencia < 5 || mana < 10) {
                    System.out.println("No puedes realizar el ataque");
                } else {
                    System.out.println(Mago.this.getNombre() + " ha usado ataque con magia");
                    Mago.this.MovimientoEspecial(enemigo);
                    System.out.println("Estas son las estadisticas despues del ataque: ");
                }
                break;
        }
    }

}
