import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {
    @Test
    void backtracking1() {
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(28, k.gewicht_beladung);
        assertEquals(155, k.wert_beladung);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0}, ausgewaehlt);

    }

    @Test
    void backtracking2() {
        int[] gewichte = {40, 40, 40, 40};
        int[] werte = {7, 6, 2, 20};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(0, k.gewicht_beladung);
        assertEquals(0, k.wert_beladung);
        assertArrayEquals(new int[]{0, 0, 0, 0}, ausgewaehlt);
    }

    @Test
    void backtracking3() {
        int[] gewichte = {};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        assertThrows(IllegalArgumentException.class, k::backtracking);
    }

    @Test
    void backtracking4() {
        int[] gewichte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int[] werte = {};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        assertThrowsExactly(IllegalArgumentException.class, k::backtracking);
    }

    @Test
    void backtracking5() {
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = -1;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        assertThrows(IllegalArgumentException.class, k::backtracking);
    }

    @Test
    void backtracking6() {
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 0;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(0, k.gewicht_beladung);
        assertEquals(0, k.wert_beladung);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, ausgewaehlt);
    }

    @Test
    void backtracking7() {
        int[] gewichte = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] werte = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(16, k.gewicht_beladung);
        assertEquals(16, k.wert_beladung);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, ausgewaehlt);
    }

    @Test
    void backtracking8() {
        int[] gewichte = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] werte = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        k.backtracking();
    }


    @Test
    void greedy1() {
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(28, k.gewicht_beladung);
        assertEquals(155, k.wert_beladung);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0}, ausgewaehlt);

    }

    @Test
    void greedy2() {
        int[] gewichte = {40, 40, 40, 40};
        int[] werte = {7, 6, 2, 20};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(0, k.gewicht_beladung);
        assertEquals(0, k.wert_beladung);
        assertArrayEquals(new int[]{0, 0, 0, 0}, ausgewaehlt);
    }

    @Test
    void greedy3() {
        int[] gewichte = {};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        assertThrows(IllegalArgumentException.class, k::backtracking);
    }

    @Test
    void greedy4() {
        int[] gewichte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int[] werte = {};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        assertThrowsExactly(IllegalArgumentException.class, k::backtracking);
    }

    @Test
    void greedy5() {
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = -1;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        assertThrows(IllegalArgumentException.class, k::backtracking);
    }

    @Test
    void greedy6() {
        int[] gewichte = {10, 5, 7, 11, 13, 1, 7, 11, 13, 19, 19, 9, 8, 2, 7, 31};
        int[] werte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int maxgewicht = 0;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(0, k.gewicht_beladung);
        assertEquals(0, k.wert_beladung);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, ausgewaehlt);
    }

    @Test
    void greedy7() {
        int[] gewichte = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] werte = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        int[] ausgewaehlt = k.backtracking();
        assertEquals(16, k.gewicht_beladung);
        assertEquals(16, k.wert_beladung);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, ausgewaehlt);
    }

    @Test
    void greedy8() {
        int[] gewichte = {7, 6, 1, 1, 1, 4, 11, 20, 3, 7, 8, 9, 16, 19, 100, 3};
        int[] werte = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int maxgewicht = 30;
        knapsack k = new knapsack(gewichte, werte, maxgewicht);
        k.backtracking();
    }

    @Test
    void worst_case_knapsack_runtime_10() {
        knapsack.worst_case_knapsack_runtime(10);
    }

    @Test
    void worst_case_knapsack_runtime_20() {knapsack.worst_case_knapsack_runtime(20);
    }

    @Test
    void worst_case_knapsack_runtime_50() {
        knapsack.worst_case_knapsack_runtime(50);
    }

    @Test
    void worst_case_knapsack_runtime_100() {
        knapsack.worst_case_knapsack_runtime(100);
    }

    @Test
    void worst_case_knapsack_runtime_200() {
        knapsack.worst_case_knapsack_runtime(200);
    }

    @Test
    void worst_case_knapsack_runtime_500() {
        knapsack.worst_case_knapsack_runtime(500);
    }

    @Test
    void worst_case_knapsack_runtime_1000() {
        knapsack.worst_case_knapsack_runtime(1000);
    }

}