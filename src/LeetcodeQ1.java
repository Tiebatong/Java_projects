public class LeetcodeQ1 {

    void main() {


        int[] nums = {1,2,3,4,5,6};

        int[] ans = new int[nums.length * 2];

        int counter = 0;

        for (int i = 0; i < nums.length * 2; i++) {
            if (i == nums.length) {
                counter = 0;
            }
            ans[i] = nums[counter];

            counter++;
        }

        for(int i: ans) {
            System.out.println(i);
        }

    }
}
