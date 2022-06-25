import java.util.Random;

public class reverseRunTimeTest {

    // generates a String with random characters with the length given

    public static String genRandomString(int len) {
        Random rn = new Random();
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            int a = rn.nextInt(33,126);
            result[i] = ((char) a);
        }
        return String.valueOf(result);
    }
    public static void main(String[] args) {
        String test;
        double start; double finish;
        reverse rev = new reverse();
        for(int i = 100;i<=1000;i+=100){
            test = genRandomString(i);
            start = System.nanoTime();
            test = rev.reverse(test);
            finish = System.nanoTime();
            System.out.println(i+"-Character langer String umgedreht\nDauer: "+(finish-start)/1000000.0 +" ms\n");
        }
        for(int i = 1000;i<=15000;i+=1000){
            test = genRandomString(i);
            start = System.nanoTime();
            test = rev.reverse(test);
            finish = System.nanoTime();
            System.out.println(i+"-Character langer String umgedreht\nDauer: "+(finish-start)/1000000.0 +" ms\n");
        }

        // up until 6000 chars, the reverse function appears to work just fine
        // however, anything above that is likely to end in a stack overflow exception with referral to the reverse function.
        // unexpectedly, when done in a for-loop, no exception appears up until 15000 chars

    }

}
