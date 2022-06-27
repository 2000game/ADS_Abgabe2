import java.util.Random;

public class knapsack {
    protected int[] gewichte;
    protected int[] werte;
    protected int maxgewicht;

    protected int[] beladung;
    protected int wert_beladung;
    protected int gewicht_beladung;


    public knapsack(int[] gewichte, int[] werte, int maxgewicht) {
        this.gewichte = gewichte;
        this.werte = werte;
        this.maxgewicht = maxgewicht;
        beladung = new int[gewichte.length];
        wert_beladung = 0;
        gewicht_beladung = 0;
    }

    private int berechne_gewicht(int[] beladung) {
        int gewicht = 0;
        for (int i = 0; i < beladung.length; i++) {
            gewicht += beladung[i] * gewichte[i];
        }
        return gewicht;
    }

    private int berechne_wert(int[] beladung) {
        int wert = 0;
        for (int i = 0; i < beladung.length; i++) {
            wert += beladung[i] * werte[i];
        }
        return wert;
    }

    public int[] backtracking(){
        if (gewichte.length != werte.length) {
            throw new IllegalArgumentException("Gewichte und Werte müssen gleich lang sein");
        }
        if (maxgewicht < 0) {
            throw new IllegalArgumentException("Maximalgewicht muss positiv sein");
        }
        int[] solution = this.rucksack(new int[gewichte.length], maxgewicht, 0, new int[gewichte.length], 0);
        gewicht_beladung = berechne_gewicht(solution);
        wert_beladung = berechne_wert(solution);
        beladung = solution;
        return solution;

    }

    protected int[] rucksack(int[] ausgewaehlt, int rest_gewicht, int index, int[] beste_beladung, int beste_wert) {
        // abbruch bedingungen
        if (rest_gewicht == 0) {
            // max gewicht erreicht
            return ausgewaehlt;
        }
        if (index == gewichte.length) {
            // alle gewichte abgearbeitet
            return ausgewaehlt;
        }
        if (gewichte[index] > rest_gewicht) {
            // gewicht zu groß
            ausgewaehlt[index] = 0;
            return ausgewaehlt;
        }
        if (werte[index] == 0) {
            // If the value of the item is 0, then we don't need to consider it
            return rucksack(ausgewaehlt, rest_gewicht, index + 1, beste_beladung, beste_wert);
        }
        // verzweigung A
        int[] ausgewaehlt_a = ausgewaehlt.clone();
        ausgewaehlt_a[index] = 1;
        int[] A = rucksack(ausgewaehlt_a, rest_gewicht - gewichte[index], index + 1, beste_beladung, beste_wert);

        int wert_a = berechne_wert(A);
        if (wert_a > beste_wert) {
            beste_wert = wert_a;
            beste_beladung = A;
        }

        // verzweigung B
        int[] ausgewaehlt_b = ausgewaehlt.clone();
        ausgewaehlt_b[index] = 0;
        int[] B = rucksack(ausgewaehlt_b, rest_gewicht, index + 1, beste_beladung, beste_wert);


        int wert_b = berechne_wert(B);
        if (wert_b > beste_wert) {
            beste_beladung = B;
        }

        return beste_beladung;
    }

    public int[] greedyRucksack(){
        if (gewichte.length != werte.length) {
            throw new IllegalArgumentException("Gewichte und Werte müssen gleich lang sein");
        }
        if (maxgewicht < 0) {
            throw new IllegalArgumentException("Maximalgewicht muss positiv sein");
        }
        int[] solution = new int[gewichte.length];
        int rest_gewicht = maxgewicht;
        for (int i = 0; i < gewichte.length; i++) {
            if (gewichte[i] > rest_gewicht) {
                solution[i] = 0;
            } else {
                solution[i] = 1;
                rest_gewicht -= gewichte[i];
            }
        }
        gewicht_beladung = berechne_gewicht(solution);
        wert_beladung = berechne_wert(solution);
        beladung = solution;
        return solution;
    }

    public static int worst_case_knapsack_runtime(int array_length) {
        double start;
        double finish;
        int[] gewichte = new int[array_length];
        int[] werte = new int[array_length];
        for (int i = 0; i < array_length; i++) {
            gewichte[i] = 1;
            werte[i] = 1;
        }
        knapsack k = new knapsack(gewichte, werte, array_length*array_length);
        start = System.nanoTime();
        k.backtracking();
        finish = System.nanoTime();
        System.out.println();
        System.out.println(array_length + "-Array Laenge worst_case backtracking\nDauer: " + (finish - start) / 1000000.0 + " ms\n");
        System.out.println();
        return (int) (finish - start) / 1000000;
    }
    
        public static int worst_case_rucksack_runtime(int array_length) {
        double start;
        double finish;
        Random rnd;
        rnd = new Random();
        int[] gewichte = new int[array_length];
        int[] werte = new int[array_length];
        for (int i = 0; i < array_length; i++) {
            gewichte[i] = rnd.nextInt(1,15);
            werte[i] = rnd.nextInt(1,30);
        }
        knapsack k = new knapsack(gewichte, werte, array_length*array_length);
        start = System.nanoTime();
        k.greedyRucksack();
        finish = System.nanoTime();
        System.out.println();
        System.out.println(array_length + "-Array Laenge worst_case greedy-verfahren\nDauer: " + (finish - start) / 1000000.0 + " ms\n");
        System.out.println();
        return (int) (finish - start) / 1000000;
    }
}
