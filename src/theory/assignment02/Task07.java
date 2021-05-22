package theory.assignment02;

public class Task07 {
    public static int store = 0;
    public static int saved[];

    public int [] search(int array1[], int array2[], int l, int m) {

        if(saved==null){
            saved=new int[array2.length];
        }

        if (l < 0) {
            saved[m]=store;
            l = array1.length-1;
            m++;
            store =0;
        }
        if (m> array2.length-1){
            return saved;
        }
        if (array1[l] < array2[m]) {
            store++;
        }
        return search(array1, array2, l - 1, m );
    }

}

class runner {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 4, 10};
        int arr2[] = {3, 7, 2, 12};
        Task07 k = new Task07();
        int l = arr1.length - 1;
        int [] saved= k.search(arr1, arr2, l, 0);
        for (int i = 0; i < saved.length; i++) {
            System.out.println(saved[i]);
        }
    }
}