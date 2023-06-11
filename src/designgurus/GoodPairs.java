package designgurus;

public class GoodPairs {
    public  static void main(String[]args){
        GoodPairs gp = new GoodPairs();
//        int [] nums = {1,2,3,1,1,3};
        int [] nums = {1,2,3};
        System.out.println(gp.getGoodPairs(nums));
    }
    public int getGoodPairs(int [] nums){
    int output = 0;
    for (int i = 0; i < nums.length-1; i++){
        for (int j = i+1; j <= nums.length-1; j++){
            if (nums[i]==nums[j]){
                output+=1;
            }
        }
    }
    return output;
    }
}
