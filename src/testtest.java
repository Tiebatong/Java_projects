public class testtest {
    public static void main(String[] args) {

        int n = 17;

        boolean prime = true;
        for (int i = 1; i <= n; i++) {

            if(n % i == 0 && i != 1 && i != n) {
                prime = false;
                break;
            }
        }
        System.out.println(prime);


    }

}
