package com.adenterprise.sapceinvaders.objects;//Aram

public class Nau {
    private int posicio;
    private int vides;

    public Nau(int posicio, int vides) {
        this.posicio = posicio;
        this.vides = vides;
    }

    public int getPosicio() {
        return posicio;
    }

    public void setPosicio(int posicio) {
        this.posicio = posicio;
    }

    public int getVides() {
        return vides;
    }

    public void setVides(int vides) {
        this.vides = vides;
    }

    public void showData(){
        System.out.println("\n\nNAU");
        System.out.println("Posicio: "+getPosicio());
        System.out.println("Vides: "+getVides());
    }

    public static void main(String[] args) {
        Nau n1=new Nau(1, 3);
        n1.showData();
    }
}
