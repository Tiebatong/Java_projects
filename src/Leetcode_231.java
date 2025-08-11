public class Leetcode_231 {
    public static void main(String[] args) {
        int n = 17;
        for (int i = 0; i < 32; i ++) {
            if (n == (Math.pow(2, i))) {
                System.out.println(i);
            }
        }
    }
}
