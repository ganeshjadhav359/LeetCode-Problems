import java.util.*;

public class CoueawSchedule2 {

    private static List<Integer> adj[];
    private static boolean[] visited;
    private static boolean dac ;
    private static HashSet<Integer> set;
    static int[] ans;
    static int ind;
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
            if(!dac)
                break;
            else if(set.contains(u))
                dac = false;
            else
                dfs(u);
        }
        set.remove(cur);
    }
    public static boolean canFinish(int numOfCourses,int[][] prerequisites){
        dac = true;

        makeAdjList(prerequisites,numOfCourses);

        for(int i =0;i<numOfCourses;i++){
            if(!visited[i] && dac)
                dfs(i);
            else
                break;
        }

        return dac;
    }
    public static void dfs2(int cur){
        visited[cur]=true;
        for(Integer u : adj[cur]){
            if(!visited[u])
                dfs2(u);
        }
        ind--;
        ans[ind] = cur ;
    }

    public static int[] findOrder(int numOfCourses){
        ind = numOfCourses;
        visited = new boolean[numOfCourses+2];
        ans = new int[0];

        for(int i=0;i<numOfCourses;i++){
            if(!visited[i])
                dfs2(i);
        }
        Collections.reverse(Arrays.asList(ans));
        for (int i =0;i<numOfCourses;i++)
            System.out.print(ans[i]+" ");
        System.out.println();
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
        if(canFinish(numOfCourses2,prerequisites2)){
            ans = new int[numOfCourses2];
            findOrder(numOfCourses2);
        }
    }
}
