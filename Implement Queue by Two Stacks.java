ջ�������ݽṹ�� �Ƚ���� �ģ����������� �Ƚ��ȳ� ��.
����Stack��˵�����ǽ����ݴ���һ��ջ֮����ȡ��������˳���ǵ������ġ�
��ô���Ǳ�����뵽���Ƿ����ͨ������ջ��ʵ�� Queue ������ݽṹ��
 ���ӵ�һ��ջ������ȫ��ȡ����Ȼ���ٴ�push���ڶ���ջ�
 ʵ����һ�η�ת˳����������ȡ���������ݱ���˳����ˡ�Ҳ���Ƕ��е� FIFO.

/*
Description
As the title described, you should only use two stacks to implement a queue's actions.
The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
Both pop and top methods should return the value of first element.

Example
For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2

Challenge
implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.

Tags Expand 
LintCode Copyright Stack Queue
*/

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
    	// �ǵ���Ҫ�ж�stack2�Ƿ�Ϊ��
    	// ��stack�е���������pop������Ȼ��push��stack2�У�ʵ��˳��ķ�ת
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }

    public int top() {
    	// �ǵ���Ҫ�ж�stack2�Ƿ�Ϊ��
    	// ��stack�е���������pop������Ȼ��push��stack2�У�ʵ��˳��ķ�ת
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
}