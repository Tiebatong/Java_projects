public class Aufgabe29 {

    static float[] sort(float[] array) {
        float temp = 0.0f;
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                array[i] = temp;
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }


        return array;
    }
    public static void main(String[] args) {

        float[] array = {12.99f, 11.95f, 2.50f, 99.95f, 1.95f, 2.5f, 10.2f};
        float[] sorted_array = sort(array);
        for(int i = 0; i < sorted_array.length; i++) {
            System.out.println(sorted_array[i]);
        }

    }
}
