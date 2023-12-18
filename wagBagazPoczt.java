package com.railway.model.wagon;

import com.railway.model.asbstract.Wagon;

public class wagBagazPoczt extends Wagon {
    private double wagaProdukt;
    private String typProduktu;

    public wagBagazPoczt(String nadawca, boolean zabezpieczenia, double wagaNetto, double wagaBrutto, double wagaProdukt, String typProduktu) {
        super(nadawca, zabezpieczenia, wagaNetto, wagaBrutto);
        this.wagaProdukt = wagaProdukt;
        this.typProduktu = typProduktu;
    }

    public double getWagaProdukt() {
        return wagaProdukt;
    }

    public void setWagaProdukt(double wagaProdukt) {
        this.wagaProdukt = wagaProdukt;
    }

    public String getTypProduktu() {
        return typProduktu;
    }

    public void setTypProduktu(String typProduktu) {
        this.typProduktu = typProduktu;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon bagażowo-pocztowy{" +
                "wagaProdukt=" + wagaProdukt +
                ", typProduktu='" + typProduktu + '\'' +
                '}';
    }
}
