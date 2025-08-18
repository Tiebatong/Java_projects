public class Leetcode_344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        char tmp = ' ';
        int j = s.length - 1;
        for (int i = 0; i < (s.length / 2); i++) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            j--;
        }
        for (char c : s) {
            System.out.println(c);
        }
    }
}
