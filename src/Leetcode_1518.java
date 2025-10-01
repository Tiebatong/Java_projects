public class Leetcode_1518 {
    public static void main(String[] args) {

        int numBottles = 9;
        int numExchange = 3;

        int empty_bottles = 0;
        int max_drinks = 0;

        while(numBottles > 0) {
            max_drinks += numBottles;
            empty_bottles += numBottles;
            numBottles = 0;
            numBottles += empty_bottles / numExchange;
            empty_bottles -= numBottles * numExchange;
        }
        System.out.println(max_drinks);

    }
}
