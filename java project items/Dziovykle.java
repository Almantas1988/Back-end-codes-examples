package java23;

public class Dziovykle extends Preke {
    private String talpa;

    public Dziovykle(Integer prekesID, String prekesTipas, String prekesPavadinimas,
                     Integer prekesKiekis, Double vienetoKaina, String talpa) {
        super(prekesID, prekesTipas, prekesPavadinimas, prekesKiekis, vienetoKaina);
        this.talpa = talpa;
    }

    @Override
    public String toString() {
        return super.toString() + " " + talpa + '\n';
    }

    public String getTalpa() {
        return talpa;
    }

    public void setTalpa(String talpa) {
        this.talpa = talpa;
    }
}
