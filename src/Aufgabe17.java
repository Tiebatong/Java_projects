import java.util.Scanner;

public class Aufgabe17 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Bitte geben sie die gefahrene Strecke ein: ");
        double strecke = scan.nextInt();
        double normverbrauch = 37.6; // pro 100 km
        double max_tankinhalt = 120.5;
        System.out.println("Spritverbauch beträgt: " + Spritverbrauch(strecke, normverbrauch));
        System.out.println("Rest im Tank: " + Tankinhalt(strecke, normverbrauch, max_tankinhalt));
    }
    static double Spritverbrauch(double gefahren, double normverbrauch) {
        return gefahren * (normverbrauch / 100);

    }
    static double Tankinhalt(double gefahren, double normverbrauch, double max_tankinhalt) {
        double verbraucht = gefahren * (normverbrauch / 100);
        return max_tankinhalt - verbraucht;

    }
}
