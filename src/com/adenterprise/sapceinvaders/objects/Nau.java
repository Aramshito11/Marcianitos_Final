package com.adenterprise.sapceinvaders.objects;//Aram


/**
 * @uses la classe nau es el que nosaltres controlarem
 */
public class Nau {
    /**
     * @param aquest podra tenir tantes vides com fagin falta
     */
    private int posicioX;
    private int posicioY;
    private int vides;

    public Nau(int posiciox, int posicioy, int vides) {
        this.posicioX = posiciox;
        this.posicioY = posicioy;
        this.vides = vides;
    }

    public int getPosicioX() {
        return posicioX;
    }

    public int getPosicioY() {
        return posicioY;
    }

    public void setPosicioX(int posicioX) {
        this.posicioX = posicioX;
    }

    public void setPosicioY(int posicioY) {
        this.posicioY = posicioY;
    }

    public int getVides() {
        return vides;
    }

    public void setVides(int vides) {
        this.vides = vides;
    }

    public void showData(){
        System.out.println("\n\nNAU");
        System.out.println("Posicio X: "+getPosicioX());
        System.out.println("Posicio Y: "+getPosicioY());
        System.out.println("Vides: "+getVides());
    }
    /**
     * @uses aquest main només el faig servir per fer proves. Al executar el programa final aquest no fa res
     */
//    public static void main(String[] args) {
//        Nau n1=new Nau(1, 3);
//        n1.showData();
//    }
}
