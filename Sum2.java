import java.util.HashMap;

public class Sum2 {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[0];
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i< nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                ans = new int[2];
                ans[0] = hashMap.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            hashMap.put(nums[i],i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = twoSum(new int[]{2,7,11,15,3,4},9);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
