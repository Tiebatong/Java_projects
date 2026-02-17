public class sort {

    static void main() {
        int[] A = {2,4,7,9};
        int[] B = {1, 3, 8, 12};
        int[] sorted = merge(A, B);

        for (int i: sorted) {
            System.out.print(i + ", ");
        }
    }

    static int[] merge(int[] A, int[] B) {
        int Index_A = 0;
        int Index_B = 0;
        int Index_merge = 0;

        int[] merged = new int[A.length + B.length];

        // test hallo rotfront
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

}
