public class Rectangle {

    private int width;
    private int height;


    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    int area() {
        return this.width * this.height;
    }

    int perimeter() {
        return 2 * this.width + 2 * this.height;
    }

    boolean isSquare() {
        return this.width == this.height;
    }

    @Override
    public String toString() {
        String string_representatin = "";

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                string_representatin += "* ";
            }
            string_representatin += "\n";
        }

        return string_representatin;
    }
}
