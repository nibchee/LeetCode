/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        HashMap<Integer,Integer> levelSum=new HashMap<>();
        sum(root,levelSum,0);
        PriorityQueue<Integer> q=new PriorityQueue<>();
        if(levelSum.keySet().size()<k)
        return -1;
        for(Integer val: levelSum.values()){
            q.add(val);
            if(q.size()>k)
            q.remove();
        }
        return q.peek();
    }

    public void sum(TreeNode root,HashMap<Integer,Integer> m,int level){
        if(root!=null){
            m.put(level,m.getOrDefault(level,0)+root.val);
        }

        if(root.left!=null){
            sum(root.left,m,level+1);
        }
      if(root.right!=null){
            sum(root.right,m,level+1);
        }
    }
}