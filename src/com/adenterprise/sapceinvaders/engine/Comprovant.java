package com.adenterprise.sapceinvaders.engine;//Aram

import com.adenterprise.sapceinvaders.objects.Monstre1;
import com.adenterprise.sapceinvaders.objects.Monstre2;

import java.util.ArrayList;

public class Comprovant {
    public static int comrpovarPos(ArrayList<Monstre1> monstres1, ArrayList<Monstre2> monstres2){
        int res=0;
        for (int i = 0; i<monstres1.size(); i++){
            Monstre1 monstre = monstres1.get(i);
            if (monstre.getX()==11){
                res=1;
            }
        }
        for (int i = 0; i<monstres2.size(); i++){
            Monstre2 monstre = monstres2.get(i);
            if (monstre.getX()==11) {
                res = 1;
            }
        }
        return res;
    }
}
