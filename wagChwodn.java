package com.railway.model.wagon;

public class wagChwodn extends wagTowarPodst {
    private int temperatura;
    private boolean elPoloczenie;

    public wagChwodn(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, double wagaProdukt, String typProduktu, int temperatura, boolean poloczenieElektroniczne) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto, wagaProdukt, typProduktu);
        this.temperatura = temperatura;
        this.elPoloczenie = poloczenieElektroniczne;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isElPoloczenie() {
        return elPoloczenie;
    }

    public void setElPoloczenie(boolean elPoloczenie) {
        this.elPoloczenie = elPoloczenie;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon chłodniczy{" +
                "temperatura=" + temperatura +
                ", połączenie elektroniczne=" + elPoloczenie +
                '}';
    }
}
