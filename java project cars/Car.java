package java20;

import java.util.Arrays;

public class Masina {
    private String gamintojas;
    private String modelis;
    private Integer metai;
    private Integer kaina;
    private Double variklioTuris;
    private String kuroTipas;

    public Masina(String gamintojas, String modelis, Integer metai
            , Integer kaina, Double variklioTuris, String kuroTipas) {
        this.gamintojas = gamintojas;
        this.modelis = modelis;
        this.metai = metai;
        this.kaina = kaina;
        this.variklioTuris = variklioTuris;
        this.kuroTipas = kuroTipas;
    }

    public String toString() {
        return "Gamtintojas: " + gamintojas + " Modelis: " + modelis + " Metai: " + metai + " Kaina " +
                kaina + " Variklio turis " + variklioTuris + " Kuro tipas " + kuroTipas;
    }

    public void setGamintojas(String gamintojas) {
        this.gamintojas = gamintojas;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public void setMetai(Integer metai) {
        this.metai = metai;
    }

    public void setKaina(Integer kaina) {
        this.kaina = kaina;
    }

    public void setVariklioTuris(Double variklioTuris) {
        this.variklioTuris = variklioTuris;
    }

    public void setKuroTipas(String kuroTipas) {
        this.kuroTipas = kuroTipas;
    }

    public String getGamintojas() {
        return gamintojas;
    }

    public String getModelis() {
        return modelis;
    }

    public Integer getMetai() {
        return metai;
    }

    public Integer getKaina() {
        return kaina;
    }

    public Double getVariklioTuris() {
        return variklioTuris;
    }

    public String getKuroTipas() {
        return kuroTipas;
    }
}
