public class Leetcode_28 {
    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "c";
        String substring;

        for ( int i = 0; i <= haystack.length() - needle.length(); i++) {
            substring = haystack.substring(i, i + needle.length());
            if ( substring.equals(needle)) {
                System.out.println(i);
                break;
            }
        }
    }
}
