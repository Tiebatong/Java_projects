public class Leetcode_370 {
    public static void main(String[] args) {
        int n = 3;
        String binary_String = Integer.toBinaryString(n);

        int max_bin_val = (int) Math.pow(2, binary_String.length()) - 1;
        System.out.println(max_bin_val);


    }
}
