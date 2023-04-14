package com.adenterprise.sapceinvaders.file;

import com.adenterprise.sapceinvaders.objects.Persona;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class usuaris {
    File usuaris=new File("usuaris.txt");


    public void escriureUser (Persona p1){
        try {
            if (usuaris.createNewFile())
                System.out.println("El fitxer s'ha creat correctement");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try {
            FileWriter escriure = new FileWriter("usuaris.txt", false);
            escriure.write("El nom de l'usuari es: "+p1.getNom());
            escriure.write("L'edat de l'usuari es: "+p1.getEdat());
            escriure.write("Partida de l'usuari es: "+p1.getNumPartides());
            escriure.close();
            System.out.println("Fitxer escrit");
        } catch (IOException e) {
            System.out.println("No s'ha pogut escriure en el fitxer");
            e.printStackTrace();
        }

    }

}
