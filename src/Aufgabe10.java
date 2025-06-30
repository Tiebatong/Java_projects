public class Aufgabe10 {
    public static void main(String[] args) {

        int[] array = {4, 8, 2, 12, 9, 32, 65, 28, 59, 17, 9};

        System.out.println("Maximum = " + Maximum(array));
        System.out.println("Minimum = " + Minimum(array));
    }
    static int Maximum(int[] array) {

        int arraylength = array.length;
        int temp = array[0];
        for (int i = 0; i < arraylength; i++) {
            if (temp < array[i]) {
                temp = array[i];
            }
        }
        return temp;
    }
    static int Minimum(int[] array) {

        int arraylength = array.length;
        int temp = array[0];
        for (int i = 0; i < arraylength; i++) {
            if (temp > array[i]) {
                temp = array[i];
            }
        }
        return temp;
    }
}
