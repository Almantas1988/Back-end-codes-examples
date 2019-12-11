package java23;

public class NesiojamasKompiuteris extends Preke{
    private String procesoruius;
    private String ramAtmintis;
    private String diskoTalpa;

    public NesiojamasKompiuteris(Integer prekesID, String prekesTipas, String prekesPavadinimas,
                                 Integer prekesKiekis, Double vienetoKaina, String procesoruius,
                                 String ramAtmintis, String diskoTalpa) {
        super(prekesID, prekesTipas, prekesPavadinimas, prekesKiekis, vienetoKaina);
        this.procesoruius = procesoruius;
        this.ramAtmintis = ramAtmintis;
        this.diskoTalpa = diskoTalpa;
    }

    @Override
    public String toString() {
        return super.toString() + " " + procesoruius + " " + ramAtmintis + " " +
                procesoruius + '\n';
    }

    public String getProcesoruius() {
        return procesoruius;
    }

    public String getRamAtmintis() {
        return ramAtmintis;
    }

    public String getDiskoTalpa() {
        return diskoTalpa;
    }

    public void setProcesoruius(String procesoruius) {
        this.procesoruius = procesoruius;
    }

    public void setRamAtmintis(String ramAtmintis) {
        this.ramAtmintis = ramAtmintis;
    }

    public void setDiskoTalpa(String diskoTalpa) {
        this.diskoTalpa = diskoTalpa;
    }
}
