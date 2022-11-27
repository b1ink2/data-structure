package test6;

public interface IStack {
    public void Clear();// 清空栈

    public boolean IsEmpty(); // 判断栈是否为空

    public int Length(); // 判断栈的长度

    public Object Peak(); // 取栈顶元素的值

    public void Push(); // 入栈

    public Object Pop(); // 出栈

}
