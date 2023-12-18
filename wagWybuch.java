package com.railway.model.wagon;

public class wagWybuch extends wagTowarCiezki {
    private boolean klimatyzacja;

    public wagWybuch(String nadawca, boolean bezpieczenstwo, double wagaNetto, double wagaBrutto, String typProduktu, boolean klimatyzacja) {
        super(nadawca, bezpieczenstwo, wagaNetto, wagaBrutto, typProduktu);
        this.klimatyzacja = klimatyzacja;
    }

    public boolean isKlimatyzacja() {
        return klimatyzacja;
    }

    public void setKlimatyzacja(boolean klimatyzacja) {
        this.klimatyzacja = klimatyzacja;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWagon wybuchowy{" +
                "klimatyzacja=" + klimatyzacja +
                '}';
    }
}
