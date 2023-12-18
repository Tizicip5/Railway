package com.railway.model;

import com.railway.exceptions.LimitWagonException;
import com.railway.exceptions.MaxWagaException;
import com.railway.exceptions.RailroadHazard;
import com.railway.model.asbstract.Wagon;
import com.railway.model.wagon.wagBagazPoczt;
import com.railway.model.wagon.wagTowarPodst;
import com.railway.model.wagon.wagPasazerski;
import com.railway.model.wagon.wagRestauracyjny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pociag {

    private static int count = 0;
    private int id;
    private String nazwa;
    private String budowanieStacji;
    private String stacjaStartowa;
    private String stacjaDocelowa;
    private int liczbaWagon;
    private int maxWaga;
    private int liczbaElWagon;
    private double przedkosc;
    private ArrayList<String> trasa;
    private double odleglosc;

    private List<Wagon> wagons;

    public Pociag(String nazwa, String budowanieStacji, String stacjaStartowa, String stacjaDocelowa, int liczbaWagon, int maxWaga, int liczbaElWagon, double przedkosc) {
        this.id = count;
        count +=1;
        this.nazwa = nazwa;
        this.budowanieStacji = budowanieStacji;
        this.stacjaStartowa = stacjaStartowa;
        this.stacjaDocelowa = stacjaDocelowa;
        this.liczbaWagon = liczbaWagon;
        this.maxWaga = maxWaga;
        this.liczbaElWagon = liczbaElWagon;
        this.przedkosc = przedkosc;
        this.wagons = new ArrayList<>();
        this.odleglosc = 0;
        Random random = new Random();
        this.trasa = Trasa.generateTrasa(stacjaStartowa,stacjaDocelowa,random.nextInt(10)+3);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getBudowanieStacji() {
        return budowanieStacji;
    }
    public void setBudowanieStacji(String budowanieStacji) {
        this.budowanieStacji = budowanieStacji;
    }
    public String getStacjaStartowa() {
        return stacjaStartowa;
    }
    public void setStacjaStartowa(String stacjaStartowa) {
        this.stacjaStartowa = stacjaStartowa;
    }
    public String getStacjaDocelowa() {
        return stacjaDocelowa;
    }
    public void setStacjaDocelowa(String stacjaDocelowa) {
        this.stacjaDocelowa = stacjaDocelowa;
    }
    public int getLiczbaWagon() {
        return liczbaWagon;
    }
    public void setLiczbaWagon(int liczbaWagon) {
        this.liczbaWagon = liczbaWagon;
    }
    public int getMaxWaga() {
        return maxWaga;
    }
    public void setMaxWaga(int maxWaga) {
        this.maxWaga = maxWaga;
    }
    public int getLiczbaElWagon() {
        return liczbaElWagon;
    }
    public void setLiczbaElWagon(int liczbaElWagon) {
        this.liczbaElWagon = liczbaElWagon;
    }
    public double getPrzedkosc() {
        return przedkosc;
    }
    public void setPrzedkosc(int przedkosc) {
        this.przedkosc = przedkosc;
    }
    public List<Wagon> getWagon() {
        return wagons;
    }
    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
    public double getOdleglosc() {
        return odleglosc;
    }
    public void setOdleglosc(int odleglosc) {
        this.odleglosc = odleglosc;
    }
    public ArrayList<String> getTrasa() {
        return trasa;
    }
    public void setTrasa(ArrayList<String> trasa) {
        this.trasa = trasa;
    }

    public void dodacWagon(Wagon wagon) throws LimitWagonException, MaxWagaException {
        if(wagons.size() < liczbaWagon){
            if(wagons.stream().mapToDouble(Wagon::getWagaBrutto).sum() + wagon.getWagaBrutto() <= maxWaga) //проверяет, что если новый вагон будет добавлен к текущему составу, общая масса груза состава не превысит максимально допустимую массу maxWaga. Если это условие выполняется, новый вагон добавляется в состав, иначе генерируется исключение MaxWagaException
                wagons.add(wagon);
            else{
                System.out.println("MaxWagaException");
                throw new MaxWagaException();
            }
        }
        else{
            System.out.println("LimitWagonException");
            throw new LimitWagonException();
        }
    }
    public void zmianaPredkosci() throws RailroadHazard {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            przedkosc += (int) (przedkosc * 0.03);
        } else {
            przedkosc -= (int) (przedkosc * 0.03);
        }
        if(przedkosc > 200){
            System.out.println("RailroadHazard ograniczenie prędkości");
            throw new RailroadHazard(this.toString());
        }
    }
    public double getProcentCalejTrasy(){
        return (odleglosc * 100) / Trasa.obliczenieOdleglosci(trasa);
    }
    public double getProcentMiedzyStacjami(){
        double odlegloscMiedzyStacjami = Trasa.getOglegloscMiedzy(budowanieStacji, trasa.get(trasa.indexOf(budowanieStacji)+1));
        double odlegloscPrzed = Trasa.ObliczOdlegloscPrzedStacjaNaTrasie(budowanieStacji, trasa);
        double odlegloscWtenMoment = odleglosc - odlegloscPrzed;
        return (odlegloscWtenMoment * 100) / odlegloscMiedzyStacjami;
    }
    private boolean zmienaAktualnejStacji(){
        if(odleglosc > Trasa.ObliczOdlegloscPrzedStacjaNaTrasie(trasa.get(trasa.indexOf(budowanieStacji)+1), trasa)){
            odleglosc = Trasa.ObliczOdlegloscPrzedStacjaNaTrasie(trasa.get(trasa.indexOf(budowanieStacji)+1), trasa);
            int StartIndex = Trasa.getStacja().indexOf(budowanieStacji);
            int KoniecIndex = Trasa.getStacja().indexOf(trasa.get(trasa.indexOf(budowanieStacji)+1));
            Trasa.getWays()[StartIndex][KoniecIndex] = "";
            budowanieStacji = trasa.get(trasa.indexOf(budowanieStacji)+1);
            return true;
        }
        return false;
    }
    private boolean checkTrasaIsFree(){
        int startIndex = Trasa.getStacja().indexOf(budowanieStacji);
        int koniecIndex = Trasa.getStacja().indexOf(trasa.get(trasa.indexOf(budowanieStacji)+1));
        if(Trasa.getWays()[startIndex][koniecIndex].equals("") || Trasa.getWays()[startIndex][koniecIndex].equals(id+"")){
            return true;
        }
        else
            return false;
    }
    public void run(){
        Thread thread = new Thread(){
            public void run(){
                try {
                    System.out.println("Pociąg " + id + " zaczął się ruszać!");
                    int startIndex = Trasa.getStacja().indexOf(budowanieStacji);
                    int koniecIndex = Trasa.getStacja().indexOf(trasa.get(trasa.indexOf(budowanieStacji)+1));
                    Trasa.getWays()[startIndex][koniecIndex] = id+"";
                    while (true) {
                        odleglosc += obliczenieOdleglosci();
                        sleep(1000);
                        zmianaPredkosci();
                        if(zmienaAktualnejStacji()){
                            if(budowanieStacji.equals(stacjaDocelowa)){
                              String temp = stacjaStartowa;
                                stacjaStartowa = stacjaDocelowa;
                                stacjaDocelowa = temp;
                                budowanieStacji = stacjaStartowa;
                                odleglosc = 0;
                                Random random = new Random();
                                trasa = Trasa.generateTrasa(stacjaStartowa, stacjaDocelowa,random.nextInt(10)+3);
                                sleep(30000);
                            }
                            else{
                                while(!checkTrasaIsFree()){
                                    sleep(1000);
                                }
                                sleep(2000);
                            }
                        }
                    }
                }

                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
    private double obliczenieOdleglosci(){
        return this.przedkosc * 0.5;
    }
    private double obliczenieWagiProduktu(){
        double waga=0;
        for(Wagon wagon : wagons){
            if(wagon instanceof wagBagazPoczt)
            {
                waga += ((wagBagazPoczt) wagon).getWagaProdukt();
            }
            else if(wagon instanceof wagTowarPodst)
            {
                waga += ((wagTowarPodst) wagon).getWagaProdukt();
            }
            else if(wagon instanceof wagBagazPoczt){
                waga += ((wagBagazPoczt) wagon).getWagaProdukt();
            }
        }
        return waga;
    }
    private double obliczenieLiczbyPasazerow(){
        double count=0;
        for(Wagon wagon : wagons){
            if(wagon instanceof wagPasazerski)
            {
                count += ((wagPasazerski) wagon).getLiczbaMiejsc();
            }
            else
                if(wagon instanceof wagRestauracyjny){
                count += ((wagRestauracyjny) wagon).getLiczbaMiejsc();
            }
        }
        return count;
    }
    @Override
    public String toString() {
        return  "\nID=" + id +
                "\nPrzędkość=" + przedkosc +
                "\nNazwa='" + nazwa + '\'' +
                "\nBudowanie Stacji='" + budowanieStacji + '\'' +
                "\nStacja Startowa='" + stacjaStartowa + '\'' +
                "\nStacja Docelowa='" + stacjaDocelowa + '\'' +
                "\nLiczba Wagonów=" + liczbaWagon +
                "\nMax Waga=" + maxWaga +
                "\nLiczba ElWagon=" + liczbaElWagon +
                "\nTrasa=" + trasa +
                "\nOdlegwość=" + odleglosc +
                "\nWagony=" + wagons +
                "\nCała Odległość = " + Trasa.obliczenieOdleglosci(trasa)+
                "\nWagons Count = " + wagons.size()+
                "\nProcent Całej Trasy = " + getProcentCalejTrasy()+
                "\nProcent Miedzy Stacjami= " + getProcentMiedzyStacjami()+
                "\nWaga Produktu = " + obliczenieWagiProduktu() +
                "\nLiczba Pasazerów = " + obliczenieLiczbyPasazerow();
    }
}
