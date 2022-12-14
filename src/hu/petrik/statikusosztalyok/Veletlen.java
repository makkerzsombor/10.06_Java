package hu.petrik.statikusosztalyok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private Veletlen() {
    }

    private static final Random rnd = new Random();
    private static final List<String> vezNevek = feltolt("files/veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static final List<String> noiKerNevek = feltolt("files/noikernev.txt");
    private static final List<String> sportag = feltolt("files/sportag.txt");
    private static final List<String> egyesulet = feltolt("files/egyesulet.txt");


    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(fajlnev));
            while (file.hasNext()) {
                String sor = file.nextLine();
                lista.add(sor);
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static int velEgesz(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char Velkara(char min, char max) {
        return (char) velEgesz(min, max);
    }

    public static String velVezetek() {
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }

    /**
     * Véletlen magyar keresztnév generálása
     *
     * @param nem A generált név nem. Férfi esetén true, Nő esetén false.
     * @return
     */
    public static String velKeresztNev(boolean nem) {
        String keresztNev = null;
        if (nem) {
            keresztNev = velFerfiKeresztNev();
        } else {
            keresztNev = velNoiKeresztNev();
        }
        return keresztNev;
    }

    private static String velFerfiKeresztNev() {
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiKeresztNev() {
        return noiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    public static String velTeljesNev(boolean nem) {
        return velVezetek() + " " + velKeresztNev(nem);
    }

    public static String velDatum(int ev1, int ev2) {
        int ev = rnd.nextInt(ev2 - ev1 + 1) + ev1;
        int honap = rnd.nextInt(12 - 1 + 1) + 1;
        int nap = 0;
        if (honap == 2) {
            nap = rnd.nextInt(28 - 1 + 1) + 1;
        } else if (honap == 8) {
            nap = rnd.nextInt(31 - 1 + 1) + 1;
        } else if (honap % 2 == 0) {
            nap = rnd.nextInt(30 - 1 + 1) + 1;
        } else {
            nap = rnd.nextInt(31 - 1 + 1) + 1;
        }
        return ev + "-" + honap + "-" + nap;
    }

    public static String velEmail(String nev) {
        nev = nev.replaceAll("^\\p{ASCII}]", "");
        String[] email = nev.toLowerCase().split(" ");
        return email[0] + email[1] + (rnd.nextInt(99 - 1 + 1) + 1) + "@gmail.com";
    }

    public static String velMobil() {
        return " +36 (30) " + velEgesz(0, 9) + velEgesz(0, 9) + velEgesz(0, 9) + "-" + velEgesz(0, 9) + velEgesz(0, 9) + "-" + velEgesz(0, 9) + velEgesz(0, 9);
    }

    public static String velSportag() {
        return sportag.get(rnd.nextInt(sportag.size()));
    }

    public static String velSportegyesulet() {
        return egyesulet.get(rnd.nextInt(egyesulet.size()));
    }
}
