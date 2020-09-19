public class SortArrayOf0s1s {
    public static void solution(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){

            while (left < right && arr[left]==0)
                    left++;
            while (left<right && arr[right]==1)
                    right--;
            if(left < right){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 0});
    }
}
