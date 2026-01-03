record Cylinder(double r, double h) {


    double volume() {
        return Math.PI * r * r * h;
    }

    static Cylinder[] sorted (Cylinder[] CylinderArr) {
        if (CylinderArr == null) {
            throw new NullPointerException("Array is null");
        }

        int legnth = CylinderArr.length;
        Cylinder[] sortedArray = CylinderArr.clone();

        for (int i = 1; i < legnth; i++) {

            int currentIndex = i;

            while (sortedArray[currentIndex].volume() < sortedArray[currentIndex-1].volume() && currentIndex >= 1) {
                Cylinder tmp = sortedArray[currentIndex];
                sortedArray[currentIndex] = sortedArray[currentIndex-1];
                sortedArray[currentIndex-1] = tmp;
                if (currentIndex > 1) {
                    currentIndex--;
                }

            }
        }

        return  sortedArray;
    }

    public static void main(String[] args) {


        Cylinder c0 = new Cylinder(13, 1);
        Cylinder c1 = new Cylinder(29, 7.5);
        Cylinder c2 = new Cylinder(5.2, 7);
        Cylinder c3 = new Cylinder(12.6, 9);
        Cylinder c4 = new Cylinder(4, 1);
        Cylinder c5 = new Cylinder(23.9, 1);
        Cylinder c6 = new Cylinder(7, 1.6);

        Cylinder[] CylinderArray = {c0,c1,c2,c3,c4,c5,c6};

        for(Cylinder c: CylinderArray) {
            System.out.println(c.volume());
        }

        Cylinder[] sortedArray = sorted(CylinderArray);

        System.out.println("===================");

        for(Cylinder c: sortedArray) {
            System.out.println(c.volume());
        }

    }
}
