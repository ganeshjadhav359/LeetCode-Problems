public class MaximumProductSubarray {

        public static int maxProduct(int[] nums) {
            if(nums.length==0)
                return 0;
            int ans = nums[0];
            int min = nums[0];
            int max = nums[0];
            for(int i=1;i< nums.length;i++){
                if(nums[i] < 0 ){
                    int temp = min;
                    min = max;
                    max = temp;
                }

                max = Math.max(nums[i],max*nums[i]);
                min = Math.min(nums[i],min*nums[i]);
                ans = Math.max(max,ans);

            }
            return ans;
        }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4,3,4-2,8,-2,4}));
    }
}
