��Сֵ���⣬SourceΪ�ַ����������������λ�� => Sequence DP

State:
	f[i]��ʾǰi���ַ�������Ҫ���ٴ�cut���ܱ��ָ�Ϊ�������ַ��� (���ٱ��ָ�Ϊ���ٸ��������ַ��� - 1)
Function:
	f[i] = Math.min(f[j] + 1), ( j < i & j + 1 ~ i��һ���ַ�����һ�����Ĵ�) 
Initialize: 
	f[0] = -1, f[i] = i �C 1 (��Ϊ����Ϊi���ַ��������Խ���i �C 1��cut)
Answer:
	f[s.length()], ��f[n].
	
ע��㣺����һ������Ϊn���ַ�����ʼ��ʱ���ǳ�����Ҫ���� n + 1 ������ռ䣬��0λ��������
��Ϊ������ǰi���ַ����ʴ��ڶ��壺��ǰ0���ַ��������մ��������ǲ��ܱ����Ե��ģ���Ϊ��������Ǵ�����õ��ġ�
�����𰸵Ľ��Ҳ����f[s.length()] => f[n].

������Ż��ĵ��������ǿ������Ⱦͽ� 0~i �Ƿ�Ϊ���Ĵ������жϣ������ǽ���ŵ�DP��forѭ���С�
��ΪisPalindrome�����ĸ��Ӷ�ΪO(N),�������дDP��Function�е�for loop�л�ʹ�ó���ĸ��Ӷ�
��ԭ���� O(N^2) ��� O(N^3)

�ж�һ���ַ��������Ӵ��Ƿ�Ϊ���Ĵ�������ʵ����Ҳ��һ��DP���⡣�㷨���Ӷ�Ϊ��O(N^2)
State:
	f[m][n]��ʾ�ַ����� m~n �Ƿ���һ�����Ĵ�
Function:
	��f[m-1][n-1]���Ӵ�Ϊ���Ĵ�������A[m] == A[n] ��ʱ��, f[m][n]Ϊ true 
	�� f[m - 1][n - 1] == true && s.charAt(m) == s.charAt(n)
Initialize: 
	ÿ����ĸ�䱾����һ�����Ĵ�������f[i][i] = true
Answer:
	f

/*
Given a string s, cut s into some substrings such that every substring is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
Example
For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
Tags Expand 
Dynamic Programming

Thinking process:
DP problem.
Use a isPal to record if any [i ~ j] is Palindrome, true / false
    for any char s[i] and s[j], if s[i] == s[j], then need to check if [i + 1, j - 1] is Palindrome, which is just isPal[i + 1, j - 1].
Use cut[j] to record the minimal cut from char index [0 ~ j] 
    by default, cut[j] = j because the worst condition is cut j times at each charactor: none 2+ character palindrome, and split into individual chars.
    update cut[j] by comparing existing cut[j] and (cut[i - 1] + 1).
At the end, return cut[s.length() - 1].
*/

/*
version 1
f[i] ��ʾǰi����ĸ�����ٱ��и�ο����и�Ϊ���ǻ��Ĵ���
���return f[n]
*/

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        // State
        int[] count = new int[s.length() + 1];
        
        // Initialize
        for (int i = 0; i <= s.length(); i++) {
            count[i] = i - 1;
        }
        
        // Function
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
            //  if (isPalindrome(s, j, i - 1)), ���ʹ�ø÷�����ʹ���㷨���Ӷ�������O(N^3)
            //  �����ȼ�����Ƿ�Ϊ���Ĵ���ֵ��Ȼ��ֱ�Ӳ��ļ��ɣ������ĵĸ��ӵ���O(1)��.
                if (isPalindrome[j][i - 1]) {
                    count[i] = Math.min(count[i], count[j] + 1);
                }
            }
        }
        
        // Answer
        return count[s.length()];
    }
    
    //	��ʹ�ø÷���
    private boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    //	�����жϺ��Ƿ�Ϊ���Ĵ��� Ҳ��һ��DP�Ľⷨ
    private boolean[][] getIsPalindrome(String s) {
    	  // State
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
				
				// Initialize
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
				
				// Function
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }
};

/*
version 2
f[i] ��ʾǰi����ĸ�����ٿ��Ա��ָ�Ϊ���ٸ����Ĵ�
���return f[n] - 1
*/
public class Solution {
    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // State
        boolean[][] isPalindrome = getIsPalindrome(s);
        
        // Initialize
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        
        // Function
        for (int i = 1; i <= s.length(); i++) {
            f[i] = Integer.MAX_VALUE; // or f[i] = i
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
				
				// Answer
        return f[s.length()] - 1;
    }
}
