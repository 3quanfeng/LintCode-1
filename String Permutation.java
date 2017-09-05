������ 3 �ֽⷨ��

Solution 1:	O(nlogn) Sort 
	�÷���ֱ�ۣ�������ֱ�ӽ� Sting A, B ת��Ϊ char[], Ȼ����� Arrays.sort() �������򼴿�
	Ȼ������ String.valueOf() ���ַ�����ת���� String
	������� String �� equals �����Ƚ���������������ַ������ɡ�
	���Ǹ÷���ʱ�临�Ӷȹ��ߣ����Ƽ�Ŷ~ 
	������߾��������ⷨ���������Ͳ�ʵ����~ �����˳ɻ�Time Limit Exceeded~~

Solution 2: O(n) Calculate the Sum of String
	��Ϊ�ڼ������ÿһ���ַ���ʵ������һ�� int ��ֵ����ʾ�� (ASCII ��)
	��˽� String ��ÿ���ַ�����������õ��� sum ���������������ַ��������û�
	�����ܼ򵥣��� String ת��Ϊ char[] ֮��ȡ���ַ�������ÿ���ַ�ֵ��Ӽ���
	ȱ�㣺һ���漰�����㣬һ��Ҫ���Ǳ߽����⡣������������Դ�������ʱ��sum ���ᳬ�� MAX_VALUE��
	������~ ����� testcase ��������û����ô�󣬶������������д��~ �ٺٺ�~~~
	Note��ʵ��Ӧ�ó����л���Ҫ�Ͻ�Ŷ�� �뿴 Solution 3

Solution 3: O(n) HashMap
	�뵽��������µ��жϣ�������Ϊ���Ҵ� HashMap �ˡ�
	���� HashMap �е� key �������ַ���ֵ, value �������ַ����ֵ���Ӧ������
	Ȼ������� map ���бȽϱ��ܹ��ó����Ľ����
	
/*
Description
Given two strings, write a method to decide if one is a permutation of the other.

Example
abcd is a permutation of bcad, but abbe is not a permutation of abe

Tags 
String Permutation
*/

// Solution 2: Calculate the Sum of String O(N)
public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        if (A == null || B == null) {
            return A == B;
        }
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equlas(B)) {
            return true;
        }
        
        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();

        long sumA = 0, sumB = 0;
        for (int i = 0; i < chA.length; i++) {
            sumA += chA[i];
            sumB += chB[i];
        }
        
        return sumA == sumB;
    }
}

// Solution 3: HashMap O(N)
public class Solution {
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    public static boolean stringPermutation(String A, String B) {
        if (A == null || B == null) {
            return A == B;
        }
        if (A.equlas(B)) {
            return true;
        }
        if (A.length() == B.length()) {
            return mapCompare(charCount(A), charCount(B));
        }
        return false;
    }
    //  �õ��ַ��������ַ��ĳ��ִ���
    public static Map<Character, Integer> charCount(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        
        for (char item : arr) {
            if (map.containsKey(item)) {
                Integer num = map.get(item);
                num += 1;
                map.put(item, num);
            } else {
                map.put(item, 1);
            }
        }
        
        return map;
    }
    //  �Ƚ�����map
    public static boolean mapCompare(Map<Character, Integer> map1, Map<Character, Integer> map2) {
    	// ���� map ��size �������϶�Ҳ�����û�
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Character c : map1.keySet()) {
            try {
                if (map1.get(c) != map2.get(c)) {
                    return false;
                }
            } catch (NullPointerException e) {
                //  ˵��map2��û��map1�е�ĳ���ַ�
                return false;
            }
        }
        return true;
    }
}