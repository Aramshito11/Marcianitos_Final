package com.adenterprise.sapceinvaders.objects;


public class monstre1 extends Monstres{


    public monstre1(int linea) {
        super(1, linea, 1);
    }

    @Override
    public void showData(){
        System.out.println("\n\nMONSTRE");
        System.out.println("Linea: "+getLinea());
        System.out.println("Vides: "+getVides());
        System.out.println("Tipus: "+getTipus());
    }

}


