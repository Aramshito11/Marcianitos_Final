package com.adenterprise.sapceinvaders.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class usuaris {
    File usuaris=new File("usuaris.txt");

    public static void main(String[] args) {
        try {
            FileWriter escriure = new FileWriter("usuaris.txt");
            escriure.write("Este es un ejemplo de texto que se escribirá en el archivo.");
            escriure.close();
            System.out.println("Se ha escrito correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }



}
