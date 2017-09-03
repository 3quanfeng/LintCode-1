������Ҫ����ķ�Χ�������� k,��ʱ�Ѿ�����ͨ�� ���� �㷨����һ���ˡ�
�����޷�ͨ����һ�α������ܹ��õ������������ǿ���ʹ�������㷨��
�������㷨��ʱ�临�Ӷ�����Ҳ��Ҫ O(nlogn),�������Ѿ�����������ķ�Χ 1~k.
�����ǿ����ܹ�ͨ������Ϣ�����ӶȽ��͵� O(nlogk) �أ�
���������뵽�� ���� ��˼�롣
���������� Partition Array ��ͬ��ֻ�ǽ� Partition Array �е� k ÿ���滻�� colorMid ���ѡ�
������
	1. ����whileѭ����left ָ��������ұ�����ֱ�� left ָ��Ľڵ��ֵ���� colorMid.
	2. ͬ�� right ָ��������������ֱ�� right ָ��Ľڵ��ֵС�� colorMid.
	3. ����left��right�ڵ㣬ֱ��left��right�����ڵ����������ཻ��
	4. �ݹ���ø÷������������� colorMid �� ��벿�� �� �Ұ벿�֡� ����ʵ����Ҳ�ǿ��ŵ�������
	�㷨ʱ�临�Ӷ�Ϊ O(nlogk)
	
/*
Description
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Notice
You are not suppose to use the library's sort function for this problem. 
You should do it in-place (sort numbers in the original array).

Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?

Tags 
Sort Array Two Pointers Facebook
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        
        sortColors2Helper(colors, 0, colors.length - 1, 1, k);
    }
    
    private void sortColors2Helper(int[] colors,
                                   int left, 
                                   int right, 
                                   int colorFrom,
                                   int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        if (left >= right) {
            return;
        }
        
        int l = left, r = right;
        int colorMid = colorFrom + (colorTo - colorFrom) / 2;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            } 
            while (l <= r && colors[r] > colorMid) {
                r--;
            }
            
            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }
        }
        
        sortColors2Helper(colors, left, r, colorFrom, colorMid);
        sortColors2Helper(colors, l, right, colorMid + 1, colorTo);
    }
}