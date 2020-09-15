public class TrappingRainWater {
    public static int trap1(int[] height) {
        if(height.length==0)
                return 0;
        int ans =0;
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        suffixMax[height.length-1] = height[height.length-1];
        prefixMax[0] = height[0];
        for(int i=1;i< height.length;i++){
            prefixMax[i]= Math.max(height[i], prefixMax[i-1]);
            suffixMax[height.length-i-1] = Math.max(height[height.length-i-1], suffixMax[height.length-i]);
        }
        for(int i=0;i< height.length;i++){
            ans += (Math.min(suffixMax[i],prefixMax[i]) - height[i]);
        }
        System.out.println(ans);
        return ans;
    }
    public static int trap(int[] height) {
        if(height.length==0)
            return 0;
        int ans =0;
       int leftMax = height[0];
       int rightMax = height[height.length-1];
      int i=0;
      int j= height.length-1;
      for(;i!=j;){

          if(height[i] < height[j]){
              ans+=(Math.min(rightMax,leftMax)-height[i]);
              i++;
              leftMax= Math.max(leftMax,height[i]);

          }
          else{
              ans+=(Math.min(rightMax,leftMax)-height[j]);
              j--;
              rightMax= Math.max(rightMax,height[j]);

          }
      }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
            trap(new int[]{1,11,2,9,13,12,13});
    }
}
