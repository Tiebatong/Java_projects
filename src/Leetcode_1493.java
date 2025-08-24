public class Leetcode_1493 {
    public static void main(String[] args) {

        int[] nums = {1,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,1,1};
        int[] sub_arr = new int[nums.length + 1];
        int counter = 0;


        int j = 0;
        int ones = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (ones > 0) {
                    sub_arr[j] = ones;
                    ones = 0;
                    j++;
                }
                sub_arr[j] = 0;
                j++;
            } else {
                ones ++;
            }
            if ( i == nums.length - 1) {
                sub_arr[j] = ones;
                j++;
            }
        }
        int summe = 0;
        int zwischen = 0;


        for (int y = 0; y < sub_arr.length; y++) {
            if (sub_arr[y] > 0) {
                counter++;
            }
        }
        for (int x = 1; x < j - 1; x++) {
            if (sub_arr[x - 1] > 0 && sub_arr[x] == 0 && sub_arr[x + 1] > 0) {
                zwischen = sub_arr[x - 1] + sub_arr[x + 1];
                if (zwischen > summe) {
                    summe = zwischen;
                }

            }
        }
        int biggest = 0;

        for (int i = 0; i < j; i++) {
            if (sub_arr[i] > biggest) {
                biggest = sub_arr[i];
            }
        }
        if (biggest > summe) {
            summe = biggest;
        }

        System.out.println(summe);

    }
}
