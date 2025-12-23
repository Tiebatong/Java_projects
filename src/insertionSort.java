public class insertionSort {
    void main() {

//        int[] unsorted = {2, 6, 8, 1, 1, 4, 8, 4, 5, 6, 2, 0, 8, -23};
//        int[] sorted = insertSort(unsorted);
//
//        for(int s: sorted) {
//            System.out.println(s);
//        }

        Studi s0 = new Studi("David", 72093);
        Studi s1 = new Studi("Jan", 23456);
        Studi s2 = new Studi("Hannes", 81734);
        Studi s3 = new Studi("Frank", 12);
        Studi[] studiarr = {s0, s1, s2, s3};
        insertSort(studiarr);

        Fahrad f0 = new Fahrad(299);
        Fahrad f1 = new Fahrad(234);
        Fahrad f2 = new Fahrad(746);
        Fahrad f3 = new Fahrad(123);
        Fahrad[] fahradarr = {f0, f1, f2, f3};
        insertSort(fahradarr);

        for (Fahrad f: fahradarr) {
            System.out.println(f);
        }

        for(Studi s: studiarr) {
            System.out.println(s);
        }

    }

    public static <E extends comparable<E>> void insertSort(E[] objects) {

        for (int i = 0; i < objects.length; i++) {
            E currentObject = objects[i];
            int insertionPosition = i;

            while(insertionPosition > 0 && currentObject.compare(objects[i - 1]) == -1) {
                objects[insertionPosition] = objects[insertionPosition - 1];
                insertionPosition--;
            }
            objects[insertionPosition] = currentObject;

        }

    }





    private static int[] insertSort(int[] toSort) {
        int[] sorted = toSort;

        for (int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < i; j++) {
                if (toSort[i] < sorted[j] ) {
                    int tmp = toSort[i];
                    toSort[i] = sorted[j];
                    sorted[j] = tmp;
                }
            }
        }

        return sorted;
    }



}
