public class tmp {
    public static void main(String[] args) {

        int[] intarray = {9,1,4,7,3,8,3,5,2,};

        int legnth = intarray.length;

        for (int i = 1; i < legnth; i++) {

            int currentIndex = i;

            while (intarray[currentIndex] < intarray[currentIndex-1] && currentIndex >= 1) {
                int tmp = intarray[currentIndex];
                intarray[currentIndex] = intarray[currentIndex-1];
                intarray[currentIndex-1] = tmp;
                if (currentIndex > 1) {
                    currentIndex--;
                }
            }
        }

        for(int i: intarray) {
            System.out.println(i);
        }



    }

}
