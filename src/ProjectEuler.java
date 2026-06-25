public class ProjectEuler {
    static void main() {

        System.out.println(problem1());
    }

    static int problem2() {

        int a = 1;
        int b = 1;

        int sumOfEvenValues = 0;
        while (b < 4_000_000) {
            if (b % 2 == 0) {
                sumOfEvenValues += b;
            }
            int c = a + b;
            a = b;
            b = c;

        }
        return sumOfEvenValues;
    }
    static int problem1() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
