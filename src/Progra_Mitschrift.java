public class Progra_Mitschrift {
    public static void main(String[] args) {

        double[] zufallswerte = new double[50];

        for(int i = 0; i < zufallswerte.length; i++) {
            zufallswerte[i] = Math.random();
        }

        double sum = 0;
        for (double z: zufallswerte) {
            sum += z;
        }


        for(double z: zufallswerte) {
            System.out.println(z);
        }

        System.out.println("Durchschnitt: " + sum / zufallswerte.length);
    }
}
