package com.railway.model.wagon;

import com.railway.model.asbstract.Wagon;

public class wagPasazerski extends Wagon {
    private int liczbaMiejsc;
    private boolean poloczenieEl;

    public wagPasazerski(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, int liczbaMiejsc, boolean poloczenieEl) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto);
        this.liczbaMiejsc = liczbaMiejsc;
        this.poloczenieEl = poloczenieEl;
    }

    public int getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(int liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public boolean isPoloczenieEl() {
        return poloczenieEl;
    }

    public void setPoloczenieEl(boolean poloczenieEl) {
        this.poloczenieEl = poloczenieEl;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon pasażerski{" +
                "liczbaMiejsc=" + liczbaMiejsc +
                ", poloczenieEl" + poloczenieEl +
                '}';
    }
}
