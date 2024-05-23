package Main;

import Clases.*;
import Menu.*;
import java.sql.*;

public class main {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();

        do {
            menu.mostrarMenu();
        } while (menu.getContinuar());

    }
}

