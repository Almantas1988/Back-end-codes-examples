package java23;

public abstract class Preke {
    private Integer prekesID;
    private String prekesTipas;
    private String prekesPavadinimas;
    private Integer prekesKiekis;
    private Double vienetoKaina;

    public Preke(Integer prekesID, String prekesTipas, String prekesPavadinimas, Integer prekesKiekis, Double vienetoKaina) {
        this.prekesID = prekesID;
        this.prekesTipas = prekesTipas;
        this.prekesPavadinimas = prekesPavadinimas;
        this.prekesKiekis = prekesKiekis;
        this.vienetoKaina = vienetoKaina;
    }

    public String toString () {
        return getPrekesID() + " " + getPrekesTipas() + " " + getPrekesPavadinimas() + " " +
                getPrekesKiekis() + " " + getVienetoKaina();
    }

    public Integer getPrekesID() {
        return prekesID;
    }

    public String getPrekesTipas() {
        return prekesTipas;
    }

    public String getPrekesPavadinimas() {
        return prekesPavadinimas;
    }

    public Integer getPrekesKiekis() {
        return prekesKiekis;
    }

    public Double getVienetoKaina() {
        return vienetoKaina;
    }

    public void setPrekesID(Integer prekesID) {
        this.prekesID = prekesID;
    }

    public void setPrekesTipas(String prekesTipas) {
        this.prekesTipas = prekesTipas;
    }

    public void setPrekesPavadinimas(String prekesPavadinimas) {
        this.prekesPavadinimas = prekesPavadinimas;
    }

    public void setPrekesKiekis(Integer prekesKiekis) {
        this.prekesKiekis = prekesKiekis;
    }

    public void setVienetoKaina(Double vienetoKaina) {
        this.vienetoKaina = vienetoKaina;
    }

}


