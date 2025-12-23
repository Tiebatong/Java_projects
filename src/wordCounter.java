class wordCounter {

    static void main(String[] args) {

        String text = args[0];

        String[] wörter = text.split(" ");

        System.out.println(java.util.Arrays.toString(wörter));


    }
}
