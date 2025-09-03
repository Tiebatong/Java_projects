public class Leetcode_7 {
    public static void main(String[] args) {

        int x = -1563847412;
        int max_32_bit = 2147483647;
        int min_32_bit = -2147483648;
        if (x == min_32_bit || x == min_32_bit) {
            System.out.println("out_of_bounds");;
        }

        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            System.out.println(digit);

            if (result > max_32_bit / 10 || result < min_32_bit / 10) {
                System.out.println("out_of_bounds");
            }

            result = result * 10 + digit;
        }

        System.out.println(result);

    }
}
