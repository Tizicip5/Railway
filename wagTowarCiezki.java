package com.railway.model.wagon;

import com.railway.model.asbstract.Wagon;

public class wagTowarCiezki extends Wagon {
    private String typProduktu;

    public wagTowarCiezki(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, String typProduktu) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto);
        this.typProduktu = typProduktu;
    }

    public String getTypProduktu() {
        return typProduktu;
    }

    public void setTypProduktu(String typProduktu) {
        this.typProduktu = typProduktu;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon towarowy ciezki {" +
                "typProduktu='" + typProduktu + '\'' +
                '}';
    }
}
