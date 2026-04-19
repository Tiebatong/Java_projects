import java.util.*;


public class Leetcode_all {

    public static void main(String[] args) {


        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println();


    }

    // 36. Valid Sudoku

    public static boolean isValidSudoku(char[][] board) {


        HashMap<>

        return true;
    }

    // 1855. Maximum Distance Between a Pair of Values

    public static int maxDistance(int[] nums1, int[] nums2) {

        int max_distance = 0;

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {
                max_distance = Math.max(max_distance, j - i);
                j++;
            } else {
                i++;
            }
        }

        return max_distance;
    }

    // 238. Product of Array Except Self

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] solution = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        int prefix_sum = 1;
        int postfix_sum = 1;

        for (int i = 0; i < n; i++) {

            prefix_sum = prefix_sum * nums[i];
            prefix[i] = prefix_sum;

            postfix_sum = postfix_sum * nums[n - 1 - i];
            postfix[n - 1 - i] = postfix_sum;

        }

        for (int i = 1; i < n - 1; i++) {
            solution[i] = prefix[i - 1] * postfix[i + 1];
        }

        solution[0] = postfix[1];
        solution[n - 1] = prefix[n - 2];


        return solution;

    }

    // 3783. Mirror Distance of an Integer

    public static int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int reversed = Integer.parseInt(sb.reverse().toString());
        return Math.abs(n - reversed);
    }

    // 3761. Minimum Absolute Distance Between Mirror Pairs

    public static int minMirrorPairDistance(int[] nums) {

        int length = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int distance = 1000000; // beliebig hoch zum vergleichen

        for (int i = 0; i < length; i++) {

            int element = nums[i];
            if (!map.containsKey(element)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(element, list);
            } else {
                map.get(element).add(i);
            }
        }

        for (int i = 0; i < length - 1; i++) {
            int element = reverseInt(nums[i]);
            List<Integer> list = map.get(element);
            if (list != null) {
                for (int j = 0; j < list.size(); j++) {

                    if (list.get(j) > i) {
                        int tmp = Math.abs(i - list.get(j));
                        if (tmp < distance) {
                            distance = tmp;
                            if (distance == 1) {
                                return 1;
                            }
                        }
                        continue;
                    }
                }
            }
        }

        if (distance == 1000000) {
            return -1;
        }

        return distance; //tmp
    }

    // Hilfsmethode für 3761 ^
    public static int reverseInt(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        return Integer.parseInt(sb.reverse().toString());
    }

    // 3488. Closest Equal Element Queries

    public static List<Integer> solveQueries(int[] nums, int[] queries) {

        List<Integer> answer_list = new ArrayList<>(queries.length);
        HashMap<Integer, List<Integer>> map = new HashMap<>();


        // weist jeder einzigartigen Zahl ihre Indices zu
        for (int i = 0; i < nums.length; i++) {

            int element = nums[i];
            if (!map.containsKey(element)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(element, list);
            } else {
                map.get(element).add(i);
            }
        }

        for (int q: queries) {
            int value = nums[q];
            List<Integer> list = map.get(value);
            if (list.size() == 1) {
                answer_list.add(-1);
                continue;
            }
            int index = Collections.binarySearch(list, q);
            int size = list.size();

            int left = list.get((index - 1 + size) % size);
            int right = list.get((index + 1) % size);
            int left_distance = Math.min(Math.abs(q - left), nums.length - Math.abs(q - left));
            int right_distance = Math.min(Math.abs(q - right), nums.length - Math.abs(q - right));
            answer_list.add(Math.min(left_distance, right_distance));
        }

        return answer_list;

    }

    // 2515. Shortest Distance to Target String in a Circular Array

    public static int closestTarget(String[] words, String target, int startIndex) {

        int left = startIndex;
        int right = startIndex;
        for (int i = 0; i < words.length; i++) {

            if (words[left].equals(target)) {
                return i;
            }

            if (words[right].equals(target)) {
                return i;
            }

            if (i == words.length - 1) {
                return -1;
            }

            if (right == words.length - 1) {
                right = -1;
            }

            if (left == 0) {
                left = words.length;
            }


            right++;
            left--;
        }
        return -1;
    }

    // 347. Top K Frequent Elements

    public static int[] topKFrequent(int[] nums, int k) {

        int[] top_elements = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i: nums) {

            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int max_value = -9999999;
        int max_value_key = -1;
        int index = 0;

        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() >= max_value) {
                    max_value = entry.getValue();
                    max_value_key = entry.getKey();
                }
            }
            map.remove(max_value_key);
            top_elements[index] = max_value_key;
            index++;
            max_value = -9999999;
        }


        return top_elements;
    }

    // 49. Group Anagrams

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();


        for (String s: strs) {
            char[] s_array = s.toCharArray();
            Arrays.sort(s_array);
            String str = String.valueOf(s_array);

            if (!map.containsKey(str)) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(str, list);
            } else {
                map.get(str).add(s);
            }

        }

        return new ArrayList<>(map.values());
    }

    // 3516. Find Closest Person

    public static int findClosest(int x, int y, int z) {
        int x_distance = z - x;
        int y_distance = z - y;

        if (x_distance < 0) {
            x_distance *= -1;
        }
        if (y_distance < 0) {
            y_distance *= -1;
        }

        if (x_distance > y_distance) {
            return 2;
        } else if (x_distance < y_distance){
            return 1;
        } else {
            return 0;
        }
    }

    // 3195. Find the Minimum Area to Cover All Ones I

    public static int minimumArea(int[][] grid) {

        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        boolean bool = true;

        for (int i = 0; i < grid.length; i++) {
            if (!bool){
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;


        for (int i = grid.length - 1; i >= 0; i--) {
            if (!bool){
                break;
            }
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bottom = i + 1;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;

        for (int j = 0; j < grid[0].length; j++) {
            if (!bool){
                break;
            }
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    left = j;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;

        for (int j = grid[0].length - 1; j >= 0; j--) {
            if (!bool){
                break;
            }
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    right = j + 1;
                    bool = false;
                    break;

                }
            }
        }
        bool = true;



        return (right - left) * (bottom - top);

    }

    // 3025. Find the Number of Ways to Place People I

    public static int numberOfPairs(int[][] points) {


        int rectangle_count = 0;

        boolean blocked = false;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {

                if (i == j) continue;

                if (points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                    blocked = false;
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j) continue;
                        if (points[k][0] <= points[j][0] && points[k][1] >= points[j][1] && points[k][0] >= points[i][0] && points[k][1] <= points[i][1]) {
                            blocked = true;
                        }
                    }
                    if (!blocked) {
                        rectangle_count++;
                    }
                }



            }

        }
        return rectangle_count;
    }

    // 3000. Maximum Area of Longest Diagonal Rectangle

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int diagonal = 0;
        int tmp = 0;
        int area = 0;
        int x = 0;
        for (int i = 0; i < dimensions.length; i++) {
            tmp = (dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1] * dimensions[i][1]);
            if (tmp > diagonal) {
                diagonal = tmp;
                area =  dimensions[i][0] * dimensions[i][1];
            } else if (tmp == diagonal && dimensions[i][0] * dimensions[i][1] > area) {
                area = dimensions[i][0] * dimensions[i][1];
            }
        }

        return area;
    }

    // 2348. Number of Zero-Filled Subarrays

    public static long zeroFilledSubarray(int[] nums) {
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

        return result;
    }

    // 2264. Largest 3-Same-Digit Number in String

    public static String largestGoodInteger(String num) {

        String solution = "";
        String substring = num.substring(0, 3);
        int i = 0;
        do {
            substring = num.substring(i, i + 3);
            if (substring.charAt(0) == substring.charAt(1) && substring.charAt(1) == substring.charAt(2)) {

                if (solution == "") {
                    solution = substring;
                } else if (Integer.valueOf(solution) < Integer.valueOf(substring)) {
                    solution = substring;
                }

            }
            i++;
        } while (i < num.length() - 2);

        return solution;
    }

    // 1792. Maximum Average Pass Ratio

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = gain(a[0], a[1]);
            double gainB = gain(b[0], b[1]);
            return Double.compare(gainB, gainA);
        });

        for (int[] c : classes) {
            pq.add(c);
        }

        while (extraStudents > 0) {
            int[] best = pq.poll();
            best[0]++;
            best[1]++;
            pq.add(best);
            extraStudents--;
        }

        double pass = 0;
        for (int[] c : pq) {
            pass += (double) c[0] / c[1];
        }

        pass /= classes.length;
        return pass;
    }
    private static double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double) pass / total;
    }

    // 1716. Calculate Money in Leetcode Bank

    public static int totalMoney(int n) {
        int start_value = 0;
        int balance = 0;
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (i % 7 == 0 && i != 0) {
                counter++;
                start_value = counter;
            }
            start_value ++;
            balance += start_value;
        }
        return balance;
    }

    // 1518. Water Bottles

    public static int numWaterBottles(int numBottles, int numExchange) {
        int empty_bottles = 0;
        int max_drinks = 0;

        while(numBottles > 0) {
            max_drinks += numBottles;
            empty_bottles += numBottles;
            numBottles = 0;
            numBottles += empty_bottles / numExchange;
            empty_bottles -= numBottles * numExchange;
        }
        return max_drinks;
    }

    // 1493. Longest Subarray of 1's After Deleting One Element

    public static int longestSubarray(int[] nums) {

        int[] sub_arr = new int[nums.length + 1];

        boolean bool_ones = false;

        int j = 0;
        int counter = 0;
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                bool_ones = true;
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
        if (!bool_ones) {
            return nums.length - 1;
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

        return summe;
    }

    // 1323. Maximum 69 Number

    public static int maximum69Number (int num) {
        int zwischen = num;
        int tmp;
        int i = 0;
        int j = 999;
        while (num > 0) {
            tmp = num % 10;
            num /= 10;
            if (tmp == 6) {
                j = i;
            }
            i++;
        }
        if (j == 999) {
            return zwischen;
        }
        int factor = 3;
        for (int x = 0; x < j; x++) {
            factor = factor * 10;
        }

        zwischen += factor;
        return zwischen;
    }

    // 498. Diagonal Traverse

    public static int[] findDiagonalOrder(int[][] mat) {
        // Lukas is schlau & groß

        int[] output = new int[mat.length * mat[0].length];
        int i = 0;
        int j = 0;
        boolean up = true;
        int counter = 0;

        while (counter < output.length) {

            while (up && counter < output.length) {
                output[counter] = mat[i][j];
                counter++;

                if (j == mat[0].length - 1) { // rechts, ecke
                    i++;
                    up = false;
                }
                else if (i == 0) { // oben, nicht ecke
                    j++;
                    up = false;
                }
                else {
                    i = i - 1;
                    j = j + 1;
                }


            }

            while (!up && counter < output.length) {
                output[counter] = mat[i][j];
                counter++;

                if (i == mat.length - 1) { // unten, ecke
                    j++;
                    up = true;
                }
                else if (j == 0) { // links, nicht unten
                    i++;
                    up = true;
                } else
                {
                    i = i + 1;
                    j = j - 1;
                }

            }
        }
        return output;

    }

    // 344. Reverse String

    public static void reverseString(char[] s) {
        char tmp = ' ';
        int j = s.length - 1;
        for (int i = 0; i < (s.length / 2); i++) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            j--;
        }
    }

    // 342. Power of Four

    public static boolean isPowerOfFour(int n) {

        if (n > 0) {
            for (int i = 0; i < 32; i++) {
                if (Math.pow(4, i) == n) {
                    return true;
                }
            }
        }

        return false;

    }

    // 326. Power of Three

    public static boolean isPowerOfThree(int n) {

        return n > 0 && 1162261467 % n == 0;

    }

    // 231. Power of Two

    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 32; i ++) {
            if (n == (Math.pow(2, i))) {
                return true;
            }
        }
        return false;

    }

    // 125. Valid Palindrome

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) - '0' >= 0 &&  s.charAt(i) - '0' <= 9) {
                sb.append(s.charAt(i));
            }
        }
        int j = sb.length() - 1;
        boolean palindrom = true;
        for (int i = 0; i < (sb.length() / 2); i++) {
            if (Character.toLowerCase(sb.charAt(i)) != Character.toLowerCase(sb.charAt(j))) {
                palindrom = false;
            }
            j--;
        }
        return palindrom;
    }

    // 118. Pascal's Triangle

    public static List<List<Integer>> generate(int numRows) {

        ArrayList<List<Integer>> list = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> name = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    name.add(1);
                } else {
                    int c = (list.get(i - 1).get(j - 1)) + (list.get(i - 1).get(j));
                    name.add(j, c);
                }
            }
            list.add(name);
        }
        return list;

    }

    // 67. Add Binary

    public int mySqrt(int x) {


        if (x < 1) {
            return x;
        }


        double approximation;
        int base = binary_search(x);
        return base;
        //double n = Math.pow(base + 1, 2) - x;
        //double m = Math.pow(base, 2) - x;
        //approximation =  base + (x - Math.pow(base, 2)) / (base * 2);
        //int rounded = (int) Math.floor(approximation);
        //return rounded;

    }
    private static int binary_search(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if ( carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // 66. Plus One

    public static int[] plusOne(int[] digits) {


        for ( int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    // 58. Length of Last Word

    public static int lengthOfLastWord(String s) {

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start --;
        }
        return (end - start);

    }

    // 35. Search Insert Position

    public int searchInsert(int[] nums, int target) {
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }

        if (target <= nums[0]) {
            return 0;
        } else if (target >= nums[nums.length - 1]) {
            return nums.length;
        }

        if (!found) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= target && target <= nums[j + 1]) {
                    return j + 1;
                }
            }
        }
        return 0;

    }

    // 28. Find the Index of the First Occurrence in a String

    public static int strStr(String haystack, String needle) {

        String substring;
        if (needle.equals(haystack)) {
            return 0;
        }

        for ( int i = 0; i <= haystack.length() - needle.length(); i++) {
            substring = haystack.substring(i, i + needle.length());
            if ( substring.equals(needle)) {
                return i;
            }
        }

        return -1;


    }

    // 27. Remove Element

    public static int removeElement(int[] nums, int val) {
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

        return k;

    }

    // 26. Remove Duplicates from Sorted Array

    public int removeDuplicates(int[] nums) {

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

        return k;

    }

    // 14. Longest Common Prefix

    public static String longestCommonPrefix(String[] strs) {

        String output;

        if (strs.length == 0) {
            output = "";
        } else {
            output = strs[0];
        }


        for (int i = 0; i < strs.length; i++) {

            while (!strs[i].startsWith(output)) {
                output = output.substring(0, output.length() -1);
            }


        }

        return output;
    }

    // 9. Palindrome Number

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int counter = 0;
        char[] char_array = String.valueOf(x).toCharArray();
        int j = char_array.length - 1;
        for ( int i = 0; i < char_array.length; i++) {
            if ( char_array[i] == char_array[j]) {
                counter++;
            }
            j--;
        }
        if (counter == char_array.length) {
            return true;
        } else {
            return false;
        }

    }

    // 7. Reverse Integer

    public static int reverse(int x) {

        int max_32_bit = 2147483647;
        int min_32_bit = -2147483648;
        if (x == min_32_bit || x == min_32_bit) {
            return 0;
        }

        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > max_32_bit / 10 || result < min_32_bit / 10) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }

    // 1. Two Sum

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }

    // 242. Valid Anagram

    public static boolean isAnagram(String s, String t) {


        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);

        return Arrays.equals(s_arr, t_arr);
    }

    // 217. Contains Duplicate

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i: nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }

        }

        return false;
    }

    // 88. Merge Sorted Array

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    // Data structures Stack Q2. Evaluate Reverse Polish Notation

    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int operand_1 = Integer.parseInt(stack.pop());
                int operand_2 = Integer.parseInt(stack.pop());

                int value = 0;
                switch (tokens[i]) {
                    case "+":
                        value = operand_2 + operand_1;
                        break;
                    case "-":
                        value = operand_2 - operand_1;
                        break;
                    case "*":
                        value = operand_2 * operand_1;
                        break;
                    case "/":
                        value = operand_2 / operand_1;
                        break;
                }

                String to_push = value +"";
                stack.push(to_push);
            } else {
                stack.push(tokens[i]);
            }

        }

        return Integer.parseInt(stack.pop());

    }

    // Data structures Stack Q1. Build an Array With Stack Operations

    public static List<String> buildArray(int[] target, int n) {

        List<String> list = new ArrayList<>();

        int i = 1;
        int j = 0;
        while (i < n + 1 && j < target.length) {
            if (target[j] == i) {
                list.add("Push");
                j++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
            i++;
        }
        return list;
    }

    // DQ: 657. Robot Return to Origin

    public static boolean judgeCircle(String moves) {

        int right = 0;
        int up = 0;

        for (char c: moves.toCharArray()) {
            switch (c) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
                case 'L':
                    right--;
                    break;
                case 'R':
                    right++;
                    break;
            }
        }

        return right == 0 && up == 0;

    }

    // DQ: 2075. Decode the Slanted Ciphertext
    // TIME LIMIT EXCEEDED

    public static String decodeCiphertext(String encodedText, int rows) {

        if (rows == 1) {
            return encodedText;
        }

        String decodedText = "";
        int columns = encodedText.length() / rows;
        int index = 0;
        String[][] mat = new String[rows][columns];

        // write to matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = encodedText.charAt(index) + "";
                index++;
            }
        }
        // read from matrix


        int j = 0;
        for (int k = 0; k < columns; k++) {
            int i = 0;
            j = k;

            while (i < rows && j < columns) {
                decodedText += mat[i][j];
                i++;
                j++;
            }
        }



        String rightRemoved = decodedText.replaceAll("\\s+$", "");
        return rightRemoved;


    }

    // 2839. Check if Strings Can be Made Equal With Operations I
    // Constraints: s1.length == s2.length == 4
    public static boolean canBeEqual(String s1, String s2) {


        if (!s1.equals(s2)) {
            String news2 = "";

        }


        return false;
    }

    // 1207. Unique Number of Occurrences

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i: arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer i: map.values()) {
            if (!set.add(i)) {
                return false;
            }
        }

        return true;
    }

    // 1009. Complement of Base 10 Integer

    public static int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        String newS = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                newS += "0";
            } else {
                newS += "1";
            }
        }
        return Integer.parseInt(newS, 2);
    }

    // 1732. Find the highest Altitude

    public static int largestAltitude(int[] gain) {

        int altitude = 0;
        int highest_altitude = 0;

        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            if (altitude > highest_altitude) {
                highest_altitude = altitude;
            }
        }
        return highest_altitude;
    }

    // 1980. Find Unique Binary String

    public static String findDifferentBinaryString(String[] nums) {

        int length = nums.length;
        HashSet<Integer> set = new HashSet<>();


        for (int i = 0; i < length; i++) {
            set.add(Integer.parseInt(nums[i], 2));
        }

        int current = 0;
        while (set.contains(current)) {
            current++;
        }
        String solution =  Integer.toBinaryString(current);

        String tmp = "";
        for (int i = solution.length(); i < length; i++) {
            tmp += "0";
        }

        return tmp + solution;

    }

    // 6. Zigzag Conversion

    public static String convert(String s, int numRows) {
        String converted = "";

        int len = s.length();

        if (numRows == 1) {
            return s;
        }

        if (len <= numRows) {
            return s;
        }
        String [][] mat = new String[numRows][len/2 + 1];

        int counter = 0;
        int i = 0;
        int j = 0;
        boolean down = true;
        while (counter < len) {
            mat[i][j] = s.charAt(counter) + "";


            if (down) {
                i++;
            } else {
                j++;
                i--;
            }

            if (i == 0) {
                down = true;
            } else if (i >= numRows - 1) {
                down = false;
            }
            counter++;
        }

        while (converted.length() < len) {
            for (i = 0; i < mat.length; i++) {
                for (j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != null) {
                        converted += mat[i][j];
                    }
                }
            }
        }

        return converted;
    }

    // 1784. Check if Binary String Has at Most One Segment of Ones

    public static boolean checkOnesSegment(String s) {

        for (int i = 1; i < s.length() - 1; i++) { // i = 1, weil die erste Stelle immer = 1, muss nicht geprüft werden
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                return false;
            }
        }
        return true;
    }

    // 1071. Greatest Common Divisor of Strings

    static String gcdOfStrings(String str1, String str2) {

        String gcd = ""; // greatest common divisor

//        for (int i = 0; i < )


        return gcd;

    }

    // 643. Maximum Average Subarray I

    public static double findMaxAverage(int[] nums, int k) {


        int current_avarage = 0;

        for (int j = 0; j < k; j++) {
            current_avarage += nums[j];
        }
        int n = nums.length;
        double maximum_avarage = current_avarage;
        for (int i = k; i < n; i++) {
            current_avarage -= nums[i - k];
            current_avarage += nums[i];
            if (current_avarage > maximum_avarage) {
                maximum_avarage = current_avarage;
            }
        }

        return maximum_avarage / k;

    }

    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int special_ocurrence = 0;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    special_ocurrence++;
                }
            }
        }

        return special_ocurrence;
    }

    //1431. Kids With the Greatest Number of Candies

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> out = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                out.add(true);
            } else {
                out.add(false);
            }
        }

        return out;
    }

    // 345. Reverse Vowels of a String

    public static  String reverseVowels(String s) {

        char[] charArr = s.toCharArray();

        int leftIndex = 0;
        int rightIndex = s.length()-1;

        boolean leftVowel = false;
        boolean rightVowel = false;

        while (leftIndex <= rightIndex) {

            char left = charArr[leftIndex];
            char right = charArr[rightIndex];

            if ("AEIOUaeiou".indexOf(left) != -1) {
                leftVowel = true;
            } else {
                leftIndex++;
            }

            if ("AEIOUaeiou".indexOf(right) != -1) {
                rightVowel = true;
            } else {
                rightIndex--;
            }

            if (rightVowel && leftVowel) {
                char tmp = charArr[leftIndex];
                charArr[leftIndex] = charArr[rightIndex];
                charArr[rightIndex] = tmp;
                leftIndex++;
                rightIndex--;
                leftVowel = false;
                rightVowel = false;
            }

        }

        String reversed = "";

        for (char c: charArr) {
            reversed += c;
        }

        return reversed;
    }

    // 392. Is Subsequence

    static boolean isSubsequence(String s, String t) {
    String needelString = "";
        int j = 0;
        for (int i = 0; i <s.length(); i++) {
            char needle = s.charAt(i);

            while (j < t.length()){
                if (needle == t.charAt(j)) {
                    needelString += t.charAt(j);
                    j++;
                    break;
                }
                j++;
            }
    
        }
        if (needelString.equals(s)) {
            return true;
        }

        return false;

    }

    // 1390. Four Divisors
    // Given an integer array nums, return the sum of divisors of the integers in that array
    // that have exactly four divisors. If there is no such integer in the array, return 0.

    static int sumFourDivisors(int[] nums) {

        int sum = 0;
        for(int n: nums) {

            int increment = 0;

            if (n % 2 == 0) {
                increment = 1;
            } else {
                increment = 2;
            }

            int currentSum = 0;
            int divisorCount = 0;

            for (int i = 1; i < n+1; i += increment) {
                if (n % i == 0) {
                    currentSum += i;
                    divisorCount++;
                }

                if (divisorCount > 4) {
                    break;
                }
            }

            if (divisorCount == 4) {
                sum += currentSum;
            }
        }
        return sum;
    }

    // 961. N-Repeated Element in Size 2N Array

    static int repeatedNTimes(int[] nums) {

        HashSet<Integer> hashset = new HashSet<>();

        for (int i: nums) {
            if (hashset.contains(i)) {
                return i;
            }
            hashset.add(i);
        }
        return 1;

    }



    // 443. String Compression

    static int compress(char[] chars) {

        int currentCount = 1;
        String s = "";
        for (int i = 0; i < chars.length-1; i++) {

            if (chars[i] == chars[i+1]) {
                currentCount++;
            } else {
                s += chars[i];
                if (currentCount > 1) {
                    s += currentCount;
                }
                currentCount = 1;
            }

        }
        s += chars[chars.length-1];
        if (currentCount > 1) {
            s += currentCount;
        }
//        System.out.println("s: " + s);

        int i = 0;
        while (i < s.length() && i < chars.length) {
            chars[i] = s.charAt(i);
            i++;
        }


//        for(char c: chars) {
//            System.out.print(c + ", ");
//        }
        return s.length();
    }

    // 605. Can Place Flowers

    static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int flowersPlaced = 0;
        int legth = flowerbed.length;

        if (n == 0) {
            return true;
        }

        if (legth < 3) {
            int ones = 0;
            for (int i = 0; i < legth; i++) {
                if (flowerbed[i] == 1) {
                    ones++;
                }
            }
            if (ones == 0 && n == 1) {
                return true;
            } else {
                return false;
            }

        } else {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowersPlaced++;
                flowerbed[0] = 1;
            }

            if (flowerbed[legth-1] == 0 && flowerbed[legth-2] == 0) {
                flowersPlaced++;
                flowerbed[legth-1] = 1;
            }

            for (int i = 1; i < legth - 1; i++) {
                if (flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowersPlaced++;
                    flowerbed[i] = 1;
                }
            }

        }



        return (n <= flowersPlaced);
    }

    // 2215. Find the Difference of Two Arrays

    static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> answer = new ArrayList<>();

        HashSet<Integer> hash1 = new HashSet<>();
        for (int n: nums1) {
            hash1.add(n);
        }

        HashSet<Integer> hash2 = new HashSet<>();
        for (int n: nums2) {
            hash2.add(n);
        }

        List<Integer> list1 = new ArrayList<>();
        for (int n: nums1) {
            if (!hash2.contains(n) && !list1.contains(n)) {
                list1.add(n);
            }
        }
        List<Integer> list2 = new ArrayList<>();
        for (int n: nums2) {
            if (!hash1.contains(n) && !list2.contains(n)) {
                list2.add(n);
            }
        }

        answer.add(list1);
        answer.add(list2);

        return answer;
    }



    // 151. Reverse Words in a String

    static String reverseWords(String s) {
        String reversed = "";

        String[] arr = s.trim().split(" ");

        for (int i = arr.length - 1; i > 0; i--) {

            if (!arr[i].equals("")) {
                reversed += arr[i] += " ";
            }
        }
        reversed += arr[0];

        return reversed;
    }

    /*
    1572. Matrix Diagonal Sum

    Given a square matrix mat, return the sum of the matrix diagonals.
    Only include the sum of all the elements on the primary diagonal and all the
    elements on the secondary diagonal that are not part of the primary diagonal.
     */

    static int diagonalSum(int[][] mat) {

        int sum = 0;
        int length = mat.length;

        for (int i = 0; i < length; i++) {
            sum += mat[i][i];
            if (length % 2 != 0 && i == (length / 2) ) {
                continue;
            }
            sum += mat[i][length - (i + 1)];
        }

        return sum;
    }

    /*
    840. Magic Squares In Grid

    A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
    Given a row x col grid of integers, how many 3 x 3 magic square subgrids are there?
    Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
     */

    static int numMagicSquaresInside(int[][] grid) {

        int perfectSquareCount = 0;


        int n = grid.length;
        int m = grid[0].length;

        if (n < 3 || m < 3) {
            return 0;
        }

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                HashSet<Integer> ocurence = new HashSet<>();
                boolean skip = false;

                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (ocurence.contains(grid[l][k]) || grid[l][k] > 9 || grid[l][k] <= 0) {
                            skip = true;
                        }
                        ocurence.add(grid[j][i]);
                    }
                }
                if (skip) {
                    continue;
                }
                int row1 = grid[j][i] + grid[j][i+1] + grid[j][i+2];
                int row2 = grid[j+1][i] + grid[j+1][i+1] + grid[j+1][i+2];
                int row3 = grid[j+2][i] + grid[j+2][i+1] + grid[j+2][i+2];

                int column1 = grid[j][i] + grid[j+1][i] + grid[j+2][i];
                int column2 = grid[j][i+1] + grid[j+1][i+1] + grid[j+2][i+1];
                int column3 = grid[j][i+2] + grid[j+1][i+2] + grid[j+2][i+2];

                int diagonal1 = grid[j][i] + grid[j+1][i+1] + grid[j+2][i+2];
                int diagonal2 = grid[j][i+2] + grid[j+1][i+1] + grid[j+2][i];

                if (row1 == row2 && row2 == row3 && row3 == column1 && column1 == column2 && column2 == column3 && column3 == diagonal1 && diagonal1 == diagonal2) {
                    perfectSquareCount++;
                }
            }
        }

        return perfectSquareCount;
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
