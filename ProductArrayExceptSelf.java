public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i=1;i< nums.length;i++)
                ans[i] = nums[i-1] * ans[i-1];

        int rightToLeft =1;

        for(int i = nums.length-1 ;i>=0;i-- ){
            ans[i] = ans[i] * rightToLeft;
            rightToLeft *= nums[i];
            //System.out.println(ans[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        productExceptSelf(new int[]{1,2,3,4});
    }
}
