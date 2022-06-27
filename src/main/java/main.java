import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class main {
   static Random r = new Random();

    public static void calculate_constant() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Map(key=Array_length, value=Runtime)
        for (int i = 100; i < 10000; i+=100 ) {
            map.put(i, knapsack.worst_case_knapsack_runtime(i));
        }
        int avg = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            avg += entry.getKey() / entry.getValue();
        }
        avg = avg / map.size();
        System.out.println("Average Constant: " + avg);
    }
    public static void worst_case_to_csv() {
        File file = new File("worst_case_runtime.csv");
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("sep=;");
            pw.println("Array_length;Runtime");

            for (int i = 100; i < 10000; i+=100 ) {
                pw.println(i + ";" + knapsack.worst_case_knapsack_runtime(i));
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }
    public static void main(String[] args) {
        // build knapsack problem
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 30;
        knapsack backtracking_knapsack = new knapsack(gewichte, werte, maxgewicht);
        knapsack greedy_knapsack = new knapsack(gewichte, werte, maxgewicht);
        int[] backtracking_solution = backtracking_knapsack.backtracking();
        System.out.println("-----------------------------------------------------");
        System.out.println("Backtracking Rucksack: " + Arrays.toString(backtracking_solution));
        System.out.println("Gewicht: " + backtracking_knapsack.gewicht_beladung);
        System.out.println("Wert: " + backtracking_knapsack.wert_beladung);
        System.out.println("-----------------------------------------------------");
        int[] greedy_solution = greedy_knapsack.greedyRucksack();
        System.out.println("Greedy Rucksack: " + Arrays.toString(greedy_solution));
        System.out.println("Gewicht: " + greedy_knapsack.gewicht_beladung);
        System.out.println("Wert: " + greedy_knapsack.wert_beladung);

        // build random knapsack2
        int[] gewichte_2 = {10, 5, 7, 11};
        int[] werte_2 = {7, 6, 2, 20};
        int maxgewicht_2 = 30;
        knapsack backtracking_knapsack_2 = new knapsack(gewichte_2, werte_2, maxgewicht_2);
        knapsack greedy_knapsack_2 = new knapsack(gewichte_2, werte_2, maxgewicht_2);
        int[] backtracking_solution_2 = backtracking_knapsack_2.backtracking();
        System.out.println("-----------------------------------------------------");
        System.out.println("Backtracking Rucksack: " + Arrays.toString(backtracking_solution_2));
        System.out.println("Gewicht: " + backtracking_knapsack_2.gewicht_beladung);
        System.out.println("Wert: " + backtracking_knapsack_2.wert_beladung);
        System.out.println("-----------------------------------------------------");
        int[] greedy_solution_2 = greedy_knapsack_2.greedyRucksack();
        System.out.println("Greedy Rucksack: " + Arrays.toString(greedy_solution_2));
        System.out.println("Gewicht: " + greedy_knapsack_2.gewicht_beladung);
        System.out.println("Wert: " + greedy_knapsack_2.wert_beladung);
        System.out.println("-----------------------------------------------------");
        worst_case_to_csv();
    }






}