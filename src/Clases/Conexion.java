package Clases;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Menu.*;

public class Conexion {
    private static final String nombreBD = "pelea";
    private static final String usuario = "root";
    private static final String password = "0910";
    private static final String url = "jdbc:mysql://localhost:3306/" + nombreBD;
    private static Connection conn = null;
    protected static Ficheros fichero;

    static {
        try {
            fichero = new Ficheros();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Conexion() throws IOException {

    }

    public Connection getConexion() throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion exitosa a la BD: " + nombreBD);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Ocurre una ClassNotFoundException " + e.getMessage());
            fichero.pw.println("Ocurre una ClassNotFoundException " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocurre una SQLException " + e.getMessage());
            fichero.pw.println(LocalDateTime.now() + "Ocurre una SQLException " + e.getMessage());
        }
        fichero.pw.close();
        return conn;
    }

    public static void guardarPersonaje(Personaje personaje) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO JUGADORES(ID, jugador, tipo) VALUES (?, ?, ?)");
            stmt.setString(1, personaje.getId());
            stmt.setString(2, personaje.getNombre());
            stmt.setString(3, personaje.getTipo());
            stmt.executeUpdate();
        }catch (Exception e){
            System.out.println("Error al intentar insertar jugadores a la base de datos " +e.getMessage());
            fichero.pw.println(LocalDateTime.now() + "Error al intentar insertar jugadores a la base de datos " +e.getMessage());
            fichero.pw.close();
        }
    }

    public static void eliminarPersonaje(Personaje personaje) throws SQLException {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM JUGADORES WHERE jugador = ?");
            stmt.setString(1, personaje.getNombre());
            stmt.executeUpdate();
        } catch (Exception e){
            System.out.println("Error al intentar eliminar el jugador de la base de datos " + e.getMessage());
            fichero.pw.println(LocalDateTime.now() + "Error al intentar eliminar el jugador de la base de datos " + e.getMessage());
            fichero.pw.close();
        }
    }
}
