public class Aufgabe9 {

    public static void main(String[] args) {

        // Funktion = a && !b && c || a && !d || !c && d

        for (int a = 0; a < 2; a++){
            for (int b = 0; b < 2; b++){
                for (int c = 0; c < 2; c++){
                    for (int d = 0; d < 2; d++){
                        if (!(a == 1 && b != 1 && c == 1 || a == 1 && d != 1 || c != 1 && d == 1)) {
                            System.out.println(a + " " + b + " " + c + " " + d + " = " + "1");

                        } else {
                            System.out.println(a + " " + b + " " + c + " " + d + " = " + "0");
                        }
                    }
                }
            }
        }
    }
}
