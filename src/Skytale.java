public class Skytale {
    static void main(String[] args) {

        // Input validierung

        if (args.length == 0) {
            System.out.println("ERROR no arguments provided");
        } else if (!(args[0].equals("E") || args[0].equals("D"))) {
            System.out.println("ERROR no mode provided");
        } else if (args.length != 2) {
            System.out.println("ERROR wrong number of arguments, must be 2");
        } else if (args[1].length() != 28) {
            System.out.println("ERROR message is wrong length");
        }

        String message = args[1];

        if (args[0].equals("E")) {
            System.out.println(endcode(message));
        } else {
            System.out.println(decode(message));
        }
    }

    static String endcode(String message) {
        String encoded = "";

        for (int i = 0; i < 7; i++) {
            int index = 0;
            for (int j = 0; j < 4; j++) {
                encoded += message.charAt(i + index);
                index += 7;
            }
        }
        return encoded;
    }

    static String decode(String message) {
        String decoded = "";
        for (int i = 0; i < 4; i++) {
            int index = 0;
            for (int j = 0; j < 7; j++) {
                decoded += message.charAt(i + index);
                index += 4;
            }
        }

        return decoded;
    }
}
