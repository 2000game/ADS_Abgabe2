import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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

    // RunTime Backtracking

    @Test
    void worst_case_backtracking_runtime_5() {
        knapsack.worst_case_backtracking_runtime(5);
    }

    @Test
    void worst_case_backtracking_runtime_10() {
        knapsack.worst_case_backtracking_runtime(10);
    }

    @Test
    void worst_case_backtracking_runtime_12() {
        knapsack.worst_case_backtracking_runtime(12);
    }

    @Test
    void worst_case_backtracking_runtime_15() {
        knapsack.worst_case_backtracking_runtime(15);
    }

    @Test
    void worst_case_backtracking_runtime_17() {
        knapsack.worst_case_backtracking_runtime(17);
    }

    @Test
    void worst_case_backtracking_runtime_20() {knapsack.worst_case_backtracking_runtime(20);
    }

    @Test
    void worst_case_backtracking_runtime_22() {knapsack.worst_case_backtracking_runtime(22);
    }

    @Test
    void worst_case_backtracking_runtime_25() {
        knapsack.worst_case_backtracking_runtime(25);
    }

    @Test
    void worst_case_backtracking_runtime_27() {knapsack.worst_case_backtracking_runtime(27);
    }

    @Test
    void worst_case_backtracking_runtime_30() {knapsack.worst_case_backtracking_runtime(30);
    }

    @Test
    @Disabled
    void worst_case_backtracking_runtime_40() {
        knapsack.worst_case_backtracking_runtime(40);
    }

    @Test
    @Disabled
    void worst_case_backtracking_runtime_50() {
        knapsack.worst_case_backtracking_runtime(50);
    }

    @Test
    @Disabled
    void worst_case_backtracking_runtime_100() {
        knapsack.worst_case_backtracking_runtime(100);
    }
    @Test
    @Disabled
    void worst_case_backtracking_runtime_200() {
        knapsack.worst_case_backtracking_runtime(200);
    }
    @Test
    @Disabled
    void worst_case_backtracking_runtime_500() {
        knapsack.worst_case_backtracking_runtime(500);
    }
    @Test
    @Disabled
    void worst_case_backtracking_runtime_1000() {
        knapsack.worst_case_backtracking_runtime(1000);
    }


    // RunTime Greedy

    @Test
    void worst_case_greedy_runtime_1() {
        knapsack.worst_case_greedy_runtime(1);
    }
    @Test
    void worst_case_greedy_runtime_10() {
        knapsack.worst_case_greedy_runtime(10);
    }
    @Test
    void worst_case_greedy_runtime_1000() {
        knapsack.worst_case_greedy_runtime(1000);
    }
    @Test
    void worst_case_greedy_runtime_2000() {
        knapsack.worst_case_greedy_runtime(2000);
    }
    @Test
    void worst_case_greedy_runtime_5000() {
        knapsack.worst_case_greedy_runtime(5000);
    }
    @Test
    void worst_case_greedy_runtime_10000() {
        knapsack.worst_case_greedy_runtime(10000);
    }
    @Test
    void worst_case_greedy_runtime_100000() {
        knapsack.worst_case_greedy_runtime(100000);
    }
    @Test
    void worst_case_greedy_runtime_200000() {
        knapsack.worst_case_greedy_runtime(200000);
    }
    @Test
    void worst_case_greedy_runtime_500000() {
        knapsack.worst_case_greedy_runtime(500000);
    }
}
