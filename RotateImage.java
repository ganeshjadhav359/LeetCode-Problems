public class RotateImage {
    public static void solution1(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r/2;i++){
            int cnt = r - 2 * i-1 ;

            int j = i;

            while(cnt > 0){
                int temp = matrix[j][c-i-1];
                matrix[j][c-i-1] = matrix[i][j];
                matrix[i][j] = temp;
                j++;
                cnt--;
            }

            j = i;
            cnt = r - 2*i-1;

            while (cnt>0){
                int temp = matrix[r-i-1][c-j-1];
                matrix[r-i-1][c-j-1] = matrix[i][j];
                matrix[i][j] = temp;
                j++;
                cnt--;
            }
            j = i;
            while(j < (c-i-1)){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[r-j-1][i];
                matrix[r-j-1][i]  = temp;
                j++;
            }

        }

    }

    public static void solution2(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0;i<r/2;i++){
            for(int j=0;j<c;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[r-i-1][j];
                matrix[r-i-1][j]=temp;
            }
        }
        for(int i=0;i<r;i++){
            for(int j=i+1;j<c;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public static void main(String[] args) {
//        int[][] input1 = new int[][]{
//                                {1,2,3,4},
//                                {5,6,7,8},
//                                {9,10,11,12},
//                                {13,14,15,16}
//                        };
        int n =5;
        int[][] input1 = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                input1[i][j] = i*n +j+1;
        solution2(input1);
        for (int[] ints : input1) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }
    }
}
