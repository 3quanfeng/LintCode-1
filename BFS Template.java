public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();
        
        if (root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        //	�Ƿ�������Ҫ����
        //  ÿһ��ѭ�������ڱ���һ��
        while (!queue.isEmpty()) {
        	  //  level��Ϊһ��buffer�������ʱÿһ���Ԫ��
            ArrayList<Integer> level = new ArrayList<Integer>();
            //	ȡ��size����forһ�飬����BFS�Ĺؼ������ڡ�
            //	ѭ����queue.size()�Ƕ�̬�ģ��ʱ�����forѭ��֮ǰ��ȡ��.
            int size = queue.size();
            //	����for���ò�ÿ����ĺ��Ӷ���ӵ�Queue��
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
