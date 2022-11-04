package test8;

public class SeqString implements IString {
    private char[] strvalue;
    private int curlen;
    
    public SeqString() {
        strvalue = new char[0];
        curlen = 0;
    }
    
    public SeqString(String str) {
        char[] tempchararray = str.toCharArray();
        strvalue = tempchararray;
        curlen = tempchararray.length;
    }
    
    public SeqString(char[] value) {
        this.strvalue = new char[value.length];
        for (int i = 0;i < value.length; i++) {
            this.strvalue[i] = value[i];

        }
    }
    
    public void clear(){
        this.curlen = 0;
    }
    
    public boolean isEmpty(){
        return curlen == 0;
    }
    
    public int length() {
        return curlen;
    }
    
    public char charAt(int index) {
        if ((index<0) || (index>=curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue;
    }
    
    public void allocate(int newCapacity) {
        char[] temp = strvalue;
        strvalue = new char[newCapacity];
        for (int i=0; i<temp; i++) {
            strvalue[i] = temp[i];
        }
    }
    
    public IString subString(int begin, int end) {
        
    }
    
    public IString insert(int offset, IString str) {
        
    }
    
    public IString delete(int begin, int end) {
        
    }
    
    public IString concat(IString str) {
        return insert(curlen, str);
    }
    
    public int compareTo(IString str, int begin) {

    }
}
