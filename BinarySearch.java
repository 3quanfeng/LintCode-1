/*
	Keypoints:
		1. start + 1 < end;  ������ָ�����ڻ����ཻʱ�˳�whileѭ��
		2. start = start + (end - start) / 2;
		3. nums[mid] ==, <, > ���������δ���
		4. nums[start], nums[end] ? target.
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