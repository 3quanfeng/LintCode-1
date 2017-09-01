Kadane��s Algorithm

Solution 1: Greedy
�� Best Time to Buy and Sell Stock I ʵ��������ͬ�ġ�
������Ҫע����� Stock I �У������Ʊһֱ�ڵ����ǿ��Բ���ʹ�� profit ���ֵΪ 0.
�����ڱ����У����������Ԫ�ؾ�Ϊ������Maximum Subarray �ǿ���Ϊ�����ġ�
��˳�ʼ����ʱ��max = Integer.MIN_VALUE. 
����Ҫע�� sum += i ֮�������� max �Ƚϵõ� max��
Ȼ���ٽ� sum �� 0 �Ƚϣ��õ���һ��������ӵ�ֵ��

Solution 2: Prefix Sum
i��j�ĺͿ����� ǰj�� ���ĺͼ�ȥ ǰi-1 �����ĺ�
��������������������
	sum ��ʾǰi�����ĺ�;
	maxsum��ʾ����; 
	minsum��ʾ��С�͡�
ָ������ƶ�һλ������Ҫ��Ҫ�¼��������ʱ.Ҫ�Ƚ� �������������maxsum �� ������������ܹ��ĺͼ�ȥ��С�ĺ͵�sum-minsum ��������˭��
��С�ĺͣ���С�ͳ�ʼ��Ϊ0����ָ����ƣ��ж��µ������Ƿ���������ʱ��Ҫ�Ƚϲ������������minsum�ͼ����������minsum˭С�����������û��ʹ��С�ĺ͸�С�������������С����
����˼�����޳��������и����õġ�

��һ�������Բμ���http://blog.csdn.net/u012255731/article/details/52302189

/*
 Description
Given an array of integers, find a contiguous subarray which has the largest sum.

Notice
The subarray should contain at least one number.

Example
Given the array [?2,2,?3,4,?1,2,1,?5,3], the contiguous subarray [4,?1,2,1] has the largest sum = 6.

Challenge 
Can you do it in time complexity O(n)?

Tags 
Greedy LinkedIn Array LintCode Copyright Subarray Enumeration
*/

// Solution 1: Greedy
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        
        return max;
    }
}

// Version 2: Prefix Sum
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}