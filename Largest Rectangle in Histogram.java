	������һ�������У���һ���� ��� / �ұ� ��һ������ С / �� ��Ԫ�أ�����ʹ��ջ������ݽṹ�������
ʹջ���� / �ݼ�. ÿһ�αȽ϶���һ��Ԫ�ؽ�ջ���߳�ջ�����ܹ�ΪO(N)�ν�ջ��O(N)�γ�ջ��
���ʱ�临�ӶȽ�ΪO(N).��һ���ǳ�������㷨��ֵ��ѧϰ��
	����for loop�������飬ÿ�� nums[i] С�� / ���� ջ��Ԫ��ʱ����ջ��Ԫ�� pop ������ֱ�� num[i] С�� / ����
ջ��Ԫ�ء�

/*
Description
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

histogram ��http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram ��http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Have you met this question in a real interview? Yes

Example
Given height = [2,1,5,6,2,3],
return 10.

Tags 
Array Stack
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            // �������ж�stack�ǿգ�Ȼ����ܽ���peek()����
            while (!stack.isEmpty() && cur < height[stack.peek()]) {
            	/* 
          		  ע�� h �� w ��ȡֵ˳���ܵ�������Ϊpop�����ᵼ��peek()�����任 
          	    �������˲������룬��Ȼ��ʹ��˳�����ı䣬������ w ȡֵʱ�ټ�1���ͺ�����
          	    ����Ȼ�Ǵ���ġ���Ϊ��һ���ǳ��ؼ��Ĳ��������ж� stack �Ƿ�Ϊ�գ�
          	    ��Ϊ�գ��� i ��Ϊ�����εĿ��ٸ�����:[5, 4, 2, 1].
          	    ��for loopѭ���� 2 ʱ�����������ȥ w������Ϊ 4 û�б� pop ��ȥʹ�� stack ��Ȼ��Ϊ��
          	    ���Եõ��� w = 2 - 1 = 1. �����ͻ�ʹ�� w �ĳ���������һ�� 1.
          	    ��������Ҫ��������㷨����pop�õ��߶ȣ�Ȼ�������ж�stack��ȡ���
            	*/
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, w * h);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
