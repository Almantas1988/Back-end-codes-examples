package java5;

import java.io.*;

public class Uzdaviniai {
    public static void main(String[] args) {
        String failoKelias = new File("").getAbsolutePath()
                + "/src/java5/duomenys.txt";
        String rezultatuKelias = new File("").getAbsolutePath()
                + "/src/java5/rezultatai.txt";
        Integer[] skaiciai = null;

        String duomenuTekstas = "";
        try (BufferedReader skaitytuvas = new BufferedReader(new FileReader(failoKelias))) {
            String eilute = skaitytuvas.readLine();
            String[] eilReiksmes = eilute.split(" ");
            Integer eiluciuKiekis = Integer.parseInt(eilReiksmes[0]);
            Integer elementuKiekis = Integer.parseInt(eilReiksmes[1]);
            skaiciai = new Integer[elementuKiekis];

            Integer indeksas = 0;
            for (int i = 0; i < eiluciuKiekis; i++) {
                eilute = skaitytuvas.readLine();
                eilReiksmes = eilute.split(" ");
                for (int j = 0; j < eilReiksmes.length; j++) {
                    skaiciai[indeksas] = Integer.parseInt(eilReiksmes[j]);
                    indeksas++;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } catch (Exception e) {
            System.out.println(e);
        }

        try (BufferedWriter spausdinimas = new BufferedWriter(new FileWriter(rezultatuKelias))) {
            // pirma uzduotis min max

            int pos_min, temp;

            for (int i = 0; i < skaiciai.length - 1; i++) {
                pos_min = i;

                for (int j = i + 1; j < skaiciai.length; j++) {
                    if (skaiciai[j] < skaiciai[pos_min]) {
                        pos_min = j;
                    }
                }

                if (pos_min != i) {
                    temp = skaiciai[i];
                    skaiciai[i] = skaiciai[pos_min];
                    skaiciai[pos_min] = temp;
                }
            }

            for (int i = 0; i < skaiciai.length; i++) {
                spausdinimas.write(skaiciai[i] + " ");
            }

            // antra uzduotis vidurkis

            Integer suma = 0;

            for (int i = 0; i < skaiciai.length; i++) {
                suma += skaiciai[i];
            }

            Integer kiekis = skaiciai.length;
            Double vidurkis = (double) suma / kiekis;

            spausdinimas.write("\n" + "Vidurkis " + vidurkis + "\n");

            // trecia uzduotis salinimas maziau uz vidurki

            Integer mazesnieji = 0;
            for (int i = 0; i < skaiciai.length; i++ ) {
                 if (skaiciai[i] < vidurkis) {
                     mazesnieji++;
                 }
            }

            Integer[] mazesniSkaiciai = new Integer[skaiciai.length - mazesnieji];
            Integer index = 0;
            for (int i = 0; i < skaiciai.length; i++) {
                if (skaiciai[i] < vidurkis) {
                    continue; }
                    mazesniSkaiciai[index++] = skaiciai[i];
            }

            for (int i = 0; i < mazesniSkaiciai.length; i++) {
                spausdinimas.write(mazesniSkaiciai[i] + " ");
            }

            spausdinimas.write("\n");

            // ketvirta uzduotis neigiami skaiciai

            Integer neigiami = 0;
            for (int i = 0; i < skaiciai.length; i++ ) {
                if (skaiciai[i] < 0) {
                    neigiami++;
                }
            }

            Integer[] beNeigiamu = new Integer[skaiciai.length - neigiami];
            Integer index2 = 0;
            for (int i = 0; i < skaiciai.length; i++) {
                if (skaiciai[i] < 0) {
                    continue; }
                beNeigiamu[index2++] = skaiciai[i];
            }

            for (int i = 0; i < beNeigiamu.length; i++) {
                spausdinimas.write(beNeigiamu[i] + " ");
            }

            spausdinimas.write("\n");

            // penkta uzduotis min ir max reiksmes

            Integer max = 0;
            for (int i = 1; i < skaiciai.length; i++)
            {
                if (skaiciai[i] > max)
                {
                    max = skaiciai[i];
                }
            }

            spausdinimas.write("Didžiausia reiksmė = " + max + " ");

            Integer min = 0;
            for (int i = 0; i < skaiciai.length; i++)
            {
                if (skaiciai[i] < min)
                {
                    min = skaiciai[i];
                }
            }

            spausdinimas.write("Mažiausia reiksmė = " + min);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}