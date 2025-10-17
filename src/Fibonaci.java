public class Fibonaci {
    public static void main(String[] args) {

        int Iterationen = 10;
        long fib1 = 1;
        long fib2 = 1;
        long temp = 0;

        for(int i = 0; i < Iterationen; i++) {
            temp = fib2;
            fib2 = fib1 + fib2;
            fib1 = temp;
            System.out.println(fib1);
        }
        System.out.println("fib(" + Iterationen + ") = " + fib1);

    }
}
