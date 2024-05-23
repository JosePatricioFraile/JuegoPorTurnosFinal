package Clases;

import java.sql.*;

import Menu.*;

public class Conexion {
    private static final String nombreBD = "pelea";
    private static final String usuario = "root";
    private static final String password = "0910";
    private static final String url = "jdbc:mysql://localhost:3306/" + nombreBD;
    private static Connection conn = null;

    public Conexion() {

    }

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion exitosa a la BD: " + nombreBD);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Ocurre una ClassNotFoundException " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocurre una SQLException " + e.getMessage());
        }
        return conn;
    }

    public static void guardarPersonaje(Personaje personaje) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO JUGADORES(ID, jugador, tipo) VALUES (?, ?, ?)");

        stmt.setString(1, personaje.getId());
        stmt.setString(2, personaje.getNombre());
        stmt.setString(3, personaje.getTipo());
        stmt.executeUpdate();
    }

    public static void eliminarPersonaje(Personaje personaje) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM JUGADORES WHERE jugador = ?");
        stmt.setString(1, personaje.getNombre());
        stmt.executeUpdate();

    }
}
