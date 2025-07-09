
import java.util.Scanner;

public class Aufgabe15 {

    public static void main(String[] args) {
        int[] primzahlen = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben sie eine Zahl zwischen 2 und 100 ein:");
        int eingabe = scan.nextInt();
        int[] faktoren = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        float temp = eingabe;
        int index = 0;
        for (int i = 0; i < primzahlen.length; i++) {

            if(temp % primzahlen[i] == 0) {
                temp = temp / primzahlen[0];
                faktoren[index++] = primzahlen[i];
                i = -1;
            }
            if(temp == 1) {
                break;
            }


        }
        for(int i = 0; i < index; i++) {
            System.out.println(faktoren[i]);
        }
    }

}

