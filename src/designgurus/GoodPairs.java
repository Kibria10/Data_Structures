package designgurus;
import java.util.Map;
import java.util.HashMap;

public class GoodPairs {
    public  static void main(String[]args){
        GoodPairs gp = new GoodPairs();
        int [] nums = {1,2,3,1,1,3};
//        int [] nums = {1,2,3};
        System.out.println(gp.getGoodPairs(nums));
        System.out.println(gp.getGoodPairsFreqApproach(nums));
    }

    //naive approach at first thought. worst complexity.
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

    //better approach.
    public int getGoodPairsFreqApproach(int [] nums){
        Map<Integer, Integer> freqMap = new HashMap<>();
        int pairCount = 0;
        //populate frequency map
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
            pairCount+=freqMap.get(i)-1;
        }
    return pairCount;
    }
}
