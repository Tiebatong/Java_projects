import java.util.*;


class Leetcode_tmp {

    static void main() {

        int[] nums = {1,1}; // 28.12.1025

        String bottom = "ABCD";
        List<String> allowed = new ArrayList<>();

        String [] strArr = {"ABC","BCA","CDA","ABD","BCE","CDF","DEA","EFF","AFF"};

        for (String s: strArr) {
            allowed.add(s);
        }

        System.out.println(pyramidTransition(bottom, allowed));

    }


    // 756. Pyramid Transition Matrix
    //https://leetcode.com/problems/pyramid-transition-matrix/description/?envType=daily-question&envId=2025-12-29

    static boolean pyramidTransition(String bottom, List<String> allowed) {
        boolean constructable = false;
        int bottomLength = bottom.length();
        String bottomRow = bottom;

        char L = ' ';
        char R = ' ';

        for (int i = bottomLength; i > 1; i--) {
            int currentRowLength = i - 1;

            String newBottomRow = "";
            for (int j = 0; j < currentRowLength; j++) {
                L = bottomRow.charAt(j);
                R = bottomRow.charAt(j + 1);


                for (int k = 0; k < allowed.size(); k++) {

                    if (allowed.get(k).charAt(0) == L && allowed.get(k).charAt(1) == R) {
                        newBottomRow +=  allowed.get(k).charAt(2);
                        constructable = true;
                        break;
                    } else {
                        constructable = false;
                    }
                }


            }
            if (!constructable) {

            }

            bottomRow = newBottomRow;

        }


        return constructable;
    }



    /*
    1351. Count Negative Numbers in a Sorted Matrix
    Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
    return the number of negative numbers in grid.
     */

    static int countNegatives(int[][] grid) {
        int negativeCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] < 0) {
                negativeCount += n * (m - i);
                break;
            }
            for (int j = 1; j < n; j++) {
                if (grid[i][j] < 0) {
                    negativeCount += n - j;
                    break;
                }
            }
        }

        return negativeCount;
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int j = 1; j <= n; j++) {
            if (!set.contains(j)) {
                list.add(j);
            }
        }
        return list;
    }

        /*
    Q2. How Many Numbers Are Smaller Than the Current Number

    Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
    That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
    Return the answer in an array.
     */

    static int[] smallerNumbersThanCurrent(int[] nums) {

        int length = nums.length;
        int[] ocorrenceArr = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[j] < nums[i]) {
                    ocorrenceArr[i]++;
                }
            }
        }
        return ocorrenceArr;

    }

    /*
    Q1. Set Mismatch

    You have a set of integers s, which originally contains all the numbers from 1 to n.
    Unfortunately, due to some error, one of the numbers in s got duplicated to another number
    in the set, which results in repetition of one number and loss of another number.
    You are given an integer array nums representing the data status of this set after the error.
    Find the number that occurs twice and the number that is missing and return them in the form of an array.
     */

    static int[] findErrorNums(int[] nums) {

        int[] numArr = new int[2];
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int occurence = 1;
            if(map.containsKey(nums[i])) {
                occurence++;
                numArr[0] = nums[i];
            }
            map.put(nums[i], occurence);


        }

        for ( int j = 1; j <= n; j++) {
            if (!map.containsKey(j)) {
                numArr[1] = j;
            }
        }
        System.out.println(map);



        return numArr;
    }

    // 709. To Lower Case

    // Given a string s, return the string after replacing every
    // uppercase letter with the same lowercase letter.

    static String toLowerCase(String s) {
        String lowerCase = "";
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                char replaced = (char) ((int)s.charAt(i) + 32);
                lowerCase += replaced;
            } else {
                lowerCase += s.charAt(i);
            }
        }

        return lowerCase;
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
    // Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right]
    // (both inclusive).

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
