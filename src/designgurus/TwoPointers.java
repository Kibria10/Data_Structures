package designgurus;

public class TwoPointers {

    public static int[] search(int [] arr, int target){
        int [] resultIndex =new int[2];
        resultIndex[0] = -1;
        resultIndex[1] = -1;
        int left = 0;
        int right = arr.length-1;
        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == target){
                resultIndex[0] = left;
                resultIndex[1] = right;
                break;
            }
            else if (sum > target){
                right--;
            }
            else if (sum < target){
                left++;
            }
        }
        return resultIndex;
    }
    public static void main(String[] args) {
        int[] result = TwoPointers.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = TwoPointers.search(new int[] { 2, 5, 9, 11 }, 14);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = TwoPointers.search(new int[] {0, 1, 2, 3, 4}, 0);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
