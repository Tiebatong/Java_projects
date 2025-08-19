public class Leetcode_2348_alt {
    public static void main(String[] args) {
        int[] nums = {0,0,0,2,0,0};
        long zeros = 0;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zeros++;
                result += zeros;
            } else {
                zeros = 0;
            }




        }

        System.out.println(result);
    }
}