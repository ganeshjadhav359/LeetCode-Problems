public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int mid = 0 ;
        while(low<=high){
            mid = (low+high)>>1;

            if(mid+1 < len && nums[mid]==nums[mid+1] && (len-mid)%2 == 1 )
                low = mid+2;
            else if(mid+1 < len && nums[mid]==nums[mid+1])
                high = mid-1;
            else if(mid-1 >=0 && nums[mid]==nums[mid-1] && (mid+1)%2 == 1 )
                high = mid-2;
            else if(mid-1 >=0 && nums[mid]==nums[mid-1])
                low = mid+1;
            else
                break;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1,1,2,3,3,4,4,8,8};
        int[] input2 = new int[]{3,3,7,7,10,11,11};
        int[] input3 = new int[]{3};
        System.out.println(singleNonDuplicate(input3));
    }
}
