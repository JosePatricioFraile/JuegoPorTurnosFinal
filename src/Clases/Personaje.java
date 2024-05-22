package Clases;

import java.util.Scanner;

public abstract class Personaje {
    protected String nombre, tipo;
    protected int salud, daño, resistencia, armadura;
    private boolean conVida = true;

    public Personaje(String nombre, int salud, int daño, int resistencia, int armadura, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.daño = daño;
        this.resistencia = resistencia;
        this.armadura = armadura;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getConVida() {
        return conVida;
    }

    public void morir() {
        this.conVida = false;
    }

    public abstract void ataqueSimple(Personaje enemigo);

    public abstract void ataqueFuerte(Personaje enemigo);

    public abstract void stats();

    public abstract void siguienteMovimiento(Personaje enemigo);

    public boolean checkGanador() {
        if (Personaje.this.salud <= 0) {
            morir();
        }
        return conVida;
    }

    public void pasarTurno(){
        resistencia += 5;
    }

}
