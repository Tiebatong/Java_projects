import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Leetcode_tmp {

    static void main() {

        int[] nums = {1};
        System.out.println(isMonotonic(nums));

    }

    // 896. Monotonic Array
    // An array is monotonic if it is either monotone increasing or monotone decreasing.
    //An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums
    // is monotone decreasing if for all i <= j, nums[i] >= nums[j].
    //Given an integer array nums, return true if the given array is monotonic, or false otherwise.

    static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                increasing = false;
            } else if (nums[i] > nums[i + 1]) {
                decreasing = false;
            }
            if (!increasing && !decreasing) {
                return false;
            }
        }

        return true;
    }

    // 1822. Sign of the Product of an Array
    // Implement a function signFunc(x) that returns:
    //
    // 1 if x is positive.
    // -1 if x is negative.
    // 0 if x is equal to 0.
    // You are given an integer array nums. Let product be the product of all values in the array nums.
    //
    // Return signFunc(product).

    static int arraySign(int[] nums) {
        int negativeCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                negativeCounter++;
            }
        }

        if (negativeCounter % 2 == 0) {
            return 1;
        } else {
            return -1;
        }

    }

    // 283. Move Zeroes
    // Given an integer array nums, move all 0's to the end of it while maintaining
    // the relative order of the non-zero elements.
    //Note that you must do this in-place without making a copy of the array.

    static void moveZeroes(int[] nums) {
        boolean sorted = false;
        int length = nums.length;


        int i = 0;

        while (!sorted) {
            if (nums[i] == 0) {
                for (int j = i; j < length - 1; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }

            } else {
                i++;
            }
            sorted = true;
            for (int n = 0; n < length - 1; n++) {
                if (nums[n] == 0 && nums[n + 1] != 0) {
                    sorted = false;
                }
            }
        }




        for (int n: nums) {
            System.out.print(n + ", ");
        }

    }

    // 459. Repeated Substring Pattern
    // Given a string s, check if it can be constructed by taking a substring of it
    // and appending multiple copies of the substring together.
    // Example 1:
    //Input: s = "abab"
    //Output: true
    //Explanation: It is the substring "ab" twice.

    static boolean repeatedSubstringPattern(String s) {
        boolean constructable = false;
        int length = s.length();

        for ( int i = 1; i <= length / 2; i++) {
            String substring = s.substring(0, i);

            if (length % i != 0) {
                continue;
            }

            int rightIndex = i;
            int leftIndex = i;
            constructable = true;
            while (rightIndex <= length - i) {
                rightIndex += i;
                String compSubstring = s.substring(leftIndex, rightIndex);
                leftIndex += i;
                if (!substring.equals(compSubstring)) {
                    constructable = false;
                    break;
                }
            }

            if (constructable) {
                return true;
            }


        }
        return constructable;
    }

    // Q3. Self Dividing Numbers
    // A self-dividing number is a number that is divisible by every digit it contains.
    //
    // For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    // A self-dividing number is not allowed to contain the digit zero.
    //
    // Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).

    static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int d = i;
            int y = 0;
            boolean divisable = true;
            for (int j = 0; j < String.valueOf(i).length(); j++) {


                y = d % 10;
                d /= 10;

               // System.out.println(" j: " + i);
               // System.out.println(" y: " + y);

                if (y == 0) {
                    divisable = false;
                    continue;
                }
                if (i % y != 0) {
                    divisable = false;
                }
            }
            if (divisable) {
                result.add(i);
            }

        }

        return result;
    }

    // Q2. Find the Pivot Integer
    // Given a positive integer n, find the pivot integer x such that:
    //The sum of all elements between 1 and x inclusively equals the sum
    // of all elements between x and n inclusively.
    //Return the pivot integer x. If no such integer exists, return -1. It is
    // guaranteed that there will be at most one pivot index for the given input.

    static int pivotInteger(int n) {


        for (int i = 1; i <= n; i++) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int j = 1; j <= i; j++) {
                sumLeft += j;
            }

            for (int k = i; k <= n; k++) {
                sumRight += k;
            }

            if (sumLeft == sumRight) {
                return i;
            }
        }

        return -1;
    }

    // Q1. Can Make Arithmetic Progression From Sequence
    // A sequence of numbers is called an arithmetic progression if the difference
    // between any two consecutive elements is the same.
    // Given an array of numbers arr, return true if the array can be rearranged to
    // form an arithmetic progression. Otherwise, return false.

    static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        for (int i = arr.length - 1; i > 1 ; i--) {
            if (arr[i] - arr[i - 1] != arr[i - 1] - arr[i - 2]) {
                return false;
            }
        }
        return true;

    }

    // 242. Valid Anagram
    // Given two strings s and t, return true if t is an anagram of s,
    // and false otherwise.

    static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] letterOccurenceS = new int[26];
        int[] letterOccurenceT = new int[26];

        for ( int i = 0; i < s.length(); i++) {
            letterOccurenceS[(int) s.charAt(i) - 97] ++;
            letterOccurenceT[(int) t.charAt(i) - 97] ++;
        }

        for (int j = 0; j < 26; j++) {
            if (letterOccurenceS[j] != letterOccurenceT[j]) {
                return false;
            }
        }

        return true;
    }


    // 389. Find the Difference
    // You are given two strings s and t.
    // String t is generated by random shuffling string s and then add one
    // more letter at a random position.
    // Return the letter that was added to t.

    static char findTheDifference(String s, String t) {
        int[] letterOccurenceS = new int[26];
        int[] letterOccurenceT = new int[26];

        for ( int i = 0; i < s.length(); i++) {
            letterOccurenceS[(int) s.charAt(i) - 97] ++;
            letterOccurenceT[(int) t.charAt(i) - 97] ++;
        }


        for (int j = 0; j < 26; j++) {
            if (letterOccurenceS[j] < letterOccurenceT[j]) {
                int x = j + 97;
                char solution = (char) x;
                System.out.println(solution);
                return solution;
            }
        }


        return t.charAt(t.length() - 1);
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
