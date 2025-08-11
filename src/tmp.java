public class tmp {
    public static void main(String[] args) {

        int[] ints = {1, 2, 4, 5, 7, 9, 11};
        System.out.println(binary_search(ints, 11));
    }
    private static int binary_search(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int middle_number = numbers[middle];

            if (target == middle_number) {
                return middle;
            } else if (target < middle_number) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
