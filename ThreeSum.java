import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       Arrays.sort(nums);
       int len = nums.length;
       int pre = 200000;

       for(int i =0;i<len-2;i++){
           if(pre==nums[i])
                continue;
           int lo = i+1;
           int hi = len-1;
           //System.out.println("starting val: "+nums[i]);
           while(lo<hi){
               //System.out.println(nums[lo]+" "+nums[hi]);
               if(nums[lo]+nums[hi]== -nums[i]){
                   res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                   while(lo < hi && nums[lo]==nums[lo+1])
                       lo++;
                   while (lo < hi && nums[hi] == nums[hi-1])
                       hi--;
                   lo++;
                   hi--;
               }
               else if(nums[lo]+nums[hi] < -nums[i])
                   lo++;
               else
                   hi--;
           }
           pre = nums[i];
       }
       for(List triplet : res)
           System.out.println(triplet.get(0)+" "+triplet.get(1)+" "+triplet.get(2));
       return res;
    }
    public static void main(String[] args) {
        threeSum(new int[]{8,2,3,-4,-4,-2,-6,3,0,2});
    }
}
