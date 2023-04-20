package com.adenterprise.sapceinvaders.objects;
import com.adenterprise.sapceinvaders.file.usuaris;

/**
 * objecte persona on cada usuari tindra el nom, edat i el regisstre de partides.
 * @author dani
 */

import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Persona {
    private String nom;
    private int edat;
    private int numPartides;

    static Scanner sc = new Scanner(System.in);
    public Persona() {
        System.out.print("Introdueix el nom d'usuari: ");
        String nom= sc.next();
        this.nom = nom;
        this.edat = preguntarEdat();;
        this.numPartides = 0;
        escriureUserFitxer();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getNumPartides() {
        return numPartides;
    }

    public void setNumPartides(int numPartides) {
        this.numPartides = numPartides;
    }
    private void escriureUserFitxer() {
        escriureUser();
    }
    public void showData(){
        System.out.println("\n\nPERSONA");
        System.out.println("Nom: "+getNom());
        System.out.println("Edat: "+getEdat());
        System.out.println("Numero partides: "+getNumPartides());
    }

    public int sumarPartida(){
        numPartides++;
        return numPartides;
    }

    public int preguntarEdat(){
        Scanner sc = new Scanner(System.in);
        boolean seguirIntentando = true;
        int edat=0;
        boolean esEntero = false;

        do {
            System.out.print("Quina edat tens? ");
            String entrada = sc.nextLine();
        /**
         * Si no introdueixes un numero salta l'error, i et torna a demanar, perquè el programa no peti.
         */
            try {
                edat = Integer.parseInt(entrada);
                esEntero = true;
            } catch (NumberFormatException e) {
                System.out.println("Nomes es pot inserir numeros!");
            }
        } while (!esEntero);
        return edat;
    }



    /**
     * mètode per esciure el nom, l'edat i les partides a un fitxer .txt
     */
    public void escriureUser () {
        File usuaris = new File("usuaris.txt");
        File archivo = new File("C:\\Users\\Dani Gelabert\\Documents\\DAM\\M03 - Programació\\UF4\\projecteFinal\\usuaris.txt");
        String oldPhrase = "El nom de l'usuari es: " + nom;
        try {
            usuaris.createNewFile();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(archivo);
            boolean trobar = false;
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.contains(oldPhrase)) {
                    List<String> frasesSeguents = new ArrayList<>();
                    frasesSeguents.add(scanner.nextLine());
                    frasesSeguents.add(scanner.nextLine());
                    System.out.println("\n\nLECTURA FITXER PARTIDES");
                    System.out.println(oldPhrase);
                    for (String seguent : frasesSeguents) {
                        System.out.println(seguent);
                    }
                    trobar = true;
                }
            }
            scanner.close();
            if (trobar == false) {
                try {
                    FileWriter escriure = new FileWriter("usuaris.txt", true);
                    escriure.write("\nEl nom de l'usuari es: " + nom + "\n");
                    escriure.write("L'edat de l'usuari es: " + edat + "\n");
                    escriure.write("Partida de l'usuari es: " + numPartides + "\n");
                    escriure.close();
                    System.out.println("Fitxer escrit");
                } catch (IOException e) {
                    System.out.println("No s'ha pogut escriure en el fitxer");
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
                System.out.println("El archivo no existe.");
        }

    }


    /**
     * @uses mètode per sobreesciure el numero de partides d'un usuari.
     */
    public void sobrescriurePartides () {
        String fileName = "usuaris.txt";
        String oldPhrase = "El nom de l'usuari es: " + nom;
        String newPhrase = "\nEl nom de l'usuari es: " + nom + "\n" +
                "L'edat de l'usuari es: " + edat + "\n" +
                "Partida de l'usuari es: " + getNumPartides();
        boolean found = false;
        boolean deleteNextTwoLines = false;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            String content = "";

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(oldPhrase)) {
                    line = line.replaceAll(oldPhrase, newPhrase);
                    found = true;
                    deleteNextTwoLines = true;
                } else if (deleteNextTwoLines) {
                    deleteNextTwoLines = false;
                    bufferedReader.readLine(); // eliminar la siguiente línea
                    bufferedReader.readLine(); // eliminar la siguiente línea
                    continue; // saltar a la siguiente iteración del ciclo while
                }
                content += line + "\n";
            }

            if (found) {
                try (FileWriter fileWriter = new FileWriter(fileName);
                     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(content);
                }
            } else {
                System.out.println("No s'ha trobat la informacio al fitxer");
            }
        } catch (IOException e) {
            System.out.println("Error al llegir o escriure al fitxer");
            e.printStackTrace();
        }
    }

    public void ferPartida(){
        for (int i=0; i<5; i++){
            sumarPartida();
        }
        sobrescriurePartides();
    }

    /**
     * @uses busca el nom de l'usuari i treu tota la informació del fitxer
     */
    public void llegirNumPartides () {
        File archivo = new File("C:\\Users\\Dani Gelabert\\Documents\\DAM\\M03 - Programació\\UF4\\projecteFinal\\usuaris.txt");
        String oldPhrase = "El nom de l'usuari es: " + nom;

        try {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.contains(oldPhrase)) {
                    List<String> frasesSeguents = new ArrayList<>();
                    frasesSeguents.add(scanner.nextLine());
                    frasesSeguents.add(scanner.nextLine());
                    System.out.println("\n\nLECTURA FITXER PARTIDES");
                    System.out.println(oldPhrase);
                    for (String seguent : frasesSeguents) {
                        System.out.println(seguent);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }
    }

    /**
     * @uses aquest main només el faig servir per fer proves. Al executar el programa final aquest no fa res
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu el nom d'usuari: ");
        String nom=sc.next();
        System.out.print("Escriu la teva edat: ");
        int edat=sc.nextInt();
        Persona p1=new Persona();
        p1.escriureUserFitxer();

    }
}
