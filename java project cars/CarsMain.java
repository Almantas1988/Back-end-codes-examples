package java20;

import java9.Darbuotojas;

import javax.swing.*;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.io.*;
import java.util.Arrays;

public class CarsMain {
    public static void main(String[] args) {
        String duomenuFailoPath = new File("").getAbsolutePath()
                + "/src/java20/Duomenys.txt";
        skaityti(duomenuFailoPath);
        Car[] masinos = skaityti(duomenuFailoPath);
        spausdinti(masinos);

        System.out.println("Seniausia Car: " + seniausiaCar(masinos));
        System.out.println("Naujausia Car: " + naujausiaCar(masinos));

        System.out.println("Naujesnes masinos nei 2010: " + naujesnesNei2010(masinos));

        System.out.println(Arrays.toString(volkswagenai(masinos)));

    }

    public static Car[] skaityti(String duomenuFailoPath) {

        Car[] masinos = new Car[10];

        String rezultatuFailoPath = new File("").getAbsolutePath()
                + "/src/java20/Rezultatai.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(duomenuFailoPath))) {
            String eilute = br.readLine();

            Integer indeksas = 0;
            while (eilute != null) {
                String[] eilDuomenys = eilute.split(" ");

                String gamintojas = eilDuomenys[0];
                String modelis = eilDuomenys[1];
                Integer metai = Integer.parseInt(eilDuomenys[2]);
                Integer kaina = Integer.parseInt(eilDuomenys[3]);
                Double turis = Double.parseDouble(eilDuomenys[4]);
                String kuras = eilDuomenys[5];
                Car objektas = new Car(gamintojas, modelis, metai, kaina, turis, kuras);
                masinos[indeksas] = objektas;
                indeksas++;
                eilute = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Failas nerastas");
        } catch (Exception e) {
            System.out.println("something else went wrong");
        }
        return masinos;
    }

    public static void spausdinti(Car[] masinos) {
        for (int i = 0; i < masinos.length; i++) {
            System.out.println(masinos[i]);
        }
    }

    public static void rasyti(String failas, Car[] masinos) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(failas))) {
            for (int i = 0; i < masinos.length; i++) {
                output.write(masinos[i].toString() + "\n");

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Car seniausiaCar(Car[] masinos) {
        Integer minMetai = 2500;
        Car objektas = null;
        for (int i = 0; i < masinos.length; i++) {
            if (masinos[i].getMetai() < minMetai) {
                minMetai = masinos[i].getMetai();
                objektas = masinos[i];
            }
        }
        return objektas;
    }

    public static Car naujausiaCar(Car[] masinos) {
        Integer minMetai = 0;
        Car objektas = null;
        for (int i = 0; i < masinos.length; i++) {
            if (masinos[i].getMetai() > minMetai) {
                minMetai = masinos[i].getMetai();
                objektas = masinos[i];
            }
        }
        return objektas;
    }

    public static Car naujesnesNei2010(Car[] masinos) {
        Integer metai = 2010;
        Car objektas = null;
        for (int i = 0; i < masinos.length; i++) {
            if (masinos[i].getMetai() > metai) {
                metai = masinos[i].getMetai();
                objektas = masinos[i];
            }
        }
        return objektas;
    }


    public static Car[] volkswagenai(Car[] masinos) {
        Car[] volkswagenai = new Car[0];
        for (int i = 0; i < masinos.length; i++) {
            if (masinos[i].getGamintojas().equals("VW")) {
                volkswagenai = pridetiElementa(volkswagenai, masinos[i]);
            }
        }
        return volkswagenai;
    }

    public static Car[] pridetiElementa(Car[] masinos, Car reiksme) {
        Car[] naujasMasyvas = Arrays.copyOf(masinos,
                masinos.length + 1);
        naujasMasyvas[naujasMasyvas.length - 1] = reiksme;
        return naujasMasyvas;
    }


}
