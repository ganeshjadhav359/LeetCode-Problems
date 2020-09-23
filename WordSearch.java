public class WordSearch {
    public static boolean exist(char[][] board, String word,int x,int y,int ind) {
        if(ind==word.length())  return true;
        if(x<0 || y<0 || x== board.length || y==board[0].length || board[x][y]!=word.charAt(ind))
            return false;
        char ch = board[x][y];
        board[x][y]='#';
        boolean ans = exist(board,word,x-1,y,ind+1) || exist(board,word,x+1,y,ind+1)
                        || exist(board,word,x,y-1,ind+1) || exist(board,word,x,y+1,ind+1);
        board[x][y] = ch;
        return ans;
    }
    public static boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(exist(board,word,i,j,0)) return true;
            }

        return false;
    }
    public static void main(String[] args) {

    }
}
