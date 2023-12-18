package com.railway.model;

import com.railway.model.asbstract.Wagon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    public static void writeToFile(ArrayList<Pociag> trains) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("AppState.txt",true));

        trains.sort((Pociag t1, Pociag t2) -> Double.compare(Trasa.obliczenieOdleglosci(t2.getTrasa()), Trasa.obliczenieOdleglosci(t1.getTrasa())));

        trains.forEach(x->x.getWagon().sort((Wagon c1, Wagon c2) -> Double.compare(c1.getWagaNetto(), c2.getWagaNetto())));

        for(Pociag train : trains){
            writer.write("POCIĄG\n\r");
            writer.write(train.toString());
            writer.write("\n\rWAGONY\n\r");
            train.getWagon().forEach(x-> {
                try {
                    writer.write(x.toString()+"\n\r");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            });
        }
        writer.close();
    }
}
