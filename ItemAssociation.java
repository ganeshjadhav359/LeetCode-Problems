
import java.util.*;

public class ItemAssociation {

    static  List<Integer> adj[];
    static List<String> items;
    static class Pair{
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return first + " ," + second;
        }
    }

    public static void makeAdjList(List<Pair> pairItems){

        HashSet<String > itemSet = new HashSet<>();
        for(Pair p : pairItems){
            itemSet.add(p.first);
            itemSet.add(p.second);
        }
        HashMap<String ,Integer > map = new HashMap<>();
        int ind = 0;
        items = new ArrayList<String>(itemSet);
        for(String s : items){
            map.put(s,ind);
            ind++;
        }
        adj = new List[ind+3];
        for(int i=0;i<ind+2;i++)
            adj[i]  = new ArrayList<>();

        for(Pair p : pairItems){
            int u = map.get(p.first);
            int v = map.get(p.second);
            adj[u].add(v);
            adj[v].add(u);
        }
    }
    public static List<String> solve(List<Pair> pairItems){

        makeAdjList(pairItems);
        List<String> res = new ArrayList<>();

        // bfs to make association
        boolean visited[] = new boolean[items.size()+2];
        PriorityQueue<String> pq = new PriorityQueue<>();
//        for(String s : items)
//            System.out.print(s+" ");
//        System.out.println();
        for(int i =0; i < items.size();i++){
            if(visited[i])
                continue;

           // System.out.println("new association");
            PriorityQueue<String> cur = new PriorityQueue<>();

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i]=true;

            while(!q.isEmpty()){
                int itemInd = q.poll();
                //System.out.print(itemInd+" ");
                cur.add(items.get(itemInd));
                for(Integer ind : adj[itemInd]){
                    if(!visited[ind]){
                        q.add(ind);
                        visited[ind]=true;
                    }
                }
            }

            if(cur.size() > pq.size() || (cur.size() == pq.size() && pq.peek().compareTo(cur.peek()) > 1))
                pq = cur;
            //System.out.println();
        }

        while(!pq.isEmpty())
            res.add(pq.poll());
        for(String s : res)
            System.out.print(s+" ");
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        // {item5,item2}
        // {item5,item1}
        // {item3,item4 }
        // {item4,item6 }

        List<Pair> input1 = Arrays.asList(
                new Pair("item5","item2"),
                new Pair("item5","item1"),
                new Pair("item3","item4"),
                new Pair("item4","item6")
        );

        List<Pair> input2 =  Arrays.asList(
                new Pair("item1","item2"),
                new Pair("item2","item3"),
                new Pair("item4","item5"),
                new Pair("item6","item7"),
                new Pair("item5","item6"),
                new Pair("item3","item7")
        );
        List<Pair> input3 =  Arrays.asList(
                new Pair("item3","item4"),
                new Pair("item1","item2"),
                new Pair("item5","item6"),
                new Pair("item4","item5"),
                new Pair("item2","item7"),
                new Pair("item7","item8"),
                new Pair("item2","item3"),
                new Pair("item6","item7"),
                new Pair("item0","item2")
        );
        List<Pair> input4 =  Arrays.asList(
                        new Pair("item1","item2"),
                        new Pair("item1","item3"),
                        new Pair("item2","item7"),
                        new Pair("item3","item7"),
                        new Pair("item5","item6"),
                        new Pair("item3","item7")
        );


        solve(input4);

    }
}
