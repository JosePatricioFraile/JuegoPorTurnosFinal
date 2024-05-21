package Clases;

import java.util.Scanner;

public class Asesino extends Personaje {

    public Asesino(String nombre) {
        super(nombre, 15, 12, 15, 10, "Asesino");
    }

    @Override
    public void ataqueSimple(Personaje enemigo) {
        System.out.println("Ataque simple de " + nombre);
        enemigo.salud -= daño - (enemigo.getArmadura() / 2);
        resistencia -= 5;
    }

    @Override
    public void ataqueFuerte(Personaje enemigo) {
        System.out.println("Ataque fuerte de " + nombre);
        enemigo.salud -= (daño * 2) - (enemigo.getArmadura() / 2);
        resistencia -= 10;
    }

    @Override
    public void stats() {
        System.out.println("Las estadísticas de " + nombre + " son Salud: " + salud + ", daño: " + daño + ", resistencia: " + resistencia + ", armadura: " + armadura);
    }


    public void MovimientoEspecial(Personaje enemigo) {
        System.out.println("Ataque por la espalda de " + nombre);
        enemigo.salud -= (daño * 2) - (enemigo.getArmadura() / 3);
        resistencia -= 15;
    }

    @Override
    public void siguienteMovimiento(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que quieres hacer?");
        System.out.println("1. Ataque simple");
        System.out.println("2. Ataque fuerte");
        System.out.println("3. Ataque por la espalda");
        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                if (resistencia < 5) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Asesino.this.getNombre() + " ha usado ataque simple");
                    Asesino.this.ataqueSimple(enemigo);
                }
                pasarTurno();
                break;
            case 2:
                if (resistencia < 10) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Asesino.this.getNombre() + " ha usado ataque fuerte");
                    Asesino.this.ataqueFuerte(enemigo);
                }
                pasarTurno();
                break;
            case 3:
                if (resistencia < 15) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Asesino.this.getNombre() + " ha usado ataque por la espalda");
                    Asesino.this.MovimientoEspecial(enemigo);
                }
                pasarTurno();
                break;
        }
    }
}
