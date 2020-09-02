
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    static  class Coordinates{
        int x,y;
        Coordinates(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int solve(char[][] island){
        if(island==null || island.length == 0) return 0;

        boolean[][] visited = new boolean[island.length][island[0].length];
        int steps = 0;
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(new Coordinates(0,0));
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinates co = queue.poll();
                if (island[co.x][co.y] == 'X') return steps;
                for (int[] dir : dirs) {
                    int X = co.x + dir[0];
                    int Y = co.y + dir[1];
                    if (X >= 0 && X < island.length && Y >= 0 && Y < island[0].length && island[X][Y] != 'D' && !visited[X][Y]) {
                        queue.add(new Coordinates(X, Y));
                        visited[X][Y] = true;
                    }

                }
            }
            steps++;
        }
        return steps;


    }

    public static void main(String[] args) {

        char[][] area = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        System.out.println(solve(area));
    }
}
