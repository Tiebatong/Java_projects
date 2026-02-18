record Cylinder(double r, double h) {


    double volume() {
        return Math.PI * (this.r * this.r) * this.h;
    }

    static Cylinder[] sorted(Cylinder[] array) {
        java.util.Objects.requireNonNull(array);
        return sort(array);
    }

    static Cylinder[] sort(Cylinder[] cylinders) {




        for (Cylinder c: cylinders) {
            java.util.Objects.requireNonNull(c);
        }
        if (cylinders.length == 1) {
            return cylinders;
        }
        Cylinder[] A = first_half(cylinders);
        Cylinder[] B = secend_half(cylinders);

        Cylinder[] arrA = sort(A);
        Cylinder[] arrB = sort(B);

        return merge(arrA, arrB);
    }

    static Cylinder[] first_half(Cylinder[] array) {
        int length = array.length / 2;

        Cylinder[] halfed = new Cylinder[length];
        for (int i = 0; i < length; i++) {
            halfed[i] = array[i];
        }
        return halfed;
    }

    static Cylinder[] secend_half(Cylinder[] array) {
        int length = array.length - array.length / 2;

        Cylinder[] halfed = new Cylinder[length];
        for (int i = 0; i < length; i++) {
            halfed[i] = array[i + array.length / 2];
        }
        return halfed;
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
