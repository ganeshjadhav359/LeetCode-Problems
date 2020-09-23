public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0] =1;
        int tot=0;
        for(int i=1;i<=n;i++){
            int curAns = 0;
            for(int j=1;j<=i;j++)
                curAns+=(dp[j-1] * dp[i-j]);
            dp[i]=curAns;
            tot+=curAns;
        }
        return tot;
    }

    public static void main(String[] args) {

    }
}
