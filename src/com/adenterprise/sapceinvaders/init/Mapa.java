package com.adenterprise.sapceinvaders.init;//Aram

import com.adenterprise.sapceinvaders.objects.Monstre1;
import com.adenterprise.sapceinvaders.objects.Monstre2;
import com.adenterprise.sapceinvaders.objects.Room;

import java.util.ArrayList;

public class Mapa {
    public static void IniciarMapa(Room room, ArrayList<Monstre1> monstres1, ArrayList<Monstre2> monstres2){
        char[][] tablero= room.getSala();
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
        for(int i = 0; i < tablero.length - 8; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                if (i%2==0){
                    monstres1.add(new Monstre1(i,j));
                    tablero[i][j] = 'U';
                } else {
                    monstres2.add(new Monstre2(i,j, false));
                    tablero[i][j] = '0';
                }
            }
        }
        tablero[11][5] = 'x';
    }
}
