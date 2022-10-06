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
}
