package com.adenterprise.sapceinvaders.objects;//Aram

public class nau {
    private int posicio;
    private int vides;

    public nau(int posicio, int vides) {
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
        nau n1=new nau(1, 3);
        n1.showData();
    }
}
