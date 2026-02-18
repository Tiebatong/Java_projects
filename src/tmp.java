
public class tmp {
    public static void main() {

        Cylinder c0 = new Cylinder(2, 2);
        Cylinder c1 = new Cylinder(3, 6);
        Cylinder c2 = new Cylinder(7, 12);
        Cylinder c3 = new Cylinder(3, 55);
        Cylinder c4 = new Cylinder(6, 7);
        Cylinder c5 = new Cylinder(2, 8);
        Cylinder c6 = new Cylinder(8, 89);
        Cylinder c7 = new Cylinder(12, 1);

        Cylinder[] Carr = {};

        Cylinder[] sorted = Cylinder.sorted(Carr);
        for (Cylinder c: sorted) {
            System.out.println(c.volume());
        }




    }

    static Cylinder[] merge(Cylinder[] A, Cylinder[] B) {

        int index_A = 0;
        int index_B = 0;
        int index_merged = 0;

        Cylinder[] merged = new Cylinder[A.length + B.length];

        while ( index_A < A.length || index_B < B.length) {

            if (index_A >= A.length) {
                merged[index_merged] = B[index_B];
                index_merged++;
                index_B++;
            } else if (index_B >= B.length) {
                merged[index_merged] = A[index_A];
                index_merged++;
                index_A++;
            } else if (A[index_A].volume() < B[index_B].volume()) {
                merged[index_merged] = A[index_A];
                index_merged++;
                index_A++;
            } else {
                merged[index_merged] = B[index_B];
                index_merged++;
                index_B++;
            }
        }

        return merged;
    }
}
