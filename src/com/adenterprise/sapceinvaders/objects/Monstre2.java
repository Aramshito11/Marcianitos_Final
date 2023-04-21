package com.adenterprise.sapceinvaders.objects;

/**
 * @uses la classe monstre2 agafa tots els atributs de monstres i en té una de propia que es arma.
 */
public class Monstre2 extends Monstres{
    /**
     * @param si es true tindra arma, sino no
     */
    private boolean arma;


    public Monstre2(int x, int y, boolean arma) {
        super(1, x, y, 2);
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
        System.out.println("Pos x: "+getX());
        System.out.println("Pos y: "+getY());
        System.out.println("Vides: "+getVides());
        System.out.println("Tipus: "+getTipus());
        if (isArma()==true)
            System.out.println("Arma: SI");
        else
            System.out.println("Arma: NO");
    }
}


