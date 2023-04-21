package com.adenterprise.sapceinvaders.file;//Aram

import com.adenterprise.sapceinvaders.objects.Room;

public class llegir_mapa {
    public static void monstrarTaulell(Room room){
        char[][] tablero= room.getSala();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        for(int i = 0; i < tablero.length; i++) {
            System.out.print("┃\t");
            for(int j = 0; j <tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println("┃");
        }
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
