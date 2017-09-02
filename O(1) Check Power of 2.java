������Ż������ٶȵĳ�������֮һ
ʹ���� Bit Manipulation	�� n & (n - 1)
������Ҳ����������������Ӧ�õ���
	1. �� n �Ķ����Ƶ����һλΪ1��λ��
	2. �� n �Ķ������� 1 �ĸ���

/*
Description
Using O(1) time to check whether an integer n is a power of 2.

Example
For n=4, return true;
For n=5, return false;

Challenge 
O(1) time

Tags 
Bit Manipulation
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }
        
        return (n & (n-1)) == 0;
    }
};
