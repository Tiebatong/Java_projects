import java.util.Scanner;

public class pyramid {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);



        System.out.println("Bitte geben sie die Breite an: ");
        int breite = scan.nextInt();
        System.out.println("Bitte geben sie die Länge an: ");
        int laenge = scan.nextInt();
        System.out.println("Bitte geben sie die Höhe an: ");
        int hoehe = scan.nextInt();

        float volumen = laenge * breite * hoehe / 3;
        System.out.println("Das Volumen beträgt" + volumen);


    }
}
