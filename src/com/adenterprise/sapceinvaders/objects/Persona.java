package com.adenterprise.sapceinvaders.objects;//Aram
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Persona {
    private String nom;
    private int edat;
    private int numPartides;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
        this.numPartides = 0;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriu el nom d'usuari: ");
        String nom=sc.next();
        System.out.print("Escriu la teva edat: ");
        int edat=sc.nextInt();
        Persona p1=new Persona(nom, edat);
        File usuaris=new File("usuaris.txt");
        try {
            usuaris.createNewFile();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try {
            FileWriter escriure = new FileWriter("usuaris.txt", true);
            escriure.write("\nEl nom de l'usuari es: "+p1.getNom()+"\n");
            escriure.write("L'edat de l'usuari es: "+p1.getEdat()+"\n");
            escriure.write("Partida de l'usuari es: "+p1.getNumPartides()+"\n");
            escriure.close();
            System.out.println("Fitxer escrit");
        } catch (IOException e) {
            System.out.println("No s'ha pogut escriure en el fitxer");
            e.printStackTrace();
        }

    }
}
