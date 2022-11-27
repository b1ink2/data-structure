package test8;

public interface IString {
    public void clear();

    public boolean isEmpty();

    public int length();

    public char charAt(int index); //返回串中元素

    public IString subString(int begin, int end); //截取子串

    public IString delete(int begin, int end); //删除

    public IString concat(IString str); //连接串

    public int compareTo(IString str); //串的比较

    public int indexOf(IString str, int begin); //字串定位
}
