package java23;

public class Televizoriai extends Preke {
    private String technologija;
    private String raiska;

    public Televizoriai(Integer prekesID, String prekesTipas, String prekesPavadinimas,
                        Integer prekesKiekis, Double vienetoKaina, String technologija, String raiska) {
        super(prekesID, prekesTipas, prekesPavadinimas, prekesKiekis, vienetoKaina);
        this.technologija = technologija;
        this.raiska = raiska;
    }

    @Override
    public String toString() {
        return super.toString() + " " + technologija + " " + raiska + '\n';
    }

    public String getTechnologija() {
        return technologija;
    }

    public String getRaiska() {
        return raiska;
    }

    public void setTechnologija(String technologija) {
        this.technologija = technologija;
    }

    public void setRaiska(String raiska) {
        this.raiska = raiska;
    }
}


