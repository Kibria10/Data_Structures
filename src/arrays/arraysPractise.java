package arrays;

public class arraysPractise {

    public static void main(String[] args) {
        int k[] = {1, 2, 3, 4, 5, 6, 7, 8, 0};
        // CompactCircularArray(k,3,8);

        int l[] = {84, 0, 0, 0, 10, 20, 30, 40, 45, 63, 73};
        BuxForwardPrintingCircularArray(l,4,6);
        ReversePrintingCircularArrayEvenNumbs(l, 4, 9);
        ReversePrintingCircularArray(l, 4, 9);

        int m []= {10,20,30,40,50,60,70,80,0,0};
        insert(m,3,2,7,100);

        int array1[] = {10,30,50,70,90};
        int array2[] = {100,80,60,40,20};
        merger(array1,array2);
    }

    public static int[] CompactCircularArray(int arr[], int start, int size) {
        int k = start;
        int l = size;
        int m = arr.length - l;
        int n = arr.length - m;
        int[] cir = new int[n];
        int j = k;
        for (int i = 0; i < l; i++) {
            cir[j] = arr[i];
            j = (j + 1) % cir.length;
        }

        System.out.println();
        for (int i = 0; i < cir.length; i++) {
            System.out.print(cir[i] + ", ");
        }

        return cir;
    }


    public static void BuxForwardPrintingCircularArray(int[] c, int start, int size) {
        int index = start;
        for (int i = 0; i < size; i++)  //i<c.length if we want to print the whole circular array
        {
            System.out.println("\n" + c[index]);
//            index++;
//            if (c.length == index) {
//                index = 0;
            //OR replace the above 3 lines with this one single mod line.
            // Example: (11%11=0; "anything less" than c.length % c.length = "anything less")
            index = (index +1) % c.length;
        }
    }


    public static void ReversePrintingCircularArrayEvenNumbs(int[] c, int start, int size) {
        int index = start;
        int end = (index + size - 1) % c.length;
        for (int i = 0; i < size; i++) {
            if (c[end] % 2 == 0 && c[end] != 0) {
                System.out.print("\n" + c[end]);
            }
            end--;
            if (end < 0) {
                end = c.length - 1;
            }
        }



    }

    public static void ReversePrintingCircularArray(int[] c, int start, int size) {
        int index = start;
        int end = (index + size - 1) % c.length;
        for (int i = 0; i < size; i++) {

            System.out.print("\n" + c[end]);
            end--;
            if (end < 0) {
                end = c.length - 1;
            }
        }
    }


    static void insert(int[]source, int start, int idx, int size, int value){ //s 3 2 7 100


       // if(size==source.length)
//
//        int shifts = size - idx; //5 = 7-2
//        int from = (start+size-1)%source.length; // 9 = (3+7-1)% 10
//        int to = (from+1)%source.length; // 1 = (10+1)%10
//        for (int i =0; i<shifts; i++){
//            source[to]=source[from];
//            to = from;
//            from = from-1;
//            if(from == -1)
//            {
//                from= source.length;
//            }
//        }
//        source[idx]= value;

            int st = start;
            for (int i=source.length-2; i>=idx; i--){
                source[i+1]=source[i]; //shifting every elements after index clockwise 1 box to make space for the value on the given index
            }
            source[idx]= value;

        System.out.println("\nArray after insertion: " );
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + ", "); }

    }

    public static int[]  merger(int[]arr1, int[]arr2) //First Array1 values inside even indexes and array2 values inside odd indexes but reversely.
    {
        int k [] = new int[arr1.length+arr2.length];
        int j =0;
        for(int i = 0; i<k.length; i++){
        if (i%2==0) {
                k[i] = arr1[j];
            j++;
            }
        }
        int l=arr2.length-1;
        for(int i = 0; i<k.length; i++) {
            if (i % 2 != 0) {

                k[i] = arr2[l];
                l--;
            }
        }
        System.out.println("\nArray: " );
        for(int i = 0; i< k.length; i++){
            System.out.print(k[i] + ", "); }
        return k;
    }


}







