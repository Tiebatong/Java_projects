public class Leetcode_342 {
    public static void main(String[] args) {
        int n = 4;

        for (int i = 0; i < 32; i++) {
            if (Math.pow(4, i) == n) {
                System.out.println(i);
            }
        }
    }
}
