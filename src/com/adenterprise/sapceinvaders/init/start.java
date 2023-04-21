package com.adenterprise.sapceinvaders.init;//Aram
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

        Mapa.IniciarMapa(room, monstres1, monstres2);

        int partida = 0;
        while (partida==0){
            if (monstres1.size()==0 && monstres2.size()==0) {
                partida=1;
            } else {
                llegir_mapa.monstrarTaulell(room);
                int error = Moviment_Dispar.move(room, nau, balas);
                Moviment_Marciano_Bala.movAutomatics(error, room, balas, monstres1, monstres2);
            }
        }
    }
}
