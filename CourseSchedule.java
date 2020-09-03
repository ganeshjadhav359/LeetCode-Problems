import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseSchedule {
    private static List<Integer> adj[];
    private static boolean[] visited;
    private static boolean ans ;
    private static HashSet<Integer> set;
    public static void makeAdjList(int[][] prerequisites,int numOfCourses){
        adj = new List[numOfCourses+2];
        visited = new boolean[numOfCourses+2];
        set = new HashSet<>();
        for(int i=0;i<numOfCourses+1;i++)
            adj[i] = new ArrayList<>();
        for(int i=0;i< prerequisites.length;i++){
            int par =  prerequisites[i][1];
            int child = prerequisites[i][0];
            adj[par].add(child);
        }
    }
    public static void dfs(int cur){
        visited[cur] = true;
        set.add(cur);
        for(Integer u : adj[cur]){
            if(!ans)
                break;
            else if(set.contains(u))
                ans = false;
            else
                dfs(u);
        }
        set.remove(cur);
    }
    public static boolean canFinish(int numOfCourses,int[][] prerequisites){
         ans = true;

        makeAdjList(prerequisites,numOfCourses);

        for(int i =0;i<numOfCourses;i++){
                if(!visited[i] && ans)
                    dfs(i);
                else
                    break;
        }

        return ans;
    }
    public static void main(String[] args) {
        int numOfCourses1 = 3;
        int[][] prerequisites1 = new int[][]{
                {1,0},
                {2,1},
                {0,2}
        };
        int numOfCourses2 = 2;
        int[][] prerequisites2 = new int[][]{
                {1,0},
        };

        int numOfCourses3 = 2;
        int[][] prerequisites3 = new int[][]{
                {1,0},
                {0,1}
        };
        System.out.println(canFinish(numOfCourses1,prerequisites1));
    }
}
