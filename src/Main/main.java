package Main;

import Clases.*;
import Menu.*;

import java.io.IOException;
import java.sql.*;

public class main {

    public static void main(String[] args) throws SQLException, IOException {
        Menu menu = new Menu();

        do {
            menu.mostrarMenu();
        } while (menu.getContinuar());

    }
}