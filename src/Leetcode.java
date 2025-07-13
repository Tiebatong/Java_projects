public class Leetcode {
    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;


        for(int i = 0; i < nums.length; i++) {
            for(int n = 0; n < nums.length; n++) {
                if(target - nums[i]== nums[n] && n != i) {
                    //return new int[] {i, n};
                }
            }
        }
        //return new int[] {};
    }
}
