class point2D {
    double x;
    double y;

    point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    point2D() {
        this.x = 0;
        this.y = 0;
    }

    void print(/*point2D this*/) {
        System.out.println(this.x + " " + this.y);
    }

    void subtract(/*point2D this*/point2D other) {
        this.x = this.x - other.x;
        this.y = this.y - other.y;
    }
}
