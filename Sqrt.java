��Ϊ��ȷ��ֻҪ�� ����, �ʱ����Ǹ��ܼ򵥵� ���ֲ��ҷ�����Ŀ.
�����ϰ��� Binary Search Template ��д���ɡ�������Ͳ���̫���ˡ�
����֮���Ա�д����������ԭ��
	1. ����Ծ�ȷ���н�һ��Ҫ���أ�����Ҫ��ȷ�� 1e-6 �ء�
	���ʱ����Ҫ�õ��ĸ�Ч�㷨���� ţ�ٵ������� �㷨���İ� P13 �бʼ�
	������������ǿ����Ʋ���https://www.zhihu.com/question/20690553
	�����������ѧԭ������˺ܺõķ���
	2. �����˴��� Magic Number 
	�ö�Դ�뱻Ӧ���� ������֮��3�� 
	Click here for detials: https://en.wikipedia.org/wiki/Fast_inverse_square_root

/*
Description
Implement int sqrt(int x).
Compute and return the square root of x.

Example
sqrt(3) = 1
sqrt(4) = 2
sqrt(5) = 2
sqrt(10) = 3

Challenge 
O(log(x))

Tags 
Binary Search Mathematics Facebook
*/

// Binary Search
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // find the last number which square of it <= x
        // ע����������Ҫ���ó� long ���У���Ȼ�ᵼ�¼���������
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
}

// Newton-Raphson method
class Solution {
	   /**
     * @param x a double
     * @return the square root of x
     */
    public int mySqrt(int x) {
        if (x < 0) {
            return Double.NaN;
        }
        
        double err = 1e-12;
        double t = c;
        while (Math.abs(t - c/t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        
        return t;
    }
}


// Magic Number 0x5f3759df !!!  So Amazing
float Q_rsqrt(float number) {
    long i;
    float x2, y;
    const float threehalfs = 1.5F;

    x2 = number * 0.5F;
    y  = number;
    i  = * ( long * ) &y;                       // evil floating point bit level hacking
    i  = 0x5f3759df - ( i >> 1 );               // what the fuck? �������䣡����ǧ����� ::>_<::
    y  = * ( float * ) &i;
    y  = y * ( threehalfs - ( x2 * y * y ) );   // 1st iteration
    //	y  = y * ( threehalfs - ( x2 * y * y ) );   // 2nd iteration, this can be removed

    return y;
}
