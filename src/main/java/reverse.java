public class reverse {
    public static String reverse(String t){
        if (t.isEmpty()) {
            return "";
        }
        return t.substring(t.length()-1) + reverse(t.substring(0, t.length()-1));
    }
}
