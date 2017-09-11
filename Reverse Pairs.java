�������ָ a[i]>a[j], i<j. ��ô������Ĺ����У����a[i]��a[j]������������������Ĺ��̣�ÿ����һ�Σ�����һ������Եġ����򡱹��̡�

˼·�����÷��ε�˼�룺����ǰ��һ�����������������������һ����������������
Ȼ����ǰ��һ������Ⱥ���һ�������д�����ĸ�����Ҳ������������������������̼��������������������Ŀ�ˡ�
���������ǲ����е���鲢�����أ��鲢�����˼����ǰ�ǰһ�����򣬺�һ������Ȼ������������
���ң��鲢����Ĺ���У���Ҫ�ж�ǰһ������ͺ�һ�������е�ǰ���ֵĴ�С��
��Ҳ���Ǹո�������������жϹ����ˡ����ǰһ������ĵ�ǰ���ִ��ں�һ������ĵ�ǰ���֣���ô�����һ������ԡ�
    ����ʹ������ָ�� i, j�ֱ�ָ���������� subarray ����ʼλ�á�
    �� j <= end && nums[i] > nums[j] ʱ����ָ�� j ���������ƶ���ֱ���������Բ�����Ϊֹ��
    �������Ǳ��ܹ��������߲���ָ��ָ�� i ʱ���ж��ٸ��������ԡ�
    ��� i ������ mid ������������ߵ� subarray�������Ǳ���Եõ��ܹ��ж��ٸ�����ԡ�
    ��ˣ������ڹ鲢�����еĺϲ������м���������.

LeetCode �ϻ��� BST / BIT �Ľ���Լ������������ϸ������
https://leetcode.com/problems/reverse-pairs/discuss/

/*
Description
For an array A, if i < j, and A [i] > A [j], called (A [i], A [j]) is a reverse pair.
return total of reverse pairs in A.

Example
Given A = [2, 4, 1, 3, 5] , (2, 1), (4, 1), (4, 3) are reverse pairs. return 3

Tags 
Array Merge Sort
*/

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int start, int end){
        if (start >= end) {
            return 0; 
        }

        int mid = start + (end - start) / 2; 
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end); 
        for(int i = start, j = mid+1; i <= mid; i++){
            while(j <= end && nums[i] > nums[j]) {
                j++;    
            }
            count += j - (mid + 1); 
        }
        Arrays.sort(nums, start, end+1); 
        return count; 
    }
}