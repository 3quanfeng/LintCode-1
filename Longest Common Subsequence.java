���ֵ���⣬�����������У�����ÿ��Ԫ��˳���ܵ��� => Two Sequence DP
Note: �ַ��� + ǰi���ַ� => ���� n+1 ������ռ�

State:
	f[i][j]��ʾ�ַ���A��ǰi���ַ������ַ���B��ǰj���ַ���LCS����
Function:
	f[i][j] = f[i - 1][j - 1] + 1    //  �� A[i] == B[j] ʱ
		= Math.max(f[i - 1][j], f[i][j - 1])   // �� A[i] != B[j] ʱ
Initialize: 
	f[0][i] = 0, f[i][0] = 0
Answer:
	f[A.length()][B.length()]


/*
Given two strings, find the longest comment subsequence (LCS).

Your code should return the length of LCS.

Example
For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1

For "ABCD" and "EACB", the LCS is "AC", return 2

Clarification
What's the definition of Longest Common Subsequence?

    * The longest common subsequence (LCS) problem is to find the longest subsequence common to all sequences in a set of sequences 
    (often just two). 
    (Note that a subsequence is different from a substring, 
    for the terms of the former need not be consecutive terms of the original sequence.)
    It is a classic computer science problem, the basis of file comparison programs such as diff, and has applications in bioinformatics.

    * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem

Tags Expand 
LintCode Copyright Longest Common Subsequence Dynamic Programming
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        
        // State
        int[][] check = new int[A.length()  + 1][B.length() + 1];
        
        // Initialize ��Ϊint�����ʼ����Ϊ0�����ڹ�������ʱ��Java�Ѿ�Ĭ�ϰ����������
        
        // Function
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    check[i][j] = check[i - 1][j - 1] + 1;
                } else {
                    check[i][j] = Math.max(check[i][j - 1], check[i - 1][j]);
                }
            }
        }
        
        // Answer
        return check[A.length()][B.length()];
    }
}


