package com.railway.model.wagon;

public class wagMatToksyczn extends wagTowarCiezki {
    private int dangerKlas;

    public wagMatToksyczn(String nadawca, boolean zabezpieczenia, double wagaNetto, double wagaBrutto, String typProduktu, int dangerKlas) {
        super(nadawca, zabezpieczenia, wagaNetto, wagaBrutto, typProduktu);
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
        return super.toString()+"\n Wagon na materiały toksyczne {" +
                "dangerKlas=" + dangerKlas +
                '}';
    }
}
