import java.util.*;

public class EvaluateDivisionDfs {
    public static List<Integer> adj[];
    public static List<Double> adjVal[];
    public static HashSet<String> nodes;
    public static List<String> nodeList;
    public static HashMap<String,Integer> map;
    public static boolean[] visited;


    public static void makeAdjList(List<List<String>> equations,double[] values){
        nodes = new HashSet<>();
        for(int i=0;i<equations.size();i++){
            nodes.add(equations.get(i).get(0));
            nodes.add(equations.get(i).get(1));
        }

        nodeList = new ArrayList<>(nodes);
         map = new HashMap<>();

        for(int i =0;i<nodeList.size();i++){
            map.put(nodeList.get(i),i);
        }
        adj = new List[nodeList.size()+3];
        adjVal = new List[nodeList.size()+3];
        for(int i=0;i<nodeList.size()+2;i++){
                adj[i] = new ArrayList<>();
                adjVal[i] = new ArrayList<>();
        }
        for(int i=0;i<equations.size();i++){
            int u = map.get(equations.get(i).get(0));
            int v = map.get(equations.get(i).get(1));
            double inverseEdgeVal = 1.0/values[i];
            adj[u].add(v);
            adj[v].add(u);
            adjVal[u].add(values[i]);
            adjVal[v].add(inverseEdgeVal);
        }
    }
    public static double dfs(int cur,int end){
        if(cur==end)
            return 1.0;
       // System.out.println("end: "+end +" ---> cur: "+cur +" curListSize: "+adj[cur].size());
        visited[cur] = true;
        for(int i=0;i<adj[cur].size();i++){
           // System.out.println("visited: "+adj[cur].get(i)+" "+visited[adj[cur].get(i)]);
            if(!visited[adj[cur].get(i)]){
                double product = dfs(adj[cur].get(i),end);
                if(product!= -1.0)
                    return adjVal[cur].get(i) * product;
            }
        }
        return -1.0;
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        makeAdjList(equations,values);
//        for(int i =0;i<nodeList.size();i++){
//            System.out.println("id: " + i +" key:"+nodeList.get(i));
//        }
        for(int i =0;i<queries.size();i++){

            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            visited = new boolean[nodeList.size()+2];
            if(!map.containsKey(u) || !map.containsKey(v))
                ans[i]=-1.0;
            else
                ans[i]=dfs(map.get(u),map.get(v));
            System.out.println(ans[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        //equations = [ ["a", "b"], ["b", "c"] ],
        //values = [2.0, 3.0],
        //queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
        List<List<String>> equations = new ArrayList<>();

        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        double[] values = new double[]{2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));

        double[] ans = calcEquation(equations,values,queries);


    }
}
