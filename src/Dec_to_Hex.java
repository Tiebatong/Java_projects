public class Dec_to_Hex {
    public static void main(String[] args) {

        int x = -79;

        System.out.println(hex(x));

    }
    public static String hex(int x) {

        if (x < 0) {
            x = x + 256;
        }

        String hex = Integer.toHexString(x).toUpperCase();

        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

}


