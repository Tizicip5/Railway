package com.railway;

import com.railway.exceptions.LimitWagonException;
import com.railway.exceptions.MaxWagaException;
import com.railway.model.Trasa;
import com.railway.model.Storage;
import com.railway.model.Pociag;
import com.railway.model.asbstract.Wagon;
import com.railway.model.wagon.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        Random random = new Random();

        ArrayList<Pociag> trains = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int wybierz = 0;

        while(wybierz != 9){
            System.out.println("1. Dodaj pociąg");
            System.out.println("2. Dodaj wagon");
            System.out.println("3. Usuń pociąg");
            System.out.println("4. Usuń wagon");
            System.out.println("5. Dodaj stację");
            System.out.println("6. Usuń stację");
            System.out.println("7. Generuj");
            System.out.println("8. Rozpocznij symulację");
            System.out.println("9. Wyjdż");
            wybierz = scanner.nextInt();
            switch (wybierz){
                case 1:{
                    System.out.print("Wprowadź nazwę(ID) pociągu : ");
                    String name = bufferedReader.readLine();

                    Trasa.drukStacja();

                    System.out.print("Wprowadź ID dla stacji startowej : ");
                    int stacjaStartowa = scanner.nextInt();

                    Trasa.drukStacja();

                    System.out.print("Wprowadź ID dla stacji docelowej  : ");
                    int stacjaDocelowa = scanner.nextInt();

                    System.out.print("Wprowadź maksymalną liczbę wagonów : ");
                    int maxLiczbaWagon = scanner.nextInt();

                    System.out.print("Wprowadź maksymalną wagę : ");
                    int maxWagaWagon = scanner.nextInt();

                    System.out.print("Wprowadź maksymalną liczbę elektrycznych wagonów : ");
                    int maxLiczbaElWagon = scanner.nextInt();

                    System.out.print("Wprowadź prędkość : ");
                    int przedkosc = scanner.nextInt();

                    Pociag pociag = new Pociag(name, Trasa.getStacja().get(stacjaStartowa), Trasa.getStacja().get(stacjaStartowa), Trasa.getStacja().get(stacjaDocelowa), maxLiczbaWagon, maxWagaWagon, maxLiczbaElWagon, przedkosc);
                    trains.add(pociag);
                    break;
                }
                case 2:{
                    trains.forEach(System.out::println);
                    System.out.print("Wprowadź ID,jeżeli chcesz dodać wagon : ");
                    int trainId = scanner.nextInt();

                    System.out.println("1.Wagon bagażowo-pocztowy");
                    System.out.println("2.Wagon towarowy podstawowy");
                    System.out.println("3.Wagon na materiały wybuchowe");
                    System.out.println("4.Wagon na materiały gazowe");
                    System.out.println("5.wagon towarowy ciężki");
                    System.out.println("6.Wagon na ciekłe materiały toksyczne");
                    System.out.println("7.Wagon pasażerski");
                    System.out.println("8.Wagon pocztowy");
                    System.out.println("9.Wagon chłodniczy");
                    System.out.println("10.Wagon restauracyjny");
                    System.out.println("11.Wagon na materiały ciekłe");
                    System.out.println("12.Wagon na materiały toksyczne");

                    System.out.print("Wybierz typ wagonu : ");
                    int typWag = scanner.nextInt();

                    System.out.print("Wpisz nadawcę : ");
                    String nadawca = bufferedReader.readLine();

                    System.out.print("Czy jest zabezpieczeństwo (yes/no) : ");
                    String zabezpieczenie = bufferedReader.readLine();
                    boolean bezpieczenstwo;
                    if(zabezpieczenie == "yes")
                        bezpieczenstwo = true;
                    else
                        bezpieczenstwo = false;

                    System.out.print("Wprowadź wagę netto: ");
                    int wagaNetto = scanner.nextInt();

                    System.out.print("Wprowadź wagę brutto: ");
                    int wagaBrutto = scanner.nextInt();

                    Wagon wagon = null;

                    switch (typWag){
                        case 1:{
                            System.out.print("Wprowadź wagę produktu: ");
                            int wagaProdukt = scanner.nextInt();
                            System.out.print("Typ produktu: ");
                            String typProdukt = bufferedReader.readLine();
                            wagon = new wagBagazPoczt(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,wagaProdukt,typProdukt);
                            break;
                        }
                        case 2:{
                            System.out.print("Wprowadź wagę produktu: ");
                            int wagaProdukt = scanner.nextInt();
                            System.out.print("Typ produktu: ");
                            String productType = bufferedReader.readLine();
                            wagon = new wagTowarPodst(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,wagaProdukt,productType);
                            break;
                        }
                        case 3:{
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            System.out.print("Czy jest klimatyzacja? (yes/no) : ");
                            String klimatyzacjaString = bufferedReader.readLine();
                            boolean klimatyzacja;
                            if(klimatyzacjaString == "yes")
                                klimatyzacja = true;
                            else
                                klimatyzacja = false;

                            wagon = new wagWybuch(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,typProduktu,klimatyzacja);
                            break;
                        }
                        case 4:{
                            System.out.print("Wprowadź wagę produktu: ");
                            int wagaProdukt = scanner.nextInt();
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            System.out.print("Rodzaj gazu: ");
                            String rodzajGaz = bufferedReader.readLine();
                            wagon = new wagGaz(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,wagaProdukt,typProduktu,rodzajGaz);
                            break;
                        }
                        case 5:{
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            wagon = new wagTowarCiezki(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,typProduktu);
                            break;
                        }
                        case 6:{
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            System.out.print("Klasa zagrożenia: ");
                            int klasaZagrożenia = scanner.nextInt();
                            wagon = new wagCieklMatToks(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,typProduktu,klasaZagrożenia);
                            break;
                        }
                        case 7:{
                            System.out.print("Liczba miejsc : ");
                            int liczbaMiejsc = scanner.nextInt();
                            wagon = new wagPasazerski(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,liczbaMiejsc,true);
                            break;
                        }
                        case 8:{
                            System.out.print("Liczba paczek : ");
                            int liczbaPaczek = scanner.nextInt();
                            wagon = new wagPocztowy(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,liczbaPaczek,true);
                            break;
                        }
                        case 9:{
                            System.out.print("Wprowadź wagę produktu: ");
                            int wagaProdukt = scanner.nextInt();
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            System.out.print("Temperatura: ");
                            int temp = scanner.nextInt();
                            wagon = new wagChwodn(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,wagaProdukt,typProduktu,temp,true);
                            break;
                        }
                        case 10:{
                            System.out.print("Liczba miejsc : ");
                            int liczbaMiejsc = scanner.nextInt();
                            wagon = new wagRestauracyjny(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,liczbaMiejsc,true);
                            break;
                        }
                        case 11:{
                            System.out.print("Wprowadź wagę produktu: ");
                            int wagaProdukt = scanner.nextInt();
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            wagon = new wagMatCiekl(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,wagaProdukt,typProduktu);
                            break;
                        }
                        case 12:{
                            System.out.print("Typ produktu: ");
                            String typProduktu = bufferedReader.readLine();
                            System.out.print("Danger klas: ");
                            int dangerKlas = scanner.nextInt();
                            wagon = new wagMatToksyczn(nadawca,bezpieczenstwo,wagaNetto,wagaBrutto,typProduktu,dangerKlas);
                            break;
                        }
                    }
                    try {
                        trains.get(trainId).dodacWagon(wagon);
                    } catch (LimitWagonException e) {
                        e.printStackTrace();
                    } catch (MaxWagaException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    trains.forEach(System.out::println);
                    System.out.print("Wprowadź ID pociągu żeby usunąć : ");
                    int pociagId = scanner.nextInt();
                    trains.remove(trains.get(pociagId));
                    break;
                }
                case 4:{
                    trains.forEach(System.out::println);
                    System.out.print("Wpowadź ID pociągu żeby usunąć wagon: ");
                    int PociagId = scanner.nextInt();
                    trains.get(PociagId).getWagon().forEach(System.out::println);

                    System.out.print("Wpowadź ID wagonu żeby usunąć go : ");
                    String wagonId = bufferedReader.readLine();
                    trains.get(PociagId).getWagon().remove(trains.get(PociagId).getWagon().stream().filter(x->x.getNumer().equals(wagonId)).findFirst().get());
                    break;
                }
                case 5:{
                    System.out.println("Wpowadź nazwę stacji żeby dodać");
                    String stacja = bufferedReader.readLine();
                    Trasa.addStacja(stacja);
                    break;
                }
                case 6:{
                    System.out.println("Wpowadź nazwę stacji żeby usunąć");
                    String stacja = bufferedReader.readLine();
                    Trasa.deleteStacja(stacja);
                    break;
                }
                case 7:{
                    for(int k=0; k<25; k++){
                        String startStacja = Trasa.getStacja().get(random.nextInt(Trasa.getStacja().size()));
                        String docelowaStacja = Trasa.getStacja().get(random.nextInt(Trasa.getStacja().size()));

                        Pociag pociag = new Pociag(random.nextInt(100000)+"",startStacja,startStacja,docelowaStacja, random.nextInt(5)+5, random.nextInt(300)+1000, random.nextInt(5), 60 + (120 - 60) * random.nextDouble());

                        for(int i=0; i<8; i++){
                            Wagon wagon = null;
                            int number = random.nextInt(12);
                            switch (number){
                                case 0:{
                                    wagon = new wagBagazPoczt("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i);
                                    break;
                                }
                                case 1:{
                                    wagon = new wagTowarPodst("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i);
                                    break;
                                }
                                case 2:{
                                    wagon = new wagWybuch("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProduktu: " + i, random.nextBoolean());
                                    break;
                                }
                                case 3:{
                                    wagon = new wagGaz("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i, "TypGazu: " + i);
                                    break;
                                }
                                case 4:{
                                    wagon = new wagTowarCiezki("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProduktu: " + i);
                                    break;
                                }
                                case 5:{
                                    wagon = new wagCieklMatToks("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, "TypProduktu: " + i, random.nextInt(10));
                                    break;
                                }
                                case 6:{
                                    wagon = new wagPasazerski("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+30,true);
                                    break;
                                }
                                case 7:{
                                    wagon = new wagPocztowy("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(100)+100,true);
                                    break;
                                }
                                case 8:{
                                    wagon = new wagChwodn("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i,random.nextInt(10)-10,true);
                                    break;
                                }
                                case 9:{
                                    wagon = new wagRestauracyjny("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+30,true);
                                    break;
                                }
                                case 10:{
                                    wagon = new wagMatCiekl("Nadawca " + i, random.nextBoolean(), random.nextInt(30)+70, random.nextInt(30)+100, random.nextInt(30)+20,"TypProduktu: " + i);
                                    break;
                                }
                                case 11: {
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
                        trains.add(pociag);
                    }
                    System.out.println("Udało się");
                    break;
                }
                case 8:{
                    trains.forEach(Pociag::run);

                    Thread writer = new Thread(){
                        @Override
                        public void run() {
                            try {
                                while (true){
                                    Storage.writeToFile(trains);
                                    sleep(5000);
                                }
                            } catch (IOException | InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    };

                    writer.setDaemon(true);
                    writer.start();

                    while (true){

                        int wybierz2 = 0;

                        System.out.println("1. Wszystkie informacje o pociągach");
                        System.out.println("2. Informacje o pociągu według ID");
                        System.out.println("3. Wyjśćie");

                        wybierz2 = scanner.nextInt();

                        switch (wybierz2){
                            case 1:
                            {
                                trains.forEach(System.out::println);
                                break;
                            }
                            case 2:
                            {
                                System.out.print("Wpowadź ID dla wyświetlenia informacji : ");
                                int id = scanner.nextInt();
                                trains.stream().filter(x->x.getId() == id).forEach(System.out::println);
                                break;
                            }
                            case 3:
                            {
                                System.out.println("Good luck...");
                                break;
                            }
                        }
                        if(wybierz2 == 3){
                            wybierz = 9;
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
