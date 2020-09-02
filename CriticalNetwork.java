

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriticalNetwork {
    List<Integer> adj[] ;
    boolean[] visited;
    int[] visTime;
    int[] minVisTime;
    int timer;
    List< List<Integer> > res;
    public CriticalNetwork(int nodes) {
        this.adj = new List[nodes];
        for(int i=0 ;i< nodes+1 ; i++ ){
            this.adj[i] = new ArrayList<>();
        }

        visTime = new int[nodes+2];
        minVisTime = new int[nodes+2];
        visited = new boolean[nodes+2];
        timer=0;

    }
    public void makeAdjList(List< List<Integer> > edges){
        for(List<Integer> list : edges){
            int u = list.get(0);
            int v = list.get(1);
            adj[v].add(u);
            adj[u].add(v);
        }
    }

    private  void dfs(int cur ,int par){

        visited[cur] = true;
        visTime[cur] = minVisTime[cur] = timer++;
        for(Integer v : adj[cur]){
            if(v.equals(cur)) continue;
            if(visited[v])
                minVisTime[cur] = Math.min(minVisTime[cur],visTime[v]);
            else{
                dfs(v,cur);
                minVisTime[cur] = Math.min(minVisTime[v],minVisTime[cur]);
                if(minVisTime[v] > visTime[cur]){
                    List<Integer> edge = new ArrayList<>();
                    edge.add(v);
                    edge.add(cur);
                    res.add(edge);
                }

            }
        }

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        res = new ArrayList<>();
        for(int i =0 ;i<n;i++)
                if(!visited[i])
                    dfs(i,-1);

        for(List<Integer> list : res)
                System.out.println(list.get(0)+" "+list.get(1));
        return res;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int e = scanner.nextInt();
        List< List<Integer> > edges = new ArrayList<>();
        for(int i=0;i<e;i++){
            int u = scanner.nextInt();
            int v = scanner.nextByte();
            List<Integer> edge = new ArrayList<>();
            edge.add(u);
            edge.add(v);
        }
        CriticalNetwork var = new CriticalNetwork(n);

        var.makeAdjList(edges);

    }
}
