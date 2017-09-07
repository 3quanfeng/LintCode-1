�� Coins in a Line II ����Ľ�һ���Ӵ��Ѷȡ�
������Ҫ����˼·��Ȼ�� II ��ͬ��
��ȻҪʹ��ÿһ��ȡ��֮�󣬶���ȡ�Ķ��ǽϲ�������ʹ�ö����õ���Ӳ���ܼ�ֵ��С��
��Ϊÿ��ȡ������ ��/�� ����һ��ȡһ��ֵ����������Ҫ֪��������ÿһ��֮���Ƕ��١�
Ȼ���ÿ�β������з������ó� ״̬ת�Ʒ��̣��� II ����һ����

��Ϸ���� (State):
	dp[i][j] ʣ�� i~j �ε�Ӳ��ʱ������ȡ�õ����ֵ
��Ҿ��� (Function):
	��ΪӲ���ܼ�ֵһ����Ϊ�˱�֤ ������󣬱�֤ȡ��������ȡ������С���ɡ�
	(�����뷨�취�ӶԷ�����)
	dp[i][j] = sum[i][j] - Math.min(dp[i+1][j], dp[i][j-1]);
	ע�⣺�� i==j ʱ������ֻ��ȡ�� values[i].
��Ϸ��ֹ (Initialize)��
	��Ψһʣ�µ�һöӲ�ұ�ȡ��֮����Ϸ������
	�ʵ� i==j ʱ��dp[i][j] = values[i];

/*
Description
There are n coins in a line. 
Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
The player with the larger amount of money wins.
Could you please decide the first player will win or lose?

Example
Given array A = [3,2,2], return true.
Given array A = [1,2,4], return true.
Given array A = [1,20,4], return false.

Challenge 
Follow Up Question:
If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?

Tags 
Array Dynamic Programming Game Theory
*/

public class Solution {
    /*
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length <= 1) {
            return true;
        }
        
        // State & Initialize
        int len = values.length;
        int[][] sum = new int[len + 1][len + 1];
        int[][] dp = new int[len + 1][len + 1];
        // ��������� for-loop ������Ϊ���� i~j ����Ӳ�ҵ��ܼ�ֵ
        // ��� ѭ���ķ���������⣬ֻҪ��ʵ�ֹ��ܼ��ɡ��� DP ������for-loop����
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (i == j) {
                    sum[i][j] = values[i - 1];
                } else {
                    sum[i][j] = sum[i][j - 1] + values[j - 1];   
                }
            }
        }
        
        // Function & Initialize
        // ע�����Ƿ�������ʣ������ i~j �ε�Ӳ�Ҽ�ֵ��
        // ��� loop �� i,j Ӧ�ô� len ��ʼ����ʾʣ�µ�Ӳ�� (�� -> ��)
        for (int i = len; i >= 1; i--) {
            for (int j = i; j <= len; j++) {
                if (i == j) {
                    dp[i][j] = values[i - 1];
                } else {
                    dp[i][j] = sum[i][j] - Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        // Answer
        return dp[1][len] > sum[1][len] / 2;
    }
}