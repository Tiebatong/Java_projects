public class Search {

    public static void main(String[] args) {

        int needle = Integer.parseInt(args[0]);

        int[] haystack = new int[args.length - 1];
        if (args.length > 1) {
            int j = 0;
            for (int i = 1; i < args.length; i++) {
                haystack[j] = Integer.parseInt(args[i]);
                j++;
            }
        }
//        int needle = -3;
//        int[] haystack = {-3};


        System.out.println(search(haystack, needle));
    }

    static int search(int[] haystack, int needle) {

        if (haystack.length == 0) {
            return -1;
        }
        int left = 0;
        int right = haystack.length - 1;

        while (needle >= haystack[left] && needle <= haystack[right]) {
            int split_index = split(haystack, needle, left, right);
            if (haystack[split_index] > needle) {
                right = split_index -1;
            } else if (haystack[split_index] < needle) {
                left = split_index + 1;
            } else {
                return split_index;
            }

        }
        return -1;
    }

    private static int split(int[] haystack, int needle, int left, int right) {

        if (haystack[right] == haystack[left]) {
            return left;
        }
        return (int) left + (needle - haystack[left]) / (haystack[right] - haystack[left]) * (right - left);

    }
}
