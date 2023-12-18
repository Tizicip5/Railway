package com.railway;

import com.railway.exceptions.LimitWagonException;
import com.railway.exceptions.MaxWagaException;
import com.railway.model.Trasa;
import com.railway.model.Pociag;
import com.railway.model.asbstract.Wagon;
import com.railway.model.wagon.*;

import java.util.Random;
import java.util.Scanner;

public class Presentation {
    public static void main(String[] args) {
        Random random = new Random();
        String stacjaStartowa = Trasa.getStacja().get(random.nextInt(Trasa.getStacja().size()));
        String stacjaDocelowa = Trasa.getStacja().get(random.nextInt(Trasa.getStacja().size()));

        Pociag pociag = new Pociag(random.nextInt(100000)+"",stacjaStartowa,stacjaStartowa,stacjaDocelowa, random.nextInt(5)+5, random.nextInt(300)+1000, random.nextInt(5), 180 + (180 - 60) * random.nextDouble());

        for(int i=0; i<8; i++){
            Wagon wagon = null;
            int number = random.nextInt(12);
            switch (number){
                case 1:{
                    wagon = new wagBagazPoczt("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProdukt: " + i);
                    break;
                }
                case 2:{
                    wagon = new wagTowarPodst("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProdukt: " + i);
                    break;
                }
                case 3:{
                    wagon = new wagWybuch("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProdukt: " + i, random.nextBoolean());
                    break;
                }
                case 4:{
                    wagon = new wagGaz("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProdukt: " + i, "TypGaz: " + i);
                    break;
                }
                case 5:{
                    wagon = new wagTowarCiezki("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProdukt: " + i);
                    break;
                }
                case 6:{
                    wagon = new wagCieklMatToks("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProdukt: " + i, random.nextInt(10));
                    break;
                }
                case 7:{
                    wagon = new wagPasazerski("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+30,true);
                    break;
                }
                case 8:{
                    wagon = new wagPocztowy("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(100)+100,true);
                    break;
                }
                case 9:{
                    wagon = new wagChwodn("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i,random.nextInt(10)-10,true);
                    break;
                }
                case 10:{
                    wagon = new wagRestauracyjny("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+30,true);
                    break;
                }
                case 11:{
                    wagon = new wagMatCiekl("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i);
                    break;
                }
                case 12: {
                    wagon = new wagMatToksyczn("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProduktu: " + i, random.nextInt(10));
                    break;
                }
                default:
                {
                    System.out.println("Wagon domyślny");
                }
            }

            try {
                pociag.dodacWagon(wagon);

            } catch (LimitWagonException e) {
                e.printStackTrace();
            } catch (MaxWagaException e) {
                e.printStackTrace();
            }
        }

        pociag.run();
        Scanner scanner = new Scanner(System.in);

        while (true){

            int wybierz = 0;

            System.out.println("1. Wszystkie informacje o pociągach");
            System.out.println("2. Wyjśćie");

            wybierz = scanner.nextInt();

            switch (wybierz){
                case 1:
                {
                    System.out.println(pociag);
                    break;
                }
                case 2:
                {
                    System.out.println("Good luck ... ");
                }
            }
            if(wybierz == 2){
                break;
            }
        }
    }
}
