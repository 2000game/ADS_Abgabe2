import org.junit.jupiter.api.Test;

import java.util.Random;

public class ReverseRunTimeTest {

    // generates a String with random characters with the length given
    public static String genRandomString(int len) {
        Random rn = new Random();
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            int a = rn.nextInt(126)+33;
            result[i] = ((char) a);
        }
        return String.valueOf(result);
    }
    @Test
    void small_strings() {
        String test;
        double start;
        double finish;
        for (int i = 100; i <= 1000; i += 100) {
            test = genRandomString(i);
            start = System.nanoTime();
            reverse.reverse(test);
            finish = System.nanoTime();
            System.out.println(i + "-Character langer String umgedreht\nDauer: " + (finish - start) / 1000000.0 + " ms\n");
        }
    }
    @Test
    void large_strings(){
            String test;
            double start;
            double finish;
            for (int i = 10000; i <= 100000; i += 10000) {
                test = genRandomString(i);
                start = System.nanoTime();
                try {
                    reverse.reverse(test);
                } catch (StackOverflowError e) {
                    System.out.println("StackOverflowError");
                }
                finish = System.nanoTime();
                System.out.println(i + "-Character langer String umgedreht\nDauer: " + (finish - start) / 1000000.0 + " ms\n");
            }
    }


        // up until 6000 chars, the reverse function appears to work just fine
        // however, anything above that is likely to end in a stack overflow exception with referral to the reverse function.
        // unexpectedly, when done in a for-loop, no exception appears up until 15000 chars

    }


