public class SearchRotatedSortedArray {
    public static  int solution1(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid= (low+high)>>1;
            if(nums[mid] > nums[high])
                low = mid+1;
            else
                high = mid;
        }
        System.out.println(low);
        int rot = low;
        low = 0;
        high = nums.length-1;
        while (low<=high){
            int mid = (low+high)>>1;
            int realMid = (mid+rot)% nums.length;
            if(nums[realMid]==target)
                return realMid;
            else if(nums[realMid] < target)
                low=mid+1;
            else
                high = mid-1;

        }
        return -1;
    }
    public static  int search(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;
        int len = nums.length;
        while(low<=high){
            int mid = (low+high)>>1;
            if(nums[mid]==target) return mid;
            else if(nums[mid] < nums[low] && target >= nums[mid] && target<= nums[high] )
                    low = mid+1;
            else if(nums[mid] < nums[low])
                    high = mid-1;
            else if(nums[mid]>nums[low] && target >= nums[low] && target<= nums[mid])
                    high = mid-1;
            else
                    low = mid+1;

        }
        return -1;
    }
    public static void main(String[] args) {
            search(new int[]{4,5,6,7,0,1,2},0);
    }
}
