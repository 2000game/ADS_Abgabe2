public class main {
    public static void main(String[] args) {
        // build random knapsack
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.greedyRucksack();
        System.out.println("Gewicht: " + k.gewicht_beladung);
        System.out.println("Wert: " + k.wert_beladung);
        System.out.print("Ausgewaehlt: ");
        for (int j : ausgewaehlt) {
            System.out.print(j + " ");
        }
        System.out.println();

        // build random knapsack2
        int[] gewichte2 = {10, 5, 7, 11};
        int[] werte2 = {7, 6, 2, 20};
        int maxgewicht2 = 30;
        knapsack k2 = new knapsack(gewichte2, werte2, maxgewicht2);
        int[] ausgewaehlt2 = k2.greedyRucksack();
        System.out.println("Gewicht: " + k2.gewicht_beladung);
        System.out.println("Wert: " + k2.wert_beladung);
        System.out.print("Ausgewaehlt: ");
        for (int j : ausgewaehlt2) {
            System.out.print(j + " ");
        }



    }
}