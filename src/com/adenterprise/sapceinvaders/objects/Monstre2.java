package com.adenterprise.sapceinvaders.objects;


public class Monstre2 extends Monstres{
    private boolean arma;

    public Monstre2(int linea, boolean arma) {
        super(1, linea, 2);
        this.arma = arma;
    }

    public boolean isArma() {
        return arma;
    }

    public void setArma(boolean arma) {
        this.arma = arma;
    }
    @Override
    public void showData() {
        System.out.println("\n\nMONSTRE");
        System.out.println("Linea: "+getLinea());
        System.out.println("Vides: "+getVides());
        System.out.println("Tipus: "+getTipus());
        if (isArma()==true)
            System.out.println("Arma: SI");
        else
            System.out.println("Arma: NO");
    }
}


