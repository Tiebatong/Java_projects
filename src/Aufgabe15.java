import java.util.Scanner;

public class Aufgabe15 {

    public static void main(String[] args) {
        int[] primzahlen = {2, 3, 5, 7, 11, 13,17, 19, 23, 29, 31, 37, 41, 43, 47};

        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben sie eine Zahl zwischen 2 und 100 ein:");
        int eingabe = scan.nextInt();
        boolean weiter = false;
        while(!weiter) {
            for(int i = 0; i < primzahlen.length; i++) {
                 int temp = eingabe / primzahlen[i];
            }
        }
    }
}
