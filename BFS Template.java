public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        
        if (root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        //	�Ƿ�������Ҫ����
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            //	ȡ��size����forһ�飬����BFS�Ĺؼ�������
            int size = queue.size();
            //	����һ�������ӵ�������
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null)
                    queue.offer(head.left);
                if (head.right != null)
                    queue.offer(head.right);
            }
            result.add(level);
        }
        
        return result;
    }
}
