public class chess {

    static void main() {

        int n = 5;

        String chess_board = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x;
                if (i % 2 == 0) {
                    x = 0;
                } else {
                    x = 1;
                }

                if (j % 2 == x) {
                    chess_board += "*";
                } else {
                    chess_board += " ";
                }
            }
            chess_board += "\n";
        }
        System.out.println(chess_board);
    }
}
