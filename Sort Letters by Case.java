�� Partition Array ����ͬ�Ľⷨ
˼·��
	���������˼�룬����������ʵ���ǿ�����������е�һ��������ˡ�

	��������ָ��left��right�ֱ�ָ��Array����ʼ��ĩβ��

	����whileѭ����leftָ��������ұ�����ֱ��leftָ��Ľڵ�Ϊ UpperCase.
	ͬ��rightָ��������������ֱ��rightָ��Ľڵ�Ϊ LowerCase.

	����left��right�ڵ㣬ֱ��left��right�����ڵ����������ཻ��

	�㷨���Ӷ�Ϊ��O(N)

/*
Description
Given a string which contains only letters. Sort it by lower case first and upper case second.

Notice
It's NOT necessary to keep the original order of lower-case letters and upper case letters.

Example
For "abAcD", a reasonable answer is "acbAD"

Challenge 
Do it in one-pass and in-place.

Tags 
Sort LintCode Copyright String Two Pointers
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && Character.isLowerCase(chars[left])) {
                left++;
            }
            while (left < right && Character.isUpperCase(chars[right])) {
                right--;
            }
            
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
