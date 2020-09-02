
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TargetSumOA {

    public static   List< List<Integer> > solve(  List< List<Integer> > a ,   List< List<Integer> > b,int target){
        List< List<Integer> > res = new ArrayList<>();
        a.sort( (l1 ,l2 ) -> l1.get(1) - l2.get(1) );
        b.sort( (l1 ,l2 ) -> l1.get(1) - l2.get(1) );

        int max = - (1^9 + 7);
        int alen = a.size();
        int blen = b.size();
        int i = 0;
        int j = blen-1;
        while(i < alen && j>=0){
            int sum = a.get(i).get(1) + b.get(j).get(1);

            if(sum > target)
                j--;
            else{
                if(max<= sum){

                    if(max < sum){
                    max = sum;
                    res = new ArrayList<>();

                    }

                    int k = j ;
                    while(k>=0 && b.get(k).get(1).equals(b.get(j).get(1))){
                        List<Integer> pair = new ArrayList<>();
                        pair.add(a.get(i).get(0));
                        pair.add(b.get(k).get(0));
                        res.add(pair);
                        k--;
                    }

                }
                i++;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        List< List<Integer> > a = new ArrayList<>();
        List< List<Integer> > b = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int aLen = sc.nextInt();
        int bLen = sc.nextInt();
        for(int i =0; i<aLen;i++){
            int id = sc.nextInt();
            int val = sc.nextInt();
            List<Integer> pair = new ArrayList<>();
            pair.add(id);
            pair.add(val);
            a.add(pair);
        }

        for(int i =0; i<bLen;i++){
            int id = sc.nextInt();
            int val = sc.nextInt();
            List<Integer> pair = new ArrayList<>();
            pair.add(id);
            pair.add(val);
            b.add(pair);
        }
        int tar = sc.nextInt();
        List< List<Integer> > res = solve(a,b,tar);
        for(List<Integer> pair : res)
            System.out.println("["+pair.get(0)+ " "+pair.get(1)+"]");
    }
   // a = [[1, 3], [2, 5], [3, 7], [4, 10]]
   // b = [[1, 2], [2, 3], [3, 4], [4, 5]]
   // target = 10
    // Output: [[2, 4], [3, 2]]


//    a = [[1, 8], [2, 15], [3, 9]]
//    b = [[1, 8], [2, 11], [3, 12]]
//    target = 20
// Output: [[1, 3], [3, 2]]


//    a = [[1, 2], [2, 4], [3, 6]]
//    b = [[1, 2]]
//    target = 7
// Output: [[2, 1]]


//    a = [[1, 8], [2, 7], [3, 14]]
//    b = [[1, 5], [2, 10], [3, 14]]
//    target = 20
//    Output: [[3, 1]]


}
