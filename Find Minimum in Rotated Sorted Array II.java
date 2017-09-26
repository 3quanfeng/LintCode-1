/*
Medium Find Minimum in Rotated Sorted Array II My Submissions

40% Accepted
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

Example
Given [4,4,5,6,7,0,1,2] return 0

Tags Expand 
Binary Search Divide and Conqueri

*/

// version 1: just for loop is enough
public class Solution {
    public int findMin(int[] num) {
        //  �����Ŀ�������в�����д�����ĳ���
        //  ֻ��Ҫ֪�������� [1,1,1....,1] ����һ��0
        //  �������ʹ��ʱ�临�Ӷȱ����� O(n)
        //  ���дһ��forѭ���ͺ��ˡ�
        //  �������ã�����ÿ��������������������ö��ַ������������������������дһ�����ְɡ�
        //  �������Կ��Ĳ�������������ϻ᲻���ö��ַ��������Ŀ��������벻��õ�������
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min)
                min = num[i];
        }
        return min;
    }
}

// version 2: use *fake* binary-search
// When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, 
// so just let upper bound reduce one.
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge == & <
            } else {
                start = mid;
                // or start = mid + 1
            }
        }
        
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}

