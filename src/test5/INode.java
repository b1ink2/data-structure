package test5;

public interface INode {
    public void clear(); // 清空线性表

    public boolean isEmpty(); // 判断该表是否为空

    public int length(); // 求该表长度

    public Object get(int i); // 求该表的第i个元素

    public void insert(int i, Object x); // 在第i个位置插入元素x

    public void remove(int i); // 删除第i个元素

    public int indexOf(Object x); // 求元素x出现的位置

    public void display(); // 打印显示整个线性表

}
