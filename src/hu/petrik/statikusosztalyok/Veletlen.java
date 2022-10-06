package hu.petrik.statikusosztalyok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private Veletlen(){}

    private static final Random rnd = new Random();
    private static final List<String> vezNevek = feltolt("files/veznev.txt");
    private static final List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static final List<String> noiKerNevek = feltolt("files/noikernev.txt");


    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();
        try{
            Scanner file = new Scanner(new File(fajlnev));
            while(file.hasNext()){
                String sor = file.nextLine();
                lista.add(sor);
            }
            file.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }
    public static int velEgesz(int min, int max){
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char Velkara(char min, char max){
        return (char) velEgesz(min, max);
    }

    public static String velVezetek(){
        return vezNevek.get(rnd.nextInt(vezNevek.size()));
    }

    /**
     * Véletlen magyar keresztnév generálása
     * @param nem A generált név nem. Férfi esetén true, Nő esetén false.
     * @return
     */
    public static String velKeresztNev(boolean nem){
        String keresztNev = null;
        if (nem){
            keresztNev = velFerfiKeresztNev();
        }else {
            keresztNev = velNoiKeresztNev();
        }
        return keresztNev;
    }

    private static String velFerfiKeresztNev(){
        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiKeresztNev(){
        return noiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    public static String velTeljesNev(boolean nem){
        return velVezetek() + " " + velKeresztNev(nem);
    }
}
