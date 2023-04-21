package com.adenterprise.sapceinvaders.engine;//Aram

import com.adenterprise.sapceinvaders.objects.Bala;
import com.adenterprise.sapceinvaders.objects.Nau;
import com.adenterprise.sapceinvaders.objects.Room;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Moviment_Dispar {
    private static String movAnterior;
    public static Scanner teclat;

    public static int move(Room room, Nau nau, ArrayList<Bala> balas){
        movAnterior=" ";
        int error=0;
        String moviment = teclat.next().toLowerCase();
        char[][] tablero= room.getSala();

        if (Objects.equals(moviment, "a")) {
            if (nau.getPosicioY()-1==-1){
                System.out.println("Limit");
                error=1;
            } else {
                nau.setPosicioY(nau.getPosicioY() - 1);
                tablero[nau.getPosicioX()][nau.getPosicioY()] = 'x';
                tablero[nau.getPosicioX()][nau.getPosicioY() + 1] = ' ';
            }
            movAnterior = "a";
        }

        if (Objects.equals(moviment, "d")) {
            if (nau.getPosicioY()+1==12){
                System.out.println("Limit");
                error=1;
            } else {
                nau.setPosicioY(nau.getPosicioY()+1);
                tablero[nau.getPosicioX()][nau.getPosicioY()]='x';
                tablero[nau.getPosicioX()][nau.getPosicioY()-1]=' ';
            }
            movAnterior = "d";
        }

        if (Objects.equals(moviment, "s")) {
            movAnterior = "s";
        }

        if (Objects.equals(moviment, "e")) {
            if (movAnterior.equals("e")){
                System.out.println("No pots tornar a disparar");
                error=1;
            } else {
                balas.add(new Bala(nau.getPosicioX(), nau.getPosicioY()));
                movAnterior = "e";
            }
        }

        return error;
    }
    static {
        teclat = new Scanner(System.in);
    }
}
