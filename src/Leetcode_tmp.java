public class Leetcode_tmp {

    static void main() {

        String word1 = "abcd";
        String word2 = "pq";

        System.out.println(mergeAlternately(word1, word2));

    }


    // 1768. Merge Strings Alternately
    // You are given two strings word1 and word2. Merge the strings by adding
    // letters in alternating order, starting with word1. If a string is longer
    // than the other, append the additional letters onto the end of the merged
    // string.
    //
    //Return the merged string.

    static String mergeAlternately(String word1, String word2) {
        String solution = "";
        int c1 = 0;
        int c2 = 0;
        int i = 0;

        while (c1 < word1.length() || c2 < word2.length()) {

            if (i % 2 == 0 && c1 < word1.length()) {

                solution += word1.charAt(c1);
                c1++;

            } else if (i % 2 == 1 && c2 < word2.length()){

                solution += word2.charAt(c2);
                c2++;

            }
            i++;
        }


        return solution;
    }

    static int[] shuffle(int[] nums) {
        int[] tmp = new int[nums.length];
        int indexa = 0;
        int indexb = nums.length / 2;
        int index = 0;
        for (int i = 0; i < nums.length / 2; i++) {

            tmp[index] = nums[indexa];
            indexa++;
            index++;
            tmp[index] = nums[indexb];
            indexb++;
            index++;
        }
        return tmp;
    }

    //Given a binary array nums, return the maximum number
    // of consecutive 1's in the array.
    //https://leetcode.com/problems/max-consecutive-ones/description/?envType=problem-list-v2&envId=dsa-linear-shoal-array-i

    static int findMaxConsecutiveOnes(int[] nums) {
        int n = 0;
        int tmp = 0;

        if (nums.length == 1 && nums[0] == 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                tmp++;
            }
            if (i == nums.length - 1 || nums[i] != 1) {
                if (tmp > n) {
                    n = tmp;

                }
                tmp = 0;
            }


        }
        return n;
    }
}
