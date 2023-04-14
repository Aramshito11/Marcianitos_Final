package com.adenterprise.sapceinvaders.objects;//Aram
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
        System.out.println("Escriu el nom d'usuari: ");
        String nom=sc.next();
        System.out.println("Escriu la teva edat: ");
        int edat=sc.nextInt();
        Persona p1=new Persona(nom, edat);

    }
}
