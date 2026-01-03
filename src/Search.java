public class Search {

    public static void main(String[] args) {


        int needle = Integer.parseInt(args[0]);
        int[] haystack = new int[args.length-1];

        for (int i = 0; i < args.length-1; i++) {
            haystack[i] = Integer.parseInt(args[i+1]);
        }


        System.out.println(search(haystack, needle));

    }

    static int search(int[] haystack, int needle) {
        if (haystack.length == 0) {
            return -1;
        }
        int left = 0;
        int right = haystack.length - 1;

        while (haystack[left] <= needle && needle <= haystack[right]) {
            int splitIndex = split(haystack, needle, left, right);

            if (needle == haystack[splitIndex]) {
                return splitIndex;
            }

            if (needle < haystack[splitIndex]) {
                right = splitIndex - 1;
            } else {
                left = splitIndex + 1;
            }
        }

        return -1;
    }

    static private int split(int[] haystack, int needle, int left, int right) {

        if (haystack[right] == haystack[left]) {
            return left;
        }

        return (int) ( left + (double) ((needle - haystack[left]) / (haystack[right] - haystack[left])) * (right - left));


    }
}
