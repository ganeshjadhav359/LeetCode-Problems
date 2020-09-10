import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKinBinaryTree {

    static List<Integer> res;

     // Definition for a binary tree node.
     static public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static int findNodes(TreeNode root, TreeNode target, int k,int val){
         if(root==null)
             return 0;
         if(root==target){
             findNodes(root.left,target,k,1);
             findNodes(root.right,target,k,1);
             return 1;
         }
         if(val==k){
            res.add(root.val);
            return 0;
         }
         if(val>0){
             findNodes(root.left,target,k,val+1);
             findNodes(root.right,target,k,val+1);
             return 0;
         }
         else{
             int left = findNodes(root.left,target,k,val);
             if(left>0 && left==k){
                 res.add(root.val);
                 return 0;
             }
             if(left > 0){
                 findNodes(root.right,target,k,left+1);
                 return left +1;
             }
             int right = findNodes(root.right,target,k,val);
             if(right > 0 && right==k ){
                 res.add(root.val);
                 return 0;
             }
             if(right > 0){
                 findNodes(root.left,target,k,right+1);
                 return right + 1;
             }
            return 0;
         }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         res = new ArrayList<>();
        if(k==0 && target!=null)
            res.add(target.val);
        else if(target!=null || root!=null )
            findNodes(root,target,k,0);
        findNodes(root,target,k,0);
         return res;
    }

    public static void main(String[] args) {

    }
}
