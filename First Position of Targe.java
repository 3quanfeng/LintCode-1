/*
	Keypoints:
		1. start + 1 < end;  ������ָ�����ڻ����ཻʱ�˳�whileѭ��
		2. start = start + (end - start) / 2;
		3. nums[mid] ==, <, > ���������δ���
		4. nums[start], nums[end] ? target.
*/

/*
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.

Challenge 
If the count of numbers is bigger than 2^32, can your code work properly?

Tags 
Binary Search Array
*/

public class Solution {
    public int bianrySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //  	Ϊʲô��д�� mid = (start + end) / 2;
            //    ��ֹ�������start��end��ֵ���ǽӽ�Integer.MAX_VALUEʱ�����ᷢ���������
            if (nums[mid] == target) {
                end = mid;
                //  if you want to find the last position, change it to :
                //	start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = target;
            }
        }
        
        //	find the first position when target occurs
        //  if you want to find the end position
        //  change the order of the two if :
        /*
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        } 
        */
        if (nums[start] == target) {
            return start;
        } 
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}

// ���ַ��ڶ���ģ��  Solution 2
// ��Ȼ�� Find the First Position
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        return -1;
    }
}