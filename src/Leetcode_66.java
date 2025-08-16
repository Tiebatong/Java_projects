public class Leetcode_66 {
    public static void main(String[] args) {

        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        int carry = 0;
        int length;
        int j = digits.length - 1;
        if (digits[0] == 9) {
            length = digits.length + 1;
        } else {
            length = digits.length;
        }

        int[] new_digits = new int[length];



        for (int i = length - 1; i >= 0; i--) {
            if (i == (new_digits.length - 1) && digits[j] != 9) {
                 new_digits [i] = digits[i] += 1;
            } else if (i == new_digits.length - 1 && digits[j] == 9) {
                new_digits[i] = 0;
                carry = 1;
            }
            if (j < 0 && carry > 0) {
                new_digits[0] = 1;
                break;
            } else if (j < 0 && carry > 0) {
                break;
            }
            if (digits[j] == 9) {
                carry = 1;
                new_digits[i] = 0;
            } else {
                new_digits[i] = digits[j] + carry;
                carry = 0;
            }
            j--;
        }
        for (int newDigit : new_digits) {
            System.out.println(newDigit);
        }

    }
}
