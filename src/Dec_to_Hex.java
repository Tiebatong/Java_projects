public class Dec_to_Hex {
    public static void main(String[] args) {

        int x = -99;

        char y = hex(x)[0];
        System.out.println(y);
        System.out.println(hex(x));

    }
    public static char[] hex(int x) {

        char[] hex_digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hex = {' ', ' '};
        if (x < 0) {
            x = 256 + x; // twos complement
        }


        int i = 1;
        while (x > 0) {
            hex[i] = hex_digits[x % 16];
            x /= 16;
            i--;
        }


        return hex;
    }

}


