class Binary_search {

    static void main() {

        int[] haystack = {1, 6, 8, 12, 15, 19, 20, 40, 78, 90, 99};

        System.out.println(binarySearch(haystack, 99));
    }

    static int binarySearch(int[] haystack, int needle) {

        int left_limit = 0;
        int right_limit = haystack.length;
        int split_position = haystack.length / 2;

        while (left_limit < right_limit) {

            split_position = (left_limit + right_limit) / 2;
            if (haystack[split_position] == needle) {
                return split_position;
            }

            if (haystack[split_position] > needle) {
                right_limit = split_position - 1;
            } else {
                left_limit = split_position + 1;
            }
        }
        return -1;

    }
}
