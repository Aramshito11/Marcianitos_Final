package com.adenterprise.sapceinvaders.objects;//Aram


/**
 * @uses la classe nau es el que nosaltres controlarem
 */
public class Nau {
    private int posicio;

    /**
     * @param aquest podra tenir tantes vides com fagin falta
     */
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
    /**
     * @uses aquest main només el faig servir per fer proves. Al executar el programa final aquest no fa res
     */
    public static void main(String[] args) {
        Nau n1=new Nau(1, 3);
        n1.showData();
    }
}
