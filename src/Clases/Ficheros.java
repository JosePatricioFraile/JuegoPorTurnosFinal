package Clases;
import java.io.*;
public class Ficheros {
    public FileWriter fichero = new FileWriter("D:/logErrores.txt", true);
    public PrintWriter pw = new PrintWriter(fichero);

    public Ficheros() throws IOException {

    }
}