����С·���ͣ�����Matrix DP
���վ���̬�滮˼·���н��⡣
�ⷨ�����Զ����µķ�����Top to Buttom��.
��������һ����ά���飬�ʶ�����г�ʼ��Ҫ��������ı�Ե��
State: sum[x][y]����㵽����(x, y)����С·����
Function: ͬһʱ���ڿ�������������ƶ�һ���� f[i][j] = Math.min(f[x - 1][y], f[x][y - 1]) + A[x][y]; 
Initialize:	�������ɵ����Ϊ���Ͻǣ���������һ����λ���ݣ��ʣ�
						f[0][0] = A[0][0]
					  f[i][0] = sum(0,0 -> i,0)
					  f[0][i] = sum(0,0 -> 0,i)
Answer:	���½�Ϊ�յ��Ϊ sum[row - 1][column - 1].

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note
You can only move either down or right at any point in time.

Example
Tags Expand 
Dynamic Programming

*/


public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        // �������ֵ�Ƿ�Ϊ��
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int column = grid[0].length;
        int[][] sum = new int[row][column];
        
        //  Initialize
        sum[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < column; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        
        //  Function
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        
        //  Answer
        return sum[row - 1][column - 1];
    }
}