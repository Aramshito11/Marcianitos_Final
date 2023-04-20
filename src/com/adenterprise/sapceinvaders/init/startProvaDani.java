package com.adenterprise.sapceinvaders.init;

import com.adenterprise.sapceinvaders.objects.Monstre1;
import com.adenterprise.sapceinvaders.objects.Monstre2;
import com.adenterprise.sapceinvaders.objects.Nau;
import com.adenterprise.sapceinvaders.objects.Persona;

public class startProvaDani {
    public static void main(String[] args) {
        Nau n1= new Nau(1,3);
        Monstre1 m1=new Monstre1(1);
        Monstre2 m2=new Monstre2(2, false);
        Persona p1= new Persona();
        n1.showData();
        m1.showData();
        m2.showData();
        p1.showData();
        p1.ferPartida();
        p1.showData();
        p1.llegirNumPartides();
    }
}
