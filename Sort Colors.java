�� Partition Array / Sort Letters by Case ����ͬһ����
��ͬ���ڸ�������Ҫ��� 3 ��Ԫ�ؽ�������
���������Ҫ 3 ��ָ�����������򣬷ֱ���� 0, 1, 2 �� red, white, blue
����:
	start ָ��ͷ�ڵ� red , i ��ͷ�ڵ㿪ʼ������ whilte, end ָ�����һ���ڵ� blue
	�� a[i] = 0 ʱ��˵��Ϊ red, Ӧ������ǰ�棬�� swap(a[start], a[i])
	�� a[i] = 1 ʱ��˵��Ϊ while, Ӧ�����м䣬�� i ��������ƶ�
	�� a[i] = 2 ʱ��˵��Ϊ blue, Ӧ����ĩβ���� swap(a[i], a[end])
	ֱ�� i �� end �������ཻ�����������

	�㷨ʱ�临�Ӷ�Ϊ O(N)
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
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, start, i);
                start++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, end);
                // ������ a[i] λ���ϵ�������Ϊ 0 �� 1,����Ҫ�ٽ���һ���жϣ����ܽ��� i++ �Ĳ���
                end--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}