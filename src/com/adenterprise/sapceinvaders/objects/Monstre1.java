package com.adenterprise.sapceinvaders.objects;


/**
 * @uses la classe monstre1 agada tota la info de monstres perque no te armes.
 */
public class Monstre1 extends Monstres{

    public Monstre1(int x, int y) {
        super(1, x, y, 1);
    }

    @Override
    public void showData(){
        System.out.println("\n\nMONSTRE");
        System.out.println("Pos x: "+getX());
        System.out.println("Pos y: "+getY());
        System.out.println("Vides: "+getVides());
        System.out.println("Tipus: "+getTipus());
    }

}


