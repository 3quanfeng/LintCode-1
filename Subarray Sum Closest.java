/*
Description
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

Challenge 
O(nlogn) time

Tags 
Sort Subarray
*/

/**
 * Approach: PreSum + Sorting
 * �漰�� Subarray Sum ���⣬�������뵽�ľ���Ҫʹ�� Prefix Sum ��������⡣
 * �������� Subarray Sum �����ϵ���չ / �ۼӺ�ΪK��������� �ı��Ρ�
 * https://github.com/cherryljr/NowCoder/blob/master/%E7%B4%AF%E5%8A%A0%E5%92%8C%E4%B8%BAK%E7%9A%84%E6%9C%80%E9%95%BF%E5%AD%90%E6%95%B0%E7%BB%84.java
 *
 * ˼·��
 * �� Subarray Sum �У�����ͨ���� sum[0~a] = sum[0~b] = x �õ��� sum(a ~ b] = 0.
 * ��������Ҫ������ 0 ������ġ���ͬ������ Prefix Sum,ֻ����������Ҫ���ǽ����� Prefix Sum
 * ֮��Ĳ�ֵ������С��������һ�𷽱����ǲ��ҡ������������ı��� ����
 * ����������ﲻ��ʹ�� HashMap ����ʹ���� Array ��ʵ�֡�
 * ������Ϊ Array �޷��� HashMap ����һ����Ӧ�ļ�ֵ�ԣ�����������Ҫ�½�һ���� Point ���������ǡ�
 * ����Ȼʹ�ü򵥵Ķ�ά����Ҳ���ԣ������Ϊ��ʹ�ô������������⣩
 * 
 * ������
 *  1. �½� Point �࣬���� preSum �� index��
 *  2. �����������飬���ÿ��λ���ϵ� preSum �Լ���Ӧ�� index �����浽 map �С�
 *  3. �����еõ��� preSum������ preSum �Ĵ�С���� Sort (O(nlogn))
 *  4. �����õ��� map ���飬ͨ�� map[i].preSum - map[i-1].preSum ���Ƚϵõ���ӽ� 0 �� Subarray
 *  5. ���� index ����һ�� sort ����Եõ����𰸡�
 */
public class Solution {

    class Point {
        int preSum;
        int index;

        Point(int preSum, int index) {
            this.preSum = preSum;
            this.index = index;
        }
    }

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Point[] map = new Point[nums.length + 1];
        // ��ʼ�� map (��һ��Ԫ�ض�û�е�ʱ��preSumΪ0��indexΪ-1)
        map[0] = new Point(0, -1);
        int preSum = 0;
        // ��Ϊ������Ҫ�� preSum ������������ʹ�� ���� ���洢preSum����Ӧ��λ��.
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            map[i + 1] = new Point(preSum, i);
        }

        // �� Point ����С�����˳���������
        Arrays.sort(map, (a, b) ->
                a.preSum == b.preSum ? a.index - b.index : a.preSum - b.preSum);
        int[] rst = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < map.length; i++) {
            if (map[i].preSum - map[i - 1].preSum < diff) {
                // ������ ���ڲ�ֵ��С�� preSum ʱ������ diff �� ���������ұ߽�
                diff = map[i].preSum - map[i - 1].preSum;
                int[] temp = new int[]{map[i].index, map[i - 1].index};
                Arrays.sort(temp);
                rst[0] = temp[0] + 1;
                rst[1] = temp[1];
            }
        }

        return rst;
    }
}