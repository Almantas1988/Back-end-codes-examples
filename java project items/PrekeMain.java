package java23;

import java.io.*;
import java.util.*;

public class PrekeMain {
    public static void main(String[] args) {
        String duomenuFailas = new File("").getAbsolutePath()
                + "/src/java23/prekes.txt";

        List<Preke> prekiuDuomenys = new ArrayList<>();
        skaityti(duomenuFailas, prekiuDuomenys);

        System.out.println("1 veiksmas: Rasti prekę, kurios vienetų mažiausiai");
        System.out.println("2 veiksmas: Rasti prekę, kurios vienetų daugiausiai");
        System.out.println("3 veiksmas: Išfiltruoti prekes pagal tipą");
        System.out.println("4 veiksmas: Pridėti prekę prie esančio sąrašo");
        System.out.println("5 veiksmas: Ištrinti prekę pagal prekės ID");
        System.out.println("6 veiksmas: Redaguoti prekę pagal prekės ID");

        meniu(prekiuDuomenys);

        maziausiaisPrekiuKiekis(prekiuDuomenys);
        didziausiasPrekiuKiekis(prekiuDuomenys);

    }

    // sukurtas meniu

    public static void meniu(List<Preke> prekiuDuomenys) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite veiksma nuo 1 iki 6:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Maziausio kiekio preke " + maziausiaisPrekiuKiekis(prekiuDuomenys));
                choice = scanner.nextInt();

            case 2:
                System.out.println("Didziausio kiekio preke " + didziausiasPrekiuKiekis(prekiuDuomenys));
                choice = scanner.nextInt();

            case 3:
                String atfiltruotaPreke = new File("").getAbsolutePath()
                        + "/src/java23/atfiltruotosPrekes.txt";
                atfiltruotuPrekiuIrasymas(atfiltruotaPreke, pagalTipa(prekiuDuomenys));
                System.out.println(pagalTipa(prekiuDuomenys));

                choice = scanner.nextInt();

            case 4:
                pridetiNaujaPreke(prekiuDuomenys);
                String pridetaPreke = new File("").getAbsolutePath()
                        + "/src/java23/prekes.txt";
                pridetosPrekesIrasymas(pridetaPreke, prekiuDuomenys);
                choice = scanner.nextInt();

            case 5:
                System.out.println("Iveskite prekes ID:");
                Integer ID = scanner.nextInt();
                pasalintiPrekePagalID(prekiuDuomenys, ID);
                System.out.println(prekiuDuomenys.toString() + "\n");
                String pasalintaPreke = new File("").getAbsolutePath()
                        + "/src/java23/prekes.txt";
                istrintosPrekesIrasymas(pasalintaPreke, prekiuDuomenys);
                choice = scanner.nextInt();

            case 6:
                System.out.println("Pastikrinkite ar preke egsiztuoja");
                Integer ID2 = scanner.nextInt();
                redaguotiPreke(prekiuDuomenys, ID2);
                System.out.println(prekiuDuomenys.toString() + "\n");
                String redaguotaPreke = new File("").getAbsolutePath()
                        + "/src/java23/prekes.txt";
                redaguotosPrekesIrasymas(redaguotaPreke, prekiuDuomenys);
                choice = scanner.nextInt();

            default:
                System.out.println(prekiuDuomenys);
        }
    }

    // meniu pabaiga

    // 1 veiksmas: Maziausias prekiu kiekis

    public static List<Preke> maziausiaisPrekiuKiekis(List<Preke> prekiuDuomenys) {
        List<Preke> maziausiai = new ArrayList<>();
        Integer minKiekis = 20;
        Integer objektas = 0;

        for (int i = 0; i < prekiuDuomenys.size(); i++) {
            if (prekiuDuomenys.get(i).getPrekesKiekis() < minKiekis) {
                minKiekis = prekiuDuomenys.get(i).getPrekesKiekis();
                objektas = i;

            }
        }
        maziausiai.add(prekiuDuomenys.get(objektas));
        return maziausiai;
    }

    // 1 veiksmo pabaiga

    // 2 veiksmas: Didziausias prekiu kiekis

    public static List<Preke> didziausiasPrekiuKiekis(List<Preke> prekiuDuomenys) {
        List<Preke> daugiausiai = new ArrayList<>();
        Integer maxKiekis = 0;
        Integer objektas = 0;

        for (int i = 0; i < prekiuDuomenys.size(); i++) {
            if (prekiuDuomenys.get(i).getPrekesKiekis() > maxKiekis) {
                maxKiekis = prekiuDuomenys.get(i).getPrekesKiekis();
                objektas = i;

            }
        }
        daugiausiai.add(prekiuDuomenys.get(objektas));
        return daugiausiai;
    }

    // 2 veiksmo pabaiga

    // 3 veiksmas: prekiu filtravimas pagal tipa

    public static List<Preke> pagalTipa(List<Preke> prekiuDuomenys) {
        List<Preke> prekesPagalTipa = new ArrayList<>();
        for (int i = 0; i < prekiuDuomenys.size(); i++) {
            if (prekiuDuomenys.get(i).getPrekesTipas().equals("televizoriai")) {
                prekesPagalTipa.add(prekiuDuomenys.get(i));
            }
        }
        return prekesPagalTipa;
    }

    public static void atfiltruotuPrekiuIrasymas(String atrinktaPreke, List<Preke> prekesPagalTipa) {
        try (BufferedWriter spausdinimas = new BufferedWriter(new FileWriter(atrinktaPreke))) {

            for (Preke preke : prekesPagalTipa) {
                spausdinimas.write(preke.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3 veiksmo pabaiga

    // 4 veiksmas: naujos prekes pridejimas

    public static void pridetiNaujaPreke(List<Preke> prekiuDuomenys) {

        Scanner skaitytuvas = new Scanner(System.in);
        System.out.println("Pasirinkite koki tipa norite prideti");
        System.out.println("1 - televizorius, 2 - nesiojamas kompiuteris, 3 - skalbykle, 4 - dziovykle");
        Integer pasirinkimas = skaitytuvas.nextInt();

        String tipas;
        System.out.println("Iveskite pavadinima");
        String pavadinimas = skaitytuvas.next();
        System.out.println("Iveskite kieki");
        Integer kiekis = skaitytuvas.nextInt();
        System.out.println("Iveskite vnt. kaina");
        Double vntKaina = skaitytuvas.nextDouble();

        if (pasirinkimas == 1) {
            tipas = "televizorius";
            System.out.println("Iveskite televizoriaus technologija");
            String technologija = skaitytuvas.next();
            System.out.println("Iveskite televizoriaus raiska");
            String raiska = skaitytuvas.next();
            Televizoriai naujasTelevizorius = new Televizoriai(1, tipas, pavadinimas, kiekis, vntKaina,
                    technologija, raiska);
            prekiuDuomenys.add(naujasTelevizorius);
            System.out.println(naujasTelevizorius.toString());

        } else if (pasirinkimas == 2) {
            tipas = "nesiojamas kompiuteris";
            System.out.println("Iveskite kompiuterio procesoriu");
            String procesorius = skaitytuvas.next();
            System.out.println("Iveskite kompiuterio RAM atminties dydi");
            String ramAtmintis = skaitytuvas.next();
            System.out.println("Iveskite kompiuterio disko talpa");
            String diskoTalpa = skaitytuvas.next();
            NesiojamasKompiuteris naujasNesiojamasKompiuturis = new NesiojamasKompiuteris(1, tipas,
                    pavadinimas, kiekis, vntKaina,
                    procesorius, ramAtmintis, diskoTalpa);
            prekiuDuomenys.add(naujasNesiojamasKompiuturis);
            System.out.println(naujasNesiojamasKompiuturis.toString());

        } else if (pasirinkimas == 3) {
            tipas = "skalbykle";
            System.out.println("Iveskite skalbykles talpa");
            String talpa = skaitytuvas.next();
            Skalbykle naujaSkalbykle = new Skalbykle(1, tipas,
                    pavadinimas, kiekis, vntKaina, talpa);
            prekiuDuomenys.add(naujaSkalbykle);
            System.out.println(naujaSkalbykle.toString());
        } else if (pasirinkimas == 4) {
            tipas = "dziovykle";
            System.out.println("Iveskite dziovykles talpa");
            String talpa = skaitytuvas.next();
            Integer ID = prekiuDuomenys.get(prekiuDuomenys.size() - 1).getPrekesID() + 1;
            Skalbykle naujaDziovykle = new Skalbykle(ID, tipas,
                    pavadinimas, kiekis, vntKaina, talpa);
            prekiuDuomenys.add(naujaDziovykle);
            System.out.println(naujaDziovykle.toString());
        }
    }

    public static void pridetosPrekesIrasymas(String prideta, List<Preke> pridetaPreke) {
        try (BufferedWriter spausdinimas = new BufferedWriter(new FileWriter(prideta))) {
            for (Preke preke : pridetaPreke) {
                spausdinimas.write(preke.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4 veiksmo pabaiga

    // 5 veiksmas: prekes istrynimas pagal ID

    public static void pasalintiPrekePagalID(List<Preke> prekiuDuomenys, Integer ID) {
        for (int i = 0; i < prekiuDuomenys.size(); i++) {
            if (prekiuDuomenys.get(i).getPrekesID().equals(ID)) {
                prekiuDuomenys.remove(i);
            }
        }
    }

    public static void istrintosPrekesIrasymas(String atrinktasID, List<Preke> istrintaPreke) {
        try (BufferedWriter spausdinimas = new BufferedWriter(new FileWriter(atrinktasID))) {
            for (Preke preke : istrintaPreke) {
                spausdinimas.write(preke.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 5 veiksmo pabaiga

    // 6 veiksmas: prekes redagavimas pagal ID

    public static List<Preke> redaguotiPreke(List<Preke> prekiuDuomenys, Integer ID2) {
        List<Preke> redaguotiPreke = new ArrayList<>();
        Scanner skaitytuvas = new Scanner(System.in);
        System.out.println("Pasirinkite prekes ID kuria norite redaguoti");
        Integer pasirinkimas = skaitytuvas.nextInt();
        Integer prekePagalIDIndeksas = gautiPrekePagalID(prekiuDuomenys, pasirinkimas);
        if (prekePagalIDIndeksas != null) {
            System.out.println("Iveskite nauja pavadinima");
            String pavadinimas = skaitytuvas.next();
            prekiuDuomenys.get(prekePagalIDIndeksas).setPrekesPavadinimas(pavadinimas);

            Integer kiekis = skaiciuScannerisKiekiui("Iveskite nauja kieki", skaitytuvas);
            prekiuDuomenys.get(prekePagalIDIndeksas).setPrekesKiekis(kiekis);

            Double kaina = skaiciuScannerisKainai("Iveskite nauja kaina", skaitytuvas);
            prekiuDuomenys.get(prekePagalIDIndeksas).setVienetoKaina(kaina);

            System.out.println(prekiuDuomenys);
        } else {
            System.out.println("Tokios prekes nera");
        }

        return redaguotiPreke;
    }

    public static Integer gautiPrekePagalID(List<Preke> prekiuDuomeys, Integer id) {
        for (int i = 0; i < prekiuDuomeys.size(); i++) {
            if (prekiuDuomeys.get(i).getPrekesID().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public static Integer skaiciuScannerisKiekiui(String zinute, Scanner skaitytuvas) {
        System.out.println(zinute);
        Integer skaicius = null;
        try {
            skaicius = skaitytuvas.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Ivestas blogas formatas");
            skaitytuvas.next();
            skaicius = skaiciuScannerisKiekiui(zinute, skaitytuvas);
        }
        return skaicius;
    }

    public static Double skaiciuScannerisKainai(String zinute, Scanner skaitytuvas) {
        System.out.println(zinute);
        Double skaicius = null;
        try {
            skaicius = skaitytuvas.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Ivestas blogas formatas");
            skaitytuvas.next();
            skaicius = skaiciuScannerisKainai(zinute, skaitytuvas);
        }
        return skaicius;
    }

    public static void redaguotosPrekesIrasymas(String redaguota, List<Preke> redaguotaPreke) {
        try (BufferedWriter spausdinimas = new BufferedWriter(new FileWriter(redaguota))) {
            for (Preke preke : redaguotaPreke) {
                spausdinimas.write(preke.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 6 veiksmo pabaiga

    // skaitymas is duomenu txt failo

    public static void skaityti(String duomenuFailas, List<Preke> prekiuDuomenys) {

        String[] eilprekiuDuomenys = null;
        try (BufferedReader br = new BufferedReader(new FileReader(duomenuFailas))) {
            String eilute = br.readLine();

            while (eilute != null) {
                eilprekiuDuomenys = eilute.split(" ");

                Preke objektas;

                Integer id = Integer.parseInt(eilprekiuDuomenys[0]);
                if (eilprekiuDuomenys[1].equals("televizoriai")) {
                    objektas = new Televizoriai(id, eilprekiuDuomenys[1], eilprekiuDuomenys[2],
                            Integer.parseInt(eilprekiuDuomenys[3]), Double.parseDouble(eilprekiuDuomenys[4]),
                            eilprekiuDuomenys[5], eilprekiuDuomenys[6]);
                } else if (eilprekiuDuomenys[1].equals("nesiojamas-kompiuteris")) {
                    objektas = new NesiojamasKompiuteris(id, eilprekiuDuomenys[1], eilprekiuDuomenys[2],
                            Integer.parseInt(eilprekiuDuomenys[3]), Double.parseDouble(eilprekiuDuomenys[4]),
                            eilprekiuDuomenys[5], eilprekiuDuomenys[6], eilprekiuDuomenys[7]);
                } else if (eilprekiuDuomenys[1].equals("skalbykle")) {
                    objektas = new Skalbykle(id, eilprekiuDuomenys[1], eilprekiuDuomenys[2],
                            Integer.parseInt(eilprekiuDuomenys[3]), Double.parseDouble(eilprekiuDuomenys[4]),
                            eilprekiuDuomenys[5]);
                } else {
                    objektas = new Dziovykle(id, eilprekiuDuomenys[1], eilprekiuDuomenys[2],
                            Integer.parseInt(eilprekiuDuomenys[3]), Double.parseDouble(eilprekiuDuomenys[4]),
                            eilprekiuDuomenys[5]);
                }

                prekiuDuomenys.add(objektas);

                eilute = br.readLine();

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    // skaitymo pabaiga
}
