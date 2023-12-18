package com.railway.model.wagon;

public class wagCieklMatToks extends wagTowarCiezki {
    private int dangerKlas;

    public wagCieklMatToks(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, String typProduktu, int dangerKlas) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto, typProduktu);
        this.dangerKlas = dangerKlas;
    }

    public int getDangerKlas() {
        return dangerKlas;
    }

    public void setDangerKlas(int dangerKlas) {
        this.dangerKlas = dangerKlas;
    }

    @Override
    public String toString() {
        return super.toString()+"\n Wagon na ciekłe materiały toksyczne{" +
                "dangerKlas=" + dangerKlas +
                '}';
    }
}
