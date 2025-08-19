public class Leetcode_2348 {
    public static void main(String[] args) {
        int[] nums = {2,10,2019};
        int zeros = 0;
        int subarray_length = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0) {
                subarray_length++;
                i++;
                if (i == nums.length) {
                    break;
                }
            }
            // Logik die für jeweiliges subarray zählt
            int x = 1;
            for (int j = subarray_length; j > 0; j--) {
                zeros += j ;
                x++;
            }

            //reset für nächstes subarray
            subarray_length = 0;
        }
        System.out.println(zeros);
    }
}
