package test6;

public class Stack {

    private Object[] stackELem; // 栈中所有元素
    private int top; // 栈中元素个数

    // 构造一个栈
    public Stack(int max) {
        this.top = 0;
        this.stackELem = new Object[max];
    }

    // 清空栈
    public void Clear() {
        this.top = 0;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return this.top == 0;
    }

    // 返回栈中元素个数
    public int Length() {
        return top;
    }

    // 返回栈顶元素, 若栈为空返回null
    public Object Peak() {
        if (!isEmpty())
            return stackELem[top - 1];
        else
            return null;
    }

    // 将对象压入栈
    public void Push(Object x) throws Exception {
        if (top == stackELem.length)
            throw new Exception("Stack Over Flow");
        else
            stackELem[top++] = x;
    }

    // 将栈顶元素弹出栈
    public Object Pop() {
        if (isEmpty())
            return null;
        else
            return stackELem[--top];
    }
}
