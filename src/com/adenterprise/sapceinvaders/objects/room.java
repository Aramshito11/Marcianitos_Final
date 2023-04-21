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
                    monstres1.add(new Monstre1(i,j));
                    room.sala[i][j] = 'U';
                } else {
                    monstres2.add(new Monstre2(i,j, false));
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
                for (int g = 0; g< monstres1.size(); g++){
                    Monstre1 monstre = monstres1.get(g);
                    room.sala[monstre.getX()][monstre.getY()]= ' ';
                }
                for (int f = 0; f< monstres2.size(); f++){
                    Monstre2 monstre = monstres2.get(f);
                    room.sala[monstre.getX()][monstre.getY()]= ' ';
                }

                for (int i = 0; i<monstres1.size(); i++){
                    Monstre1 monstre = monstres1.get(i);
                    if (monstre.getX()%2==0){
                        if (monstre.getY()+1==12){
                            monstre.setX(monstre.getX()+1);
                        } else {
                            monstre.setY(monstre.getY()+1);
                        }
                        room.sala[monstre.getX()][monstre.getY()] = 'U';
                    } else {
                        if (monstre.getY()-1==-1){
                            monstre.setX(monstre.getX()+1);
                        } else {
                            monstre.setY(monstre.getY()-1);
                        }
                        room.sala[monstre.getX()][monstre.getY()] = 'U';
                    }
                }
                for (int i = 0; i<monstres2.size(); i++){
                    Monstre2 monstre = monstres2.get(i);
                    if (monstre.getX()%2==0){
                        if (monstre.getY()+1==12){
                            monstre.setX(monstre.getX()+1);
                        } else {
                            monstre.setY(monstre.getY()+1);
                        }
                        room.sala[monstre.getX()][monstre.getY()] = '0';

                    } else {
                        if (monstre.getY()-1==-1){
                            monstre.setX(monstre.getX()+1);
                        } else {
                            monstre.setY(monstre.getY()-1);
                        }
                        room.sala[monstre.getX()][monstre.getY()] = '0';
                    }
                }

                for (int i=0; i<balas.size(); i++){
                    Bala bala = balas.get(i);
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
                            for (int j=0; j<monstres1.size(); j++){
                                Monstre1 monstre = monstres1.get(j);
                                if (monstre.getX()==bala.getX()-1 && monstre.getY() == bala.getY()){
                                    monstres1.remove(j);
                                    j--;
                                }

                            }
                            for (int k=0; k<monstres2.size(); k++){
                                Monstre2 monstre = monstres2.get(k);
                                if (monstre.getX()==bala.getX()-1 && monstre.getY() == bala.getY()){
                                    monstres2.remove(k);
                                    k--;
                                }
                            }
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