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
class Solution 
{
    public TreeNode createBinaryTree(int[][] descriptions) 
    {
        Set<Integer> children = new HashSet<>();
        Set<Integer> parents = new HashSet<>();
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();
        for(int[] d : descriptions)
        {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            parents.add(parent);
            parents.add(child);
            children.add(child);
            parentToChildren.computeIfAbsent(parent, l -> new ArrayList<>()).add(new int[] {child, isLeft});
        }
        parents.removeAll(children);
        TreeNode root = new TreeNode(parents.iterator().next());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode parent = queue.poll();
            for(int[] childInfo : parentToChildren.getOrDefault(parent.val, Collections.emptyList()))
            {
                int childValue = childInfo[0];
                int isLeft = childInfo[1];
                TreeNode child = new TreeNode(childValue);
                queue.offer(child);
                if(isLeft == 1)
                {
                    parent.left = child;
                }
                else
                {
                    parent.right = child;
                }
            }
        }
        return root;
    }
}