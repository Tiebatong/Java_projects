public class Aufgabe29 {

    static float[] sort(float[] array) {

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    float tmp = 0.0f;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
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
