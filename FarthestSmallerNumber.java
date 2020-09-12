public class FarthestSmallerNumber {

    public  static void solution(int[] arr){

        // input {4,1,5,5,1,3,3,6,6}
        // suffix{0,0,0,0,0,0,0,0,6}
        int[] minSuffix = new int[arr.length];
        int min = (int)1e9;
        for(int i= arr.length-1;i>=0;i--){
            if(arr[i]<min)
                min = arr[i];
            minSuffix[i] = min;
        }
        int[] res = new int[arr.length];
        for(int i =0 ;i<arr.length;i++){
            int num = arr[i];
            int low = i+1;
            int high = arr.length-1;
            int ans = -1;
            while(low<high){
                int mid = (low+high)>>1;
                if(minSuffix[mid] < num){
                    ans = mid+1;
                    low = mid+1;
                }
                else
                    high = mid -1;
            }
            res[i] = ans;

        }
        for(int i=0;i<arr.length;i++)
            System.out.println(i+" "+res[i]);

    }
    public static void main(String[] args) {
        solution(new int[]{4,1,5,7,1,3,3,6,2});
    }
}
