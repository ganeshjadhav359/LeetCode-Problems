
import java.util.Scanner;

public class DistanceTwoNodes {

    static class TreeNode {
        TreeNode left ;
        TreeNode right ;
        int val ;
        public TreeNode(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }

    }

    public static  TreeNode insertNode(TreeNode root ,int key){
        if(root==null)
            root = new TreeNode(key);
        else if(key < root.val)
            root.left = insertNode(root.left,key);
        else
            root.right = insertNode(root.right,key);
        return  root;
    }

    public static TreeNode LCAofNodes(TreeNode root ,int i,int j){
        while(root!= null){
            if(root.val > i && root.val > j)
                root =root.left;
            else if(root.val < i && root.val < j)
                root = root.right;
            else
                return root;
        }
        return  null;
    }
    public static int NodeToLcaDis(TreeNode lca , int i){
        int dis = 0 ;
        while(lca!= null){
           if(lca.val==i)
                return dis;
           else if(lca.val > i)
               lca = lca.left;
           else
               lca = lca.right;
           dis++;
        }
        return  -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many nodes you want to insert");

        int n = sc.nextInt();
        TreeNode root = null;
        for(int i =0;i<n;i++){
            int nodeVal = sc.nextInt();
            root = insertNode(root,nodeVal);
            System.out.println("You can insert "+(n-i-1)+" more nodes");
        }
        System.out.println("Number of LCA queries");
        int q = sc.nextInt();
        for(int i=0;i<q;i++){
            System.out.println("Enter two nodes");
            int u = sc.nextInt();
            int v = sc.nextInt();
            TreeNode lca =  LCAofNodes(root,u,v);
            if(lca==null)
                System.out.println(-1);
            else{
                int dis1 = NodeToLcaDis(lca,u);
                if(dis1==-1){
                    System.out.println(-1);
                    continue;
                }
                int dis2 = NodeToLcaDis(lca,v);
                if(dis2==-1){
                    System.out.println(-1);
                    continue;
                }
                System.out.println(dis1+dis2);

            }

        }

    }

}
