/*
Description
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example
Given word1 = "mart" and word2 = "karma", return 3.

Tags
Dynamic Programming String
 */

/**
 * Approach 1: Two Sequence DP
 * �� LCS ����һ����������,������˾����Ƿ���Ը���LCS��ֵ����������ֵ�أ�
 *      EditDistance(word1, word2) = MaxLength(word1, word2) - LCS(word1, word2)
 * �����������֮�䲻��Ҫ�༭�Ĳ��֣�Ȼ��word1��word2������ĳ��ȼ�ȥ��� LCS �ĳ��ȼ��ɡ�
 * ��ʵ���ϸ������Ǵ���ġ�ԭ�����ڣ�
 * LCS �У������ ����������У�����������ÿ���ַ�ƥ���λ�ã���˿��ܵ���
 * ���� ����LCS, ���ǽ����޸�ʱ����Щƥ����ַ���Ȼ��Ҫ�� edit.
 * ���磺"sea" �� "ate", ��Ȼ���Ǵ��� LCS 'a',����Ϊ��ʹ�������ַ�����ͬ���� edit ʱ��'a'
 * �����ܷ����κ����ã���Ϊλ�ù�ϵ������Ȼ��Ҫ���޸ġ�
 *
 * ��Ȼ���ǲ���ֱ��ʹ�� LCS �ķ���������������Ȼ�ܹ�ʹ���� DP ��˼�뷽����
 * State:
 *  dp[i][j]��ʾ word1 ��ǰ i ���ַ����� word2 ��ǰ j ���ַ�������Ҫ���α༭���ܹ�ʹ�������
 * Function:
 *  ��Ϊ word1����һ��insert���� �� word2����һ��remove���� ��ʵ����ͬ�ģ�����߽������A�Ĳ������з���
 *  �� word1[i] == word2[j] ʱ��
 *      dp[i][j] = dp[i-1][j-1]
 *  �� word1[i] != word2[j] ʱ��
 *      ���� replace ����ʱ��dp[i][j] = dp[i-1][j-1] + 1
 *      ���� insert ����ʱ��dp[i][j] = dp[i-1][j] + 1
 *      ���� remove ����ʱ��dp[i][j] = dp[i][j-1] + 1
 *      dp[i][j] ȡ���� 3 �������е���Сֵ���ɡ�
 * Initialize:
 *      dp[i][0] = i // �� word2 Ϊ��ʱ
 *      dp[0][j] = j // �� word1 Ϊ��ʱ
 * Answer:
 *      dp[word1.length()][word2.length()]
 *
 * ʱ�临�Ӷȣ�O(mn) �� �ռ临�Ӷȣ�O(mn)
 */
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        // State
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // Initialize
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        // Function
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j -1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        // Answer
        return dp[word1.length()][word2.length()];
    }
}

/**
 * Approach 2: Two Sequence DP (Optimized by Sliding Array)
 * �� Approach 1 �еķ����ɵã�
 *  dp[i][j] ������ ��һ�е�״̬ �� ǰһ��״̬�����㣩 ��������
 * ������ǿ������� �������� ���� �ռ临�Ӷ� �����Ż���
 * �ɷ����ɵã�����ֻ��Ҫ���� ���е�״ֵ̬ ���㹻�ˡ�
 * ���������� ������±� ���� ȡ�� ������ʵ�֡�
 *
 * ʱ�临�Ӷȣ�O(mn) �� �ռ临�Ӷȣ�O(n)
 */
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        // State
        int[][] dp = new int[2][word2.length() + 1];

        // Initialize
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        // Function
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (j == 0) {
                    dp[i & 1][j] = i;
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i & 1][j] = dp[(i-1) & 1][j - 1];
                } else {
                    dp[i & 1][j] = Math.min(dp[(i-1) & 1][j - 1], Math.min(dp[(i-1) & 1][j], dp[i & 1][j - 1])) + 1;
                }
            }
        }

        // Answer
        return dp[word1.length() & 1][word2.length()];
    }
}