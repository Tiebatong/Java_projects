public class Leetcode_35 {
    public static void main(String[] args) {

        int[] nums = {2, 3, 5, 6};
        int target = 7;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                System.out.println(i);
                found = true;
            }
        }

        if (target <= nums[0]) {
            System.out.println(0);
        } else if (target >= nums[nums.length - 1]) {
            System.out.println(nums.length);
        }

        if (!found) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= target && target <= nums[j + 1]) {
                    System.out.println(j + 1);
                    found = true;
                }
            }
        }


    }

}
