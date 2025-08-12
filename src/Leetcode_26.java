public class Leetcode_26 {
    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4,5};
        int k = 1;

        if (nums.length == 0) {
            k = 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = 1; i < (nums.length - k) + 1; i++) {
            nums[nums.length - (1 * i)] = 0;
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j]);
        }

        System.out.println(" ");
        System.out.println(k);



    }
}
