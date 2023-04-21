package com.adenterprise.sapceinvaders.engine;//Aram

import com.adenterprise.sapceinvaders.objects.*;

import java.util.ArrayList;

public class Moviment_Marciano_Bala {
    public static void movAutomatics(int error, Room room, ArrayList<Bala> balas, ArrayList<Monstre1> monstres1, ArrayList<Monstre2> monstres2) {

        char[][] tablero= room.getSala();

        if (error==1){

        } else {
            for (int g = 0; g< monstres1.size(); g++){
                Monstre1 monstre = monstres1.get(g);
                tablero[monstre.getX()][monstre.getY()]= ' ';
            }
            for (int f = 0; f< monstres2.size(); f++){
                Monstre2 monstre = monstres2.get(f);
                tablero[monstre.getX()][monstre.getY()]= ' ';
            }

            for (int i = 0; i<monstres1.size(); i++){
                Monstre1 monstre = monstres1.get(i);
                if (monstre.getX()%2==0){
                    if (monstre.getY()+1==12){
                        monstre.setX(monstre.getX()+1);
                    } else {
                        monstre.setY(monstre.getY()+1);
                    }
                    tablero[monstre.getX()][monstre.getY()] = 'U';
                } else {
                    if (monstre.getY()-1==-1){
                        monstre.setX(monstre.getX()+1);
                    } else {
                        monstre.setY(monstre.getY()-1);
                    }
                    tablero[monstre.getX()][monstre.getY()] = 'U';
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
                    tablero[monstre.getX()][monstre.getY()] = '0';

                } else {
                    if (monstre.getY()-1==-1){
                        monstre.setX(monstre.getX()+1);
                    } else {
                        monstre.setY(monstre.getY()-1);
                    }
                    tablero[monstre.getX()][monstre.getY()] = '0';
                }
            }

            for (int i=0; i<balas.size(); i++){
                Bala bala = balas.get(i);
                if(bala.getX()-1 ==-1){
                    tablero[bala.getX()][bala.getY()]=' ';
                    balas.remove(i);
                    i--;
                } else {
                    if (tablero[bala.getX() - 1][bala.getY()] == '0' || tablero[bala.getX() - 1][bala.getY()] == 'U') {
                        tablero[bala.getX() - 1][bala.getY()] = ' ';
                        tablero[bala.getX()][bala.getY()] = ' ';
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
                        tablero[bala.getX()][bala.getY()] = 'o';
                        if (tablero[bala.getX() + 1][bala.getY()] != 'x') {
                            tablero[bala.getX() + 1][bala.getY()] = ' ';
                        }
                    }
                }
            }
        }
    }
}
