public class Progra_Mitschrift {
    public static void main(String[] args) {

        int[] numbers = {2, 3, 6, 1, 8, 9 ,4, 6};
        shuffle(numbers);
        printarr(numbers);


    }
    static void shuffle(int[] zahlen) {
        int position1 = (int) (Math.random() * zahlen.length);
        int position2 = (int) (Math.random() * zahlen.length);
        swap(zahlen, position1, position2);
    }
    static void swap (int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
