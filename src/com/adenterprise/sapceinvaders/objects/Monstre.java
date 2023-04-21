package com.adenterprise.sapceinvaders.objects;//Aram


/**
 * @uses la classe es abstracte perquè els monstres finals agafen info en comun.
 */
abstract class Monstres{
    /**
     * @param Un marcanito pot ser tipus 1 o 2 (depenguent del disseny)
     */
    private int tipus;

    /**
     * @param linea on posarem el marcianito
     */
    private int x;
    private int y;
    private int vides;


    public Monstres(int tipus, int x, int y, int vides) {
        this.tipus = tipus;
        this.x = x;
        this.y = y;
        this.vides = vides;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
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

    /**
     * @uses aquest metode es abstracte perquè tots els monstres volem que la tinguin
     */
    public abstract void showData();

}


public class Monstre {
    /**
     * @uses aquest main només el faig servir per fer proves. Al executar el programa final aquest no fa res
     */
//    public static void main(String[] args) {
//        Monstre1 m1=new Monstre1(1);
//        Monstre2 m2=new Monstre2(2, false);
//        m1.showData();
//        m2.showData();
//    }
}
