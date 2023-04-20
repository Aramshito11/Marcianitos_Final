package com.adenterprise.sapceinvaders.objects;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class room {
    public static Scanner teclat;
    private char[][] sala = new char[12][12];
    public room() {
    }

    public static void main(String[] args) {

        Nau nau = new Nau(11,5,3);
        room room = new room();
        ArrayList<Bala> balas = new ArrayList<Bala>();
        ArrayList<Monstre1> monstres1 = new ArrayList<Monstre1>();
        ArrayList<Monstre2> monstres2 = new ArrayList<Monstre2>();



        for(int i = 0; i < room.sala.length; i++) {
            for(int j = 0; j < room.sala[i].length; j++) {
                room.sala[i][j] = ' ';
            }
        }

        for(int i = 0; i < room.sala.length - 8; i++) {
            for(int j = 0; j < room.sala[i].length; j++) {
                if (i%2==0){
//                    monstres1.add(new Monstre1())
                    room.sala[i][j] = 'U';
                } else {
                    room.sala[i][j] = '0';
                }
            }

        }

        int error = 0;
        int contador = 0;
        String movAnterior = "";
        room.sala[11][5] = 'x';

        while(contador==0) {

            error=0;

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            for(int i = 0; i < room.sala.length; i++) {
                System.out.print("┃\t");
                for(int j = 0; j < room.sala[i].length; j++) {
                    System.out.print(room.sala[i][j] + "\t");
                }
                System.out.println("┃");
            }
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            String moviment = teclat.next().toLowerCase();



            if (Objects.equals(moviment, "a")) {
                if (nau.getPosicioY()-1==-1){
                    System.out.println("Limit");
                    error=1;
                } else {
                    nau.setPosicioY(nau.getPosicioY() - 1);
                    room.sala[nau.getPosicioX()][nau.getPosicioY()] = 'x';
                    room.sala[nau.getPosicioX()][nau.getPosicioY() + 1] = ' ';
                }
                movAnterior = "a";
            }

            if (Objects.equals(moviment, "d")) {
                if (nau.getPosicioY()+1==12){
                    System.out.println("Limit");
                    error=1;
                } else {
                    nau.setPosicioY(nau.getPosicioY()+1);
                    room.sala[nau.getPosicioX()][nau.getPosicioY()]='x';
                    room.sala[nau.getPosicioX()][nau.getPosicioY()-1]=' ';
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

            if (error==1){

            } else {
                for (int i=0; i<balas.size(); i++){
                    Bala bala = balas.get(i);
                    System.out.println(bala.getX()-1);
                    if(bala.getX()-1 ==-1){
                        room.sala[bala.getX()][bala.getY()]=' ';
                        balas.remove(i);
                        i--;
                    } else {
                        if (room.sala[bala.getX() - 1][bala.getY()] == '0' || room.sala[bala.getX() - 1][bala.getY()] == 'U') {
                            room.sala[bala.getX() - 1][bala.getY()] = ' ';
                            room.sala[bala.getX()][bala.getY()] = ' ';
                            balas.remove(i);
                            i--;
                        } else {
                            bala.setX(bala.getX() - 1);
                            room.sala[bala.getX()][bala.getY()] = 'o';
                            if (room.sala[bala.getX() + 1][bala.getY()] != 'x') {
                                room.sala[bala.getX() + 1][bala.getY()] = ' ';
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        teclat = new Scanner(System.in);
    }
}