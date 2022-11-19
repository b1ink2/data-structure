package test6;

public class Stack {

    private Object[] stackELem; //
    private int top; // 栈中元素个数

    public Stack(int max) {
        this.top = 0;
        this.stackELem = new Object[max];
    }

    public void Clear() {
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public int Length() {
        return top;
    }

    public Object Peak() {
        // 返回栈顶元素
        if (!isEmpty())
            return stackELem[top - 1];
        else
            return null;
    }

    public void Push(Object x) throws Exception {
        // 压入栈
        if (top == stackELem.length)
            throw new Exception("Stack Over Flow");
        else
            stackELem[top++] = x;
    }

    public Object Pop() {
        // 弹出
        if (isEmpty())
            return null;
        else
            return stackELem[--top];
    }
}
