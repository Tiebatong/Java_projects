public class Leetcode_69_alt {
    public static void main(String[] args) {
        /*
         babylonische Methode für Annäherung an Quadratwurzel
         https://www.youtube.com/watch?v=MXveVqBxFow&t=51s
         */

        int x = 356345;
        int base = binary_search(x);
        float approximation = base + (x - base * base) / (base * 2);
        System.out.println(approximation);

    }
    private static int binary_search(int x) {
        
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
