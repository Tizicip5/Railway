package com.railway.model.wagon;

import com.railway.model.asbstract.Wagon;

public class wagTowarPodst extends Wagon {
    private double wagaProdukt;
    private String typProduktu;

    public wagTowarPodst(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, double wagaProdukt, String typProduktu) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto);
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
        return super.toString()+"\nWagon towarowy podstawowy{" +
                "wagaProdukt=" + wagaProdukt +
                ", typProdukt='" + typProduktu + '\'' +
                '}';
    }
}
