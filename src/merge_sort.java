public class merge_sort {
    public static void main() {


        int[] A = {4,2,-1,9,0,5,3,6};

        System.out.println(java.util.Arrays.toString(sort(A)));
    }

    static int[] merge(int[] A, int[] B) {
        int Index_A = 0;
        int Index_B = 0;
        int Index_merge = 0;

        int[] merged = new int[A.length + B.length];

        while (Index_A < A.length || Index_B < B.length) {

            if (Index_A >= A.length) {
                merged[Index_merge] = B[Index_B];
                Index_B++;
                Index_merge++;
            } else if(Index_B >= B.length) {
                merged[Index_merge] = A[Index_A];
                Index_A++;
                Index_merge++;
            } else if (A[Index_A] > B[Index_B]) {
                merged[Index_merge] = B[Index_B];
                Index_B++;
                Index_merge++;
            } else {
                merged[Index_merge] = A[Index_A];
                Index_A++;
                Index_merge++;
            }

        }
        return merged;
    }

    static int[] sort(int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        }

        int[] A = first_half(numbers);
        int[] B = second_half(numbers);

        int[] array_A = sort(A);
        int[] array_B = sort(B);

        return merge(array_A, array_B);

    }

    static int[] first_half(int[] numbers) {
        int length = numbers.length / 2;

        int[] halfed = new int[length];

        for (int i = 0; i < length; i++) {
            halfed[i] = numbers[i];
        }

        return halfed;
    }

    static int[] second_half(int[] numbers) {
        int length = numbers.length - numbers.length / 2;

        int[] halfed = new int[length];

        for (int i = 0; i < length; i++) {
            halfed[i] = numbers[i + numbers.length / 2];
        }
        return halfed;
    }
}
