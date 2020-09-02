
import java.util.ArrayList;
import java.util.List;

public class PartitionLables {

    public static List<Integer> solve(String s) {

        int[] hash = new int[30];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<s.length();i++)
                hash[s.charAt(i)-'a']=i;

        int start =0;
        int end =0;
        while ( start < s.length() ){
            end = hash[s.charAt(start)-'a'];
            for(int i = start ;i <=end ;i++){
                end = Math.max(hash[s.charAt(i)-'a'],end);
            }
            res.add((end-start+1));
            start= end +1 ;
        }

        return res;
    }
    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = solve(s);
        for(Integer len : res)
            System.out.print(len+" ");
        System.out.println();
    }
}
