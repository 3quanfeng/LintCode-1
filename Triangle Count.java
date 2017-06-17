	/**
	Given an array of integers, how many three numbers can be found in the array, 
	so that we can build an triangle whose three edges length is the three numbers 
	that we find?

	Example
	Given array S = [3,4,6,7], return 3. They are:

	[3,4,6]
	[3,6,7]
	[4,6,7]
	*/
	
	/*
	Thoughts:
	Pick 3 integers that fits the condition: 
	A + B > C
	B + C > A
	A + C > B
	If we sort the input, then we know A <= B <= C, so we can remove 2 conditoins above and only have:
	A + B > C
	That is, Pick one C, and pick two integers A,B in front. Similar to Two Sum - Input array is sorted.
	Have a fixed C as target, and find A + B > target in the remaining array on left of C. 
	How about just use 2 pointers left, right, and compare with a C (s[i] in for loop)
	Time: O(n^2)

	Note: don't forget to sort
	*/
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length <3)
        	return 0;
        int count = 0;
        int n = S.length;

        quicksort(S, 0, S.length-1);
        // �����ֱ�ӵ���Arrays.sort(S);ֱ�ӽ��п�������
        //	��߽����Կ��Ž�����д������ʾ��֮��Ĵ��뽫ֱ�ӵ���Java�Ѿ�ʵ�ֵķ���
				for (int i = 2; i < S.length; i++) {
					int left = 0;
					int right = i -1;
					while (left < right) {
						if (S[left] + S[right] > S[i]) {
							count += (right - left);		
							//  ��Ϊ�Ѿ�����С�����˳�������꣬��һ��S[left]+S[right]>S[i]��
							//	��ô˵��S���±����left~right��ֵ��S[right]��Ӿ�����S[i](C),�ʴ����right-left��������.
							//	ע�⣺������һ������S[right]�����ߵ���˼��
							right--;
						}
						else{
							left++;
						}
					}
				}  
        
        return count;
    }
    
        void quicksort(int a[], int low, int high)  // ���õݹ�Էָ�õ������������
    {
    	int middle;
    
    	if (low >= high)
    		return ;
    	middle = split(a, low, high);
    	quicksort(a, low, middle - 1);
    	quicksort(a, middle + 1, high);
    }
    
    int split (int a[], int low, int high)  
    {
    	int part_element = a[low];
    	
    	while (low < high)                         
    	{
    		while (low < high && a[high] > part_element)  
    			high--;
    		if (low < high)
    			a[low++] = a[high];         
    			
    		while (low < high && a[low] < part_element)
    			low++;
    		if (low < high)
    			a[high--] = a[low]; 
    	}
    
    	a[low] = part_element;
    	return low;
    }
}
