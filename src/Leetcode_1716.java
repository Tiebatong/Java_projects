public class Leetcode_1716 {
    public static void main(String[] args) {
        int n = 20;
        int start_value = 0;
        int balance = 0;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (i % 7 == 0 && i != 0) {
                counter++;
                start_value = counter;
            }
            start_value ++;
            balance += start_value;
        }


        System.out.println(balance);
    }
}
