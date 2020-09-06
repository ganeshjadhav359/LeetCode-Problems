import java.util.*;

public class ZigzagLevelOrderTraversal {

     //Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public List<List<Integer>> zigzagLevelOrderSolution1(TreeNode root) {

         List<List<Integer>> res = new ArrayList<>();
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            if(root!=null)
                s1.add(root);
            while(!s1.isEmpty() || !s2.isEmpty()){

                List<Integer> evenLevel = new ArrayList<>();
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    if(node.left!=null)
                        s2.add(node.left);
                    if(node.right!=null)
                        s2.add(node.right);
                     evenLevel.add(node.val);
                }

                List<Integer> oddLevel = new ArrayList<>();
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    if(node.right!=null)
                        s1.add(node.right);
                    if(node.left!=null)
                        s1.add(node.left);
                    oddLevel.add(node.val);
                }

                if(evenLevel.size()!=0)
                    res.add(evenLevel);
                if(oddLevel.size()!=0)
                    res.add(oddLevel);
            }
         return res;
    }
    public List<List<Integer>> zigzagLevelOrderSolution2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        boolean zigzag = false;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for(int i=0;i<cnt;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            if(zigzag)
                Collections.reverse(level);
            res.add(level);
            zigzag = !zigzag;
        }
        return res;

    }
}
