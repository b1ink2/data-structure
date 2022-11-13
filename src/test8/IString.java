package test8;

public interface IString {
    public void clear();
    public boolean isEmpty();
    public int length();
    public char charAt(int index);
    public IString subString(int begin, int end);
    public IString delete(int begin, int end);
    public IString concat(IString str);
    public int compareTo(IString str);
    public int indexOf(IString str, int begin);
}
