public class random {
    public static void main(String[] args) {


        System.out.println(binary_search(17));
    }
    private static int binary_search(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}

