package hu.petrik.statikusosztalyok;

public class Main {
    int nemStatikusAdattag;
    static int statikusTag;
    public static void main(String[] args) {
        /*
        Main objektm = new Main();
        System.out.println(objektm.nemStatikusAdattag);
        System.out.println(Main.statikusTag);
        */

        for (int i = 0; i < 100; i++) {
            System.out.println(Veletlen.velEgesz(5, 10));;
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(Veletlen.Velkara((char) 65, (char) 90));
            //System.out.println(Veletlen.Velkara('A','B'));
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velTeljesNev(true));
        }
        //
        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velDatum(2021, 2022));
        }
        //mobil
        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velMobil());
        }
        //sportág
        System.out.println("Sportágak:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velSportag());
        }
        //sportegyesület
        System.out.println("Sportegyesület:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Veletlen.velSportegyesulet());
        }
    }
}
