public class Leetcode_27 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3, 6, 8, 3, 6, 9, 3 ,3};
        int val = 3;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
            } else {
                nums[counter] = nums[i];
                counter++;
            }
        }

        for (int x = 0; x < (nums.length - counter); x++) {
            nums[counter + x] = 0;
        }
        int k = counter;

        System.out.println(k);

        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j]);
        }
    }
}
