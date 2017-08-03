�󷽰��ܸ�����������Ͷ�����ʹ��պõ���Target => Backpack DP
State:
	f[i][j][t] ��ʾǰi������ȡ��j��������ʹ�ú�Ϊt�ķ�������
Function:
	f[i][j][t] = f[i-1][j][t]    									// ��ȡ��i����
						 = f[i-1][j-1][t-a[i]]  t >= a[i]   // ȡ��i����
Intialize:
	���Ƿ���� (DP) => f[x][0][0] = true
	�ʷ������� (DP) => f[x][0][0] = 1
	�ʾ�������з��� (�ݹ� / ����)
Answer:
	f[A.length][k][target]
	
/*

Description
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Have you met this question in a real interview? Yes
Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.

Tags 
LintCode Copyright Dynamic Programming

*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // State
        int[][][] f = new int[A.length + 1][k + 1][target + 1];
        
        // Initialize
        for (int i = 0; i <= A.length; i++) {
            f[i][0][0] = 1;
        }
        
        // Funciton
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] += f[i - 1][j][t];
                }
            }
        }
        
        // Answer
        return f[A.length][k][target];
    }
}
