package com.railway.model;

import java.util.ArrayList;
import java.util.Random;

public class Trasa {

    private static ArrayList<String> stacja = inicStacji();
    private static double[][] odleglosci = initodleglosc();
    private static String[][] ways = initWays();

    private static ArrayList<String> inicStacji(){
        stacja = new ArrayList<>();
        stacja.add("Warszawa Centralna");
        stacja.add("Kraków Główny");
        stacja.add("Gdańsk Główny");
        stacja.add("Poznań Główny");
        stacja.add("Wrocław Główny");
        stacja.add("Łódź Fabryczna");
        stacja.add("Katowice");
        stacja.add("Szczecin Główny");
        stacja.add("Bydgoszcz Główna");
        stacja.add("Lublin");
        stacja.add("Białystok");
        stacja.add("Gdynia Główna");
        stacja.add("Częstochowa");
        stacja.add("Olsztyn Główny");
        stacja.add("Rzeszów Główny");
        stacja.add("Toruń Główny");
        stacja.add("Kielce");
        stacja.add("Zielona Góra");
        stacja.add("Opole Główne");
        stacja.add("Bielsko-Biała");
        stacja.add("Gorzów Wielkopolski");
        stacja.add("Legnica");
        stacja.add("Tarnów");
        stacja.add("Płock");
        stacja.add("Kalisz");
        stacja.add("Słupsk");
        stacja.add("Konin");
        stacja.add("Elk");
        stacja.add("Zamość");
        stacja.add("Suwałki");
        stacja.add("Grudziądz");
        stacja.add("Mielec");
        stacja.add("Chojnice");
        stacja.add("Świdnica");
        stacja.add("Tczew");
        stacja.add("Ełk");
        stacja.add("Piotrków Trybunalski");
        stacja.add("Jarosław");
        stacja.add("Nowy Sącz");
        stacja.add("Ostrołęka");
        stacja.add("Kołobrzeg");
        stacja.add("Przemyśl");
        stacja.add("Leszno");
        stacja.add("Żary");
        stacja.add("Wałbrzych Główny");
        stacja.add("Krosno");
        stacja.add("Stargard Szczeciński");
        stacja.add("Skierniewice");
        stacja.add("Gniezno");
        stacja.add("Piła Główna");
        stacja.add("Siedlce");
        stacja.add("Inowrocław");
        stacja.add("Turek");
        stacja.add("Ostrowiec Świętokrzyski");
        stacja.add("Włocławek");
        stacja.add("Głogów");
        stacja.add("Kędzierzyn-Koźle");
        stacja.add("Lubin");
        stacja.add("Świebodzin");
        stacja.add("Żagań");
        stacja.add("Jaworzno Szczakowa");
        stacja.add("Pszczyna");
        stacja.add("Sławków");
        stacja.add("Jelcz-Laskowice");
        stacja.add("Zawiercie");
        stacja.add("Sandomierz");
        stacja.add("Nowa Sól");
        stacja.add("Koło");
        stacja.add("Kłodzko Główne");
        stacja.add("Kępno");
        stacja.add("Tarnobrzeg");
        stacja.add("Luboń");
        stacja.add("Sieradz");
        stacja.add("Konstancin-Jeziorna");
        stacja.add("Karczew");
        stacja.add("Ząbki");
        stacja.add("Warka");
        stacja.add("Sochaczew");
        stacja.add("Wołomin");
        stacja.add("Kobyłka");
        stacja.add("Aleksandrów Kujawski");
        stacja.add("Antonin");
        stacja.add("Augustów");
        stacja.add("Babiak");
        stacja.add("Babimost");
        stacja.add("Baby");
        stacja.add("Barczewo");
        stacja.add("Bartoszyce");
        stacja.add("Bedzin");
        stacja.add("Białystok");
        stacja.add("Bierawa");
        stacja.add("Bierzwnik");
        stacja.add("Bikgoraj");
        stacja.add("Brzezno");
        stacja.add("Buk");
        stacja.add("Bydgoszcz");
        stacja.add("Bytom");
        stacja.add("Chełm");
        stacja.add("Chełmce");
        stacja.add("Chmielnik");
        return stacja;
    }
    private static double[][] initodleglosc(){
        odleglosci = new double[stacja.size()][stacja.size()];

        Random random = new Random();
        for(int i = 0; i< odleglosci.length; i++){
            for(int j = 0; j< odleglosci.length; j++){
                if(i == j)
                    odleglosci[i][j] = 0;
                else{
                    odleglosci[i][j] = 100 + (500 - 100) * random.nextDouble();
                    odleglosci[j][i] = odleglosci[i][j];
                }
            }
        }
        return odleglosci;
    }
    private static String[][] initWays(){
        ways = new String[stacja.size()][stacja.size()];
        for(int i=0; i<ways.length; i++){
            for(int j=0; j<ways.length; j++){
                ways[i][j] = "";
            }
        }
        return ways;
    }

    public static void drukStacja(){
        int i=0;
        for(String stacja : stacja){
            System.out.println("id : " + i + " " + stacja);
            i++;
        }
    }

    public static ArrayList<String> generateTrasa(String pierwszy, String ostatni, int countStations){
        ArrayList<String> trasa = new ArrayList<>();

        int startIndex = stacja.indexOf(pierwszy);
        int koniecIndex = stacja.indexOf(ostatni);

        trasa.add(stacja.get(startIndex));

        Random random = new Random();

        for(int i=1; i<countStations-1; i++){
            int nextIndex = random.nextInt(stacja.size());
            if(nextIndex != startIndex && nextIndex != koniecIndex)
                trasa.add(stacja.get(nextIndex));
            else
                --i;
        }

        trasa.add(stacja.get(koniecIndex));
        return trasa;
    }

    public static double getOglegloscMiedzy(String pierwszy, String ostatni){
        int startIndex = stacja.indexOf(pierwszy);
        int ostatniIndex = stacja.indexOf(ostatni);
        return odleglosci[startIndex][ostatniIndex];
    }

    public static double obliczenieOdleglosci(ArrayList<String> trasa){
        double odleglosc=0;
        for(int i=0; i<trasa.size()-1; i++)
            odleglosc+= getOglegloscMiedzy(trasa.get(i),trasa.get(i+1));
        return odleglosc;
    }

    public static double ObliczOdlegloscPrzedStacjaNaTrasie(String stacja, ArrayList<String> trasa){
        double odleglosc = 0;
        int stacjaIndex = trasa.indexOf(stacja);
        for(int i=0; i<stacjaIndex; i++){
            odleglosc += getOglegloscMiedzy(trasa.get(i),trasa.get(i+1));
        }
        return odleglosc;
    }

    public static ArrayList<String> getStacja() {
        return stacja;
    }
    public static void setStacja(ArrayList<String> stacja) {
        Trasa.stacja = stacja;
    }
    public static double[][] getOdleglosci() {
        return odleglosci;
    }
    public static void setOdleglosci(double[][] odleglosci) {
        Trasa.odleglosci = odleglosci;
    }
    public static String[][] getWays() {
        return ways;
    }
    public static void setWays(String[][] ways) {
        Trasa.ways = ways;
    }
    public static void addStacja(String station){

        stacja.add(station);
        odleglosci = initodleglosc();
        ways = initWays();
    }
    public static void deleteStacja(String station){
        stacja.remove(station);
        odleglosci = initodleglosc();
        ways = initWays();
    }
}
