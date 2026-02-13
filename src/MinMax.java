public class MinMax {
    static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("ERROR");
        } else {
            int[] temps = new int[args.length];
            int i = 0;

            for (String s: args) {
                temps[i] = Integer.parseInt(s);
                i++;
            }

            int maximum = temps[0];
            int minimum = temps[0];
            for (int j = 1; j < args.length; j++) {
                if (temps[j] > maximum) {
                    maximum = temps[j];
                }
                if (temps[j] < minimum) {
                    minimum = temps[j];
                }
            }

            System.out.println(minimum);
            System.out.println(maximum);
        }

    }
}
