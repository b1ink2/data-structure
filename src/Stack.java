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
        if (!isEmpty())
            return stackELem[top - 1];
        else
            return null;
    }

    public void Push(Object x) throws Exception {
        if (top == stackELem.length)
            throw new Exception("Stack Over Flow");
        else
            stackELem[top++] = x;
    }

    public Object Pop() {
        if (isEmpty())
            return null;
        else
            return stackELem[--top];
    }
}
