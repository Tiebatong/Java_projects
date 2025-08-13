public class Leetcode_67 {
    public static void main(String[] args) {
        String a = "1";
        String b = "11";


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
        System.out.println(sb.reverse().toString());


    }
}
