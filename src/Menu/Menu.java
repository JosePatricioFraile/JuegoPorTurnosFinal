package Menu;

import Clases.*;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static ArrayList<Personaje> Personajes;
    private boolean continuar = true;
    protected static Ficheros fichero;

    static {
        try {
            fichero = new Ficheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Menu() throws IOException {
        this.Personajes = new ArrayList<>();
        Conexion conexion = new Conexion();
        conexion.getConexion();
    }

    public boolean getContinuar() {
        return this.continuar;
    }

    public void mostrarMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que quieres hacer?");
        System.out.println("1. Crear un personaje");
        System.out.println("2. Mostrar personajes");
        System.out.println("3. Eliminar un personaje");
        System.out.println("4. Iniciar una pelea");
        System.out.println("5. Salir");

        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                crearPersonaje();
                break;
            case 2:
                mostrarPersonajes();
                break;
            case 3:
                eliminarPersonaje();
                break;
            case 4:
                pelea();
                break;
            case 5:
                salir();
        }
    }

    public void crearPersonaje() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Como se llamará:");
        String nombre = sc.next();
        try {
            System.out.println("Que clase quieres que sea? Caballero(1), Mago(2), Asesino(3)");
            int eleccionClase = sc.nextInt();
            switch (eleccionClase) {
                case 1:
                    Personaje personaje = new Caballero(nombre);
                    Personajes.add(personaje);
                    insertarEnBD(personaje);
                    break;
                case 2:
                    Personaje personaje1 = new Mago(nombre);
                    Personajes.add(personaje1);
                    insertarEnBD(personaje1);
                    break;
                case 3:
                    Personaje personaje2 = new Asesino(nombre);
                    Personajes.add(personaje2);
                    insertarEnBD(personaje2);
                    break;
                default:
                    System.out.println("Error al elegir clase, no se ha creado el personaje");
            }
        } catch (Exception e) {
            System.out.println("Error al elegir la clase del personaje " + e.getMessage());
            fichero.pw.println(LocalDateTime.now() + "Error al elegir la clase del personaje " + e.getMessage());
            fichero.pw.close();
        }
    }

    public void mostrarPersonajes() {
        if (Personajes.size() <= 0) {
            System.out.println("Aun no hay personajes");
        } else {
            for (Personaje personaje : Personajes) {
                personaje.stats();
            }
        }
    }

    public void eliminarPersonaje() {
        Scanner sc = new Scanner(System.in);
        if (Personajes.size() <= 0){
            System.out.println("No hay ningún personaje para eliminar");
        } else {
            System.out.println("Cual quieres eliminar?");
            for (Personaje personaje : Personajes) {
                System.out.println(personaje.getNombre());
            }
            String personajeEliminar = sc.next();
            for (Personaje personaje : Personajes) {
                if (personaje.getNombre().equals(personajeEliminar)) {
                    Personajes.remove(personaje);
                    eliminarEnBD(personaje);
                    System.out.println("Se ha eliminado correctamente");
                    break;
                }
            }
        }

    }

    public void pelea() {
        try {
            Scanner sc = new Scanner(System.in);
            Personaje p1 = null;
            Personaje p2 = null;
            if (Personajes.size() < 2) {
                System.out.println("No pudes hacer una pelea con menos de 2 personajes");
            } else {
                System.out.println("Que personajes quieres elegir para la pelea?");
                for (Personaje personaje : Personajes) {
                    personaje.stats();
                }
                System.out.println("Cual quieres que sea el primero?");
                String j1 = sc.next();
                for (Personaje personaje : Personajes) {
                    if (personaje.getNombre().equals(j1)) {
                        p1 = personaje;
                        break;
                    }
                }
                System.out.println("Cual quieres que sea el segundo?");
                String j2 = sc.next();
                for (Personaje personaje : Personajes) {
                    if (personaje.getNombre().equals(j2)) {
                        p2 = personaje;
                        break;
                    }
                }
            }
            inicioPelea(p1, p2);

        }catch (Exception e){
            System.out.println("Error al intentar crear la pelea " + e.getMessage());
            System.out.println("No hay jugadores suficientes");
            fichero.pw.println(LocalDateTime.now() + "Error al intentar crear la pelea " + e.getMessage());
            fichero.pw.close();
        }
    }

    public void inicioPelea(Personaje p1, Personaje p2) {
        System.out.println("Empieza la pelea entre " + p1.getNombre() + " y " + p2.getNombre());
        do {
            System.out.println("Esperando el movimiento de " + p1.getNombre());
            p1.siguienteMovimiento(p2);
            p2.checkGanador();
            System.out.println("Esperando el movimiento de " + p2.getNombre());
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

    public void salir() {
        this.continuar = false;
    }

    public static void insertarEnBD(Personaje p1) {
        try {
            Conexion.guardarPersonaje(p1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void eliminarEnBD(Personaje p1) {
        try {
            Conexion.eliminarPersonaje(p1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}