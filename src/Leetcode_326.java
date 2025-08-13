public class Leetcode_326 {
    public static void main(String[] args) {

        int n = -1;

        for (int i = 0; i < 32; i++) {
            if (n == Math.pow(3, i)) {
                System.out.println(i);
            }
        }


    }
}
/*
326. Power of Three
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3^x.

Example 1:

Input: n = 27
Output: true
Explanation: 27 = 33
 */
