public class Leetcode_1323 {
    public static void main(String[] args) {
        int num = 96699;
        int zwischen = num;
        int tmp;
        int i = 0;
        int j = 999;
        while (num > 0) {
            tmp = num % 10;
            num /= 10;
            if (tmp == 6) {
                j = i;
            }
            i++;
        }
        if (j == 999) {
            System.out.println(zwischen);
        } else {
            int factor = 3;
            for (int x = 0; x < j; x++) {
                factor = factor * 10;
            }
            System.out.println(factor);

            zwischen += factor;
            System.out.println(zwischen);
        }







    }
}
