import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class LcaBinaryTree {

    public  static  void dfs(TreeNode root,TreeNode node, Stack<TreeNode> s){
            if(root==null)
                return;
            if(root==node){
                s.add(root);
                return;
            }
            if(s.size()!=0)
                dfs(root.left,node,s);
            if(s.size()!=0)
                dfs(root.right,node,s);
            if(s.size()!=0)
                s.add(root);
    }

    // O(n) extra space
    public static  TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        dfs(root,p,s1);
        dfs(root,q,s2);
        TreeNode ans=null;
        while(!s1.isEmpty() && !s2.isEmpty() && (s1.peek()!=s2.peek())){
            ans = s1.pop();
            s2.pop();

        }
        return ans;
    }

    // O(1) extra space
    public static  TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
           if(root==null || root==p || root==q)
               return  root;
           TreeNode left = solution2(root.left,p,q);
           TreeNode right = solution2(root.right,p,q);
           return left == null ? right : right ==null ? left : root;
    }
    public static void main(String[] args) {

    }
}
