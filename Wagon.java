package com.railway.model.asbstract;

import java.util.UUID;

public abstract class Wagon {
    private String numer;
    private String nadawca;
    private boolean zabezpieczenia;
    private double wagaNetto;
    private double wagaBrutto;

    public Wagon(String nadawca, boolean zabezpieczenia, double wagaNetto, double wagaBrutto) {
        this.numer = UUID.randomUUID().toString();
        this.nadawca = nadawca;
        this.zabezpieczenia = zabezpieczenia;
        this.wagaNetto = wagaNetto;
        this.wagaBrutto = wagaBrutto;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getNadawca() {
        return nadawca;
    }

    public void setNadawca(String nadawca) {
        this.nadawca = nadawca;
    }

    public boolean isZabezpieczenia() {
        return zabezpieczenia;
    }

    public void setZabezpieczenia(boolean zabezpieczenia) {
        this.zabezpieczenia = zabezpieczenia;
    }

    public double getWagaNetto() {
        return wagaNetto;
    }

    public void setWagaNetto(double wagaNetto) {
        this.wagaNetto = wagaNetto;
    }

    public double getWagaBrutto() {
        return wagaBrutto;
    }

    public void setWagaBrutto(double wagaBrutto) {
        this.wagaBrutto = wagaBrutto;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "numer='" + numer + '\'' +
                ", nadawca='" + nadawca + '\'' +
                ", bezpieczenstwo=" + zabezpieczenia +
                ", wagaNetto=" + wagaNetto +
                ", wagaBrutto=" + wagaBrutto +
                '}';
    }
}
