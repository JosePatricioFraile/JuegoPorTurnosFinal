package Clases;

import java.util.Scanner;

public class Caballero extends Personaje {
    public Caballero(String nombre) {
        super(nombre, 30, 7, 20, 25, "Cabllero");
    }


    @Override
    public void ataqueSimple(Personaje enemigo) { //coste 5
        System.out.println("Ataque simple de " + nombre);
        enemigo.salud -= daño - (enemigo.getArmadura() / 2);
        resistencia -= 5;
    }

    @Override
    public void ataqueFuerte(Personaje enemigo) { //coste 10
        System.out.println("Ataque fuerte de " + nombre);
        enemigo.salud -= (daño * 2) - (enemigo.getArmadura() / 2);
        resistencia -= 10;
    }

    public void MovimientoEspecial() { //coste 5
        System.out.println("Defensa del caballero");
        armadura += 5;

    }

    @Override
    public void stats() {
        System.out.println("Las estadísticas de " + nombre + " son Salud: " + salud + ", daño: " + daño + ", resistencia: " + resistencia + ", armadura: " + armadura);
    }

    @Override
    public void siguienteMovimiento(Personaje enemigo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que quieres hacer?");
        System.out.println("1. Ataque simple");
        System.out.println("2. Ataque fuerte");
        System.out.println("3. Subir armadura");
        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                if (resistencia < 5) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Caballero.this.getNombre() + " ha usado ataque simple");
                    Caballero.this.ataqueSimple(enemigo);
                    System.out.println("Estas son las estadisticas despues del ataque: ");
                }
                break;
            case 2:
                if (resistencia < 10) {
                    System.out.println("No tienes suficiente energia");
                } else {
                    System.out.println(Caballero.this.getNombre() + " ha usado ataque fuerte");
                    Caballero.this.ataqueFuerte(enemigo);
                    System.out.println("Estas son las estadisticas despues del ataque: ");
                }
                break;
            case 3:
                System.out.println(Caballero.this.getNombre() + " ha usado ataque por la espalda");
                Caballero.this.MovimientoEspecial();
                System.out.println("Estas son las estadisticas despues del ataque: ");
                break;
        }
    }


}
