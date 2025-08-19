public class Leetcode_125 {
    public static void main(String[] args) {
        String s = "0P";
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
        System.out.println(palindrom);

    }

}
