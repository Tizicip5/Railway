package com.railway.model.wagon;

public class wagGaz extends wagTowarPodst {
    private String typGaz;

    public wagGaz(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, double wagaProdukt, String typProduktu, String typGaz) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto, wagaProdukt, typProduktu);
        this.typGaz = typGaz;
    }

    public String getTypGaz() {
        return typGaz;
    }

    public void setTypGaz(String typGaz) {
        this.typGaz = typGaz;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon na materiały gazowe{" +
                "typGaz='" + typGaz + '\'' +
                '}';
    }
}

