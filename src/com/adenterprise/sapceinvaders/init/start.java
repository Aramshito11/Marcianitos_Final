package com.adenterprise.sapceinvaders.init;//Aram
import com.adenterprise.sapceinvaders.engine.Comprovant;
import com.adenterprise.sapceinvaders.engine.Moviment_Dispar;
import com.adenterprise.sapceinvaders.engine.Moviment_Marciano_Bala;
import com.adenterprise.sapceinvaders.file.llegir_mapa;
import com.adenterprise.sapceinvaders.objects.*;

import java.util.ArrayList;

public class start {
    public static void main(String[] args) {
        Nau nau = new Nau(11,5,3);
        Room room = new Room();
        ArrayList<Bala> balas = new ArrayList<Bala>();
        ArrayList<Monstre1> monstres1 = new ArrayList<Monstre1>();
        ArrayList<Monstre2> monstres2 = new ArrayList<Monstre2>();
        Persona p1 = new Persona();

        p1.llegirNumPartides();
        Mapa.IniciarMapa(room, monstres1, monstres2);

        int partida = 0;
        while (partida==0){
            if (Comprovant.comrpovarPos(monstres1,monstres2)==1){
                partida=2;
            } else if (monstres1.size()==0 && monstres2.size()==0) {
                partida=1;
            } else {
                llegir_mapa.monstrarTaulell(room);
                int error = Moviment_Dispar.move(room, nau, balas);
                Moviment_Marciano_Bala.movAutomatics(error, room, balas, monstres1, monstres2);
            }
        }
        System.out.println(partida);
        if (partida==1){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃   Y  O  U    W  I  N   ┃ ");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
        } else if (partida==2){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃   Y  O  U    L  O  S  E   ┃ ");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }
        p1.escriurePartida();
        p1.llegirNumPartides();
    }
}
