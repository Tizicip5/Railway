package com.railway.model.wagon;

import com.railway.model.asbstract.Wagon;

public class wagPocztowy extends Wagon {
    private int liczbaPaczek;
    private boolean poloczenieEl;

    public wagPocztowy(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, int liczbaPaczek, boolean poloczenieEl) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto);
        this.liczbaPaczek = liczbaPaczek;
        this.poloczenieEl = poloczenieEl;
    }

    public int getLiczbaPaczek() {
        return liczbaPaczek;
    }

    public void setLiczbaPaczek(int liczbaPaczek) {
        this.liczbaPaczek = liczbaPaczek;
    }

    public boolean isPoloczenieEl() {
        return poloczenieEl;
    }

    public void setPoloczenieEl(boolean poloczenieEl) {
        this.poloczenieEl = poloczenieEl;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon pocztowy{" +
                "liczbaPaczek=" + liczbaPaczek +
                ", poloczenieEl=" + poloczenieEl +
                '}';
    }
}
