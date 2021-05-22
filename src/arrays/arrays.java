package arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Kibria-17101319
 */
public class arrays {

    public static void main (String[]args)
    {
        //1
        int [] a =  {10, 20, 30, 40, 50, 60, 70};
        shiftLeft(a, 3);
        // 2
        int [] b = {10, 20, 30, 40, 50, 60, 70};
        rotateLeft(b, 3);
        //2
        int [] c =  {10, 20, 30, 40, 50, 0, 0, 0};

        insert(c, 3, 5, 500);
        //3
        int [] d =  {10, 20, 30, 40, 50, 0, 0, 0};

        remove(d, 2, 5);
        //4
        int [] e =  {10, 2, 30, 2, 50, 2, 2, 0, 0 };

        removeAllOccurence(e, 7, 2);
        //5
        int [] abc = {1,2,3,4,5,5};

        System.out.print(SplitArray(abc));
        //6
        ArraySeries(4);

        int [] f = {1, 2, 2, 3, 4, 4, 4,4 ,7,7,7,7,7 };
        //7
        MaxBunch(f);

        //8
        int [] rep = new int [] {1, 2, 8, 8, 8, 8, 3, 2, 2, 2, 5, 1};
        System.out.println(repetition(rep));

        //PALINDROME
        int[] yo = {10,20,30,40,30,20,10};
        System.out.print(Circularpalindrome(yo, 5, 4));

        //INTERSECTION
        arrays t = new arrays();
        int[]x= {40,50,10,20,30,7,0,0};
        int[]y= {10,20,5,5,40,15,25,7};
        t.InterSection(x,y);


    }

    //shift left  linear array
    static void shiftLeft(int[] source, int k){
        for(int i = 0; i < k; i++){
            int j, temp;
            temp = source[0];
            for(j = 0; j < source.length-1; j++){
                source[j] = source[j+1];
            }
            source[j] = 0;
        }
        System.out.println("\nArray after shifting left at the amount of " +k );
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + ", ");
        }
    }
    //rotate left  circular array
    static void rotateLeft(int[] source, int k){
        for(int i = 0; i < k; i++){
            int j, temp;
            temp = source[source.length-1];
            for(j = source.length-1; j >0; j--){
                source[j] = source[j-1];  }
            source[0] = temp;  }
        System.out.println("\nArray after rotating left at the amount of " +k );
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + ", "); }
    }

    //
    static void insert(int[]source, int idx, int size, int value){
        if (size ==source.length || idx < 0|| idx> size){
            System.out.println("/n Array space is Invalid");
        }
        else{
            for (int i=size-1; i>=idx; i--){
                source[i+1]=source[i];  //shifting every elements after index clockwise 1 box to make space for the value on the given index
            }
            source[idx]= value;
        }
        System.out.println("\nArray after insertion: " );
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + ", "); }


    }

    //
    static void remove(int[]source, int idx, int size){
        if (size ==source.length || idx < 0|| idx> size){
            System.out.println("/n Array space is Invalid");
        }
        else{
            for (int i=idx; i<=size; i++){
                source[i]=source[i+1];
            }
        }
        System.out.println("\nArray after removal: " );
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + ", "); }
    }



    //
    static void removeAllOccurence(int[]source, int size, int element){
        if (size ==source.length){
            System.out.println("/n Array space is Invalid");
        }
        else{
            for (int i=0; i<=size; i++){
                if (source[i]== element){
                    source[i]=0;
                }
            }
        }
        System.out.println("\nArray after removal: " );
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + ", "); }
    }


    //
    static boolean SplitArray(int array[])
    {
        int m = 0 ;
        for (int i = 0; i < array.length; i++) {
            m += array[i] ;
            int n = 0 ;
            for (int j = i+1 ; j < array.length; j++ )
                n += array[j] ;
            if (m == n)
                return true ;
        }
        return false;
    }


    //
    static void ArraySeries(int size){
        int [] arr = new int [size*size];
        int k=(size*size)-size;
        for(int i = size; i>0; i--){
            arr[k]=i;
            k++;
        }
        int l=(size*size)-(size+size);
        for(int i = size-1; i>=0; i--){
            arr[l]=i;
            l++;
        }
        int m=(size*size)-(size+size+size);
        for(int i = size-2; i>=0; i--){
            arr[m]=i;
            m++;
        }

        System.out.println("\nArraySeries: " );
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }

    //
    static void MaxBunch(int[]arr){
        int j=1; int k=0;
        int [] temp = new int [arr.length-2];
        for(int i =0; i<arr.length-1; i++){
            if (arr[i]== arr[i+1]) {
                j++;
            }
            else {
                temp[k]=j; k++; j=1;
            }
            temp[k]=j;
        }
        int max = temp[0];
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] > max)
                max = temp[i];
        }
        System.out.println("\nMAX_BUNCH_NUMBER: " + max);
    }


    ///
    public static boolean repetition(int[]arr) {
        boolean result = true;
        System.out.println("Repetition:");

        int [] fr = new int [arr.length];
        int vis = -1;
        for(int i = 0; i < arr.length; i++){
            int count = 1;
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                    fr[j] = vis;
                }
            }
            if(fr[i] != vis)
                fr[i] = count;
        }

        for(int i = 0; i < fr.length; i++){
            if(fr[i] != vis)  {
                System.out.println( fr[i]);}
        }


        for(int i = 0; i < fr.length; i++){
            for(int j = i+1; j < fr.length; j++){

                if(fr[i] == fr[j] && fr[i]>1)

                {
                    result = true;
                }
                else result = false;

            }



        }

        return result;

    }

    ///
    public static int[] CompactCircularArray(int arr[], int start, int size){
        int k= start;
        int l =size;
        int m= arr.length-l;
        int n = arr.length-m;
        int [] cir = new int [n];
        int j = k;
        for(int i = 0 ; i<l ; i++){
            cir[j] = arr[i];
            j = (j+1)%cir.length;
        }

//    System.out.println();
//    for(int i = 0; i< cir.length; i++){
//        System.out.print(cir[i] + ", ");
//  }
        return cir;
    }





    public static boolean Circularpalindrome(int[]arr, int start, int size){
//    Turning the linear array into a circular array
        int st = start;
//    int sz = size;
//    int z [] = new int[arr.length];
//    z = arr;
//    int main[] = CompactCircularArray(z, st, sz);
//    System.out.println();
//    System.out.println("Array after Compact Circular Array: ");
//    for(int i = 0; i< main.length; i++){
//        System.out.print(main[i] + ", ");
//        }
        System.out.print("\nPALINDROME RESULT:   ");
        boolean result = false;
        int k = (start+size-1)%arr.length; int temp = 0;
        for(int i = 0 ; i<size/2 ; i++){
            if(arr[st] == arr[k]){
                temp+=0;
            }
            else {
                temp+=1;
            }
            st++;
            if(st>arr.length){
                st = (start+size)%arr.length;
            }
            k--;
            if(k<0){
                k = arr.length-1;
            }
        }
        if (temp==0){
            result = true;
        }
        else if (temp!=0){
            result = false;
        }
        return result;
    }


    public static void InterSection(int[]x, int[]y){
        int x1[] = CompactCircularArray(x, 2, 6);
        int y1[] = CompactCircularArray(y, 2, 8);
        System.out.print("\nCircularArray FOR INTERSECTION:   ");
        System.out.println();
        System.out.println("Array1 after Compact Circular Array: ");
        for(int i = 0; i< x1.length; i++){
            System.out.print(x1[i] + ", ");
        }
        System.out.println();
        System.out.println("Array2 after Compact Circular Array: ");
        for(int i = 0; i< y1.length; i++){
            System.out.print(y1[i] + ", ");
        }

        System.out.println();

        for (int i = 0; i < x1.length; i++)
        {
            for (int j = 0; j < y1.length; j++)
            {
                if(x1[i] == (y1[j]))
                {
                    System.out.println("Common element is : "+(x1[i]));
                }
            }
        }
    }



}

//(LAB1 Extra Work)

//NORMAL CIRCULAT ARRAY

//    public static int[] circularArray(int a1[], int ind){
//
//        // Create an auxiliary array
//        // of twice size.
//        int n = a1.length;
//        int [] temp = new int[(2 * n)];
//        int [] temp2 = new int[(2 * n)];
//
//        // Copy a[] to b[] two times
//        for (int i = 0; i < n; i++) {
//            temp[i] = temp[n + i] = a1[i];
//            }
//
//        System.out.print("\nCircularArray:   ");
//        for (int i = ind; i < n + ind; i++){
//            System.out.print( temp[i]+" ");
//            for (int k = 0; i < temp2.length; k++){
//            temp2[k] = temp2[i];
//            }
//        }
//        return temp;
//    }



// Aa accidental code based on index-based circulating while creating circularArray

//	public static void circularArray(int x[], int ind){
//            int start =ind; //storing the starting point cause we need to increment it inside loop
//            int[] hola = new int [x.length];
//            //loop for storing new elements from starting index to end of the array
//            for(int i=0; i<(x.length)-ind;i++){
//            hola[i]=x[start];
//            start++;
//            }
//
//           //PS: comment out the below lines to see what it does (till l++;)
//            int l = x.length-ind; //from which index to put the rest of the elements on the new array
//            int m= ind-1; //how many elements were left to put in it
//            //loop for storing rest of the elements that was before the starting index.
//            for(int j=0;j<=m;j++){
//            hola[l]=x[j];
//            l++;
//                    }
//
//         //printing out the new array
//        for(int i = 0; i< hola.length; i++){
//        System.out.print(hola[i] + ", ");
//        }
//
//
//        }









