
public class tmp {
    public static void main() {

        Rectangle rectangle = new Rectangle(5, 3);
        Rectangle square = new Rectangle(2, 2);
        System.out.println(rectangle.isSquare());
        System.out.println(rectangle.perimeter());
        System.out.println(rectangle.area());
        System.out.println(rectangle.toString());
        System.out.println(square.isSquare());
        System.out.println(square);
    }

    public static int fac(int x) {
        if (x > 1) {
            return x * fac(x - 1);
        } else {
            return 1;
        }

    }
}
