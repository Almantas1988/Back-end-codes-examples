package java23;

public class Skalbykle extends Preke{
    private String talpa;

    public Skalbykle(Integer prekesID, String prekesTipas, String prekesPavadinimas,
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
