import java.util.ArrayList;
import java.util.List;

public class Leetcode_202 {
    public static void main(String[] args) {
        int n = 2;
        boolean weiter = true;
        boolean loop = true;
        List<Integer> werte = new ArrayList<>();
        List<Integer> digit_list = new ArrayList<>();

        while (n != 1 && loop) {

            while (weiter) {
                digit_list.add(n % 10);
                n /= 10;
                if ( n == 0) {
                    weiter = false;
                }
            }

            for (int i = 0; i < digit_list.size(); i++) {
                n += digit_list.get(i) * digit_list.get(i);
            }
            for ( int j = 0; j < werte.size(); j++) {
                if (werte.get(j) == n) {
                    loop = false;
                }
            }
            werte.add(n);
            digit_list.clear();
            weiter = true;
            System.out.println(n);

        }
    }
}
