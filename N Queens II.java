�����N Queens���Ӽ��ˡ�
��ΪֻҪ�����ĸ���������Ҫ�����г�����
���൱������drawChessBoard()���������
����˼·��N Queens��ͬ��

/*
Description:
Follow up for N-Queens problem.
Now, instead outputting board configurations, return the total number of distinct solutions.

Example
For n=4, there are 2 distinct solutions.

*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    int result = 0;
    
    public int totalNQueens(int n) {
        //write your code here
        if (n <= 0) {
            return result;
        }
        
        helper(new ArrayList<Integer>(), n);
        return result;
    }
    
    private void helper(ArrayList<Integer> list,int n)  {
        if (list.size() == n) {
             result++;
             return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!isValid(list, i)) { 
                continue;
            }
            
            list.add(i);
            helper(list, n);
            list.remove(list.size() - 1);
        }
    }

     private boolean isValid(ArrayList<Integer> cols, int column) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
            if (cols.get(rowIndex) == column) {
                return false;
            }
            //	б��Ϊ 1 -- 45��
            if (rowIndex + cols.get(rowIndex) == row + column) {
                return false;
            }
            //	б��Ϊ -1 -- 135��
            if (rowIndex - cols.get(rowIndex) == row - column) {
                return false;
            }
        }
        return true;
    }
   
}
