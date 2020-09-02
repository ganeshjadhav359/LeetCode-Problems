public class SquareOfSorted {
    public static int[] solve(int[] arr){
        if(arr.length==0)
                return null;

        int[] res = new int[arr.length];
        int s = 0;
        int e = arr.length-1;
        int k = arr.length -1;
        while (s<=e){
            if(arr[s]*arr[s] < arr[e]*arr[e]){
                res[k] = arr[e]*arr[e];
                e--;
            }
            else{
                res[k] = arr[s]*arr[s];
                s++;
            }
            k--;
        }
        for(int i =0;i<res.length;i++)
            System.out.print(res[i]+" ");
        System.out.println();
        return res;
    }
    public static void main(String[] args) {
        int[] input1 = new int[]{-4,-1,0,3,10};
        int[] input2 = new int[]{-7,-3,2,3,11};
        solve(input1);
    }
}
