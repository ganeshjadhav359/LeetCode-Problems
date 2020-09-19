public class SortArrayOf0s1s2s {
    public static void solution(int[] arr){
        int low =0;
        int mid =0;
        int high = arr.length-1;
        while (mid<=high){
            if(arr[mid]==0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            }
            else if(arr[mid]==2){
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
            else if(arr[mid]==1)
                mid++;
        }
        for(int i :arr) System.out.printf("%d ",i);
        System.out.println();
    }
    public static void main(String[] args) {
        solution(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
    }
}
