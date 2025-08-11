public class Leetcode_58 {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start --;
        }
        System.out.println(end - start);

    }
}
