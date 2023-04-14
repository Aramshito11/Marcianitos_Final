package com.adenterprise.sapceinvaders.objects;//Aram



abstract class Monstres{
    private int tipus; //Un marcanito pot ser tipus 1 o 2 (depenguent del disseny)
    private int linea; //linea on posarem el marcianito
    private int vides;


    public Monstres(int tipus, int linea, int vides) {
        this.tipus = tipus;
        this.linea = linea;
        this.vides = vides;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getVides() {
        return vides;
    }

    public void setVides(int vides) {
        this.vides = vides;
    }

    public void showVides(){
        System.out.println(getVides());
    }

    public abstract void showData();

}


public class Monstre {
    public static void main(String[] args) {
        Monstre1 m1=new Monstre1(1);
        Monstre2 m2=new Monstre2(2, false);
        m1.showData();
        m2.showData();
    }
}
