
import java.util.*;

public class TopKwords {


    private static  List<List<String>> suggetestProducts(String[] products , String searchWord) {
        Arrays.sort(products);
        int prodLen = products.length;
        int sLen = searchWord.length();
        List< List<String> > res = new ArrayList<>();
        for(int i = 0 ;i<sLen;i++){

            String subStr = searchWord.substring(0,i+1);
            List<String> curRes = new ArrayList<>();
            for(String prod : products){
                if(prod.startsWith(subStr) && curRes.size() < 3){
                    curRes.add(prod);
                }
                else
                    break;

            }
            res.add(curRes);
        }
        return res;
    }
    private static void solve(int k ,String[] keywords,String[] reviews){
        HashSet<String> hashSet =  new HashSet<>(Arrays.asList(keywords));
        HashMap<String,Integer> freq = new HashMap<>();
        for(String s : reviews){
            String[] words = s.split("\\s");
            HashSet<String> addedSet = new HashSet<>();
            for(String w : words){
                w = w.toLowerCase();
                if(hashSet.contains(w) && !addedSet.contains(w)) {
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                    addedSet.add(w);
                }
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (w1,w2)-> freq.get(w1).equals(freq.get(w2)) ? w2.compareTo(w1) : freq.get(w1) - freq.get(w2)
        );
        for(String s : freq.keySet()){
            pq.add(s);
            if(pq.size() > k)
                    pq.poll();
        }
        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty())
                ans.add(pq.poll());
        Collections.reverse(ans);
        for(String s : ans)
            System.out.print(s+" ");
        System.out.println();
    }
    public static void main(String args[]) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        //System.out.println();
        solve(k1, keywords1, reviews1);
        //System.out.println();
        solve(k2, keywords2, reviews2);
    }

}
