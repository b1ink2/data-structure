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

    public char[] charAt(int index) {
        if ((index<0) || (index>=curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue;
    }

    public void allocate(int newCapacity) {
        char[] temp = strvalue;
        strvalue = new char[newCapacity];
        for (int i=0; i<temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }

    public IString subString(int begin, int end) {
        if(begin < 0){
            throw new StringIndexOutOfBoundsException("起始位置小于0");
        }
        if(end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置大于字符串长度");
        }
        if(begin > end) {
            throw new StringIndexOutOfBoundsException("起始位置大于结束位置");
        }
        if(begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end-begin];
            for(int i = 0; i < buffer.length; i++) {
                buffer[i] = this.strvalue[i+begin];
            }
        }
        return new SeqString(buffer);
    }

    public IString insert(int offset, IString str) {
        if((offset<0) || (offset>this.curlen)) {
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.length;
        int newCount = this.curlen + len;
        if(newCount > this.strvalue.length) {
            this.allocate(newCount);
        }

        for(int i = this.curlen - 1; i>=offset; i--) {
            this.strvalue[len+i] = strvalue[i];
        }

        for(int i = 0; i<len; i++) {
            strvaluea[offset+i] = str.charAt(i);
        }

        this.curlen = newCount;
        return this;
    }

    public IString delete(int begin, int end) {
        if(begin < 0){
            throw new StringIndexOutOfBoundsException("起始位置小于0");
        }
        if(end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置大于字符串长度");
        }
        if(begin > end) {
            throw new StringIndexOutOfBoundsException("起始位置大于结束位置");
        }
        for (int i=0; i<curlen-end; i++){
            strvaluev[begin+i] = strvalue[end+i];
        }
        curlen = curlen - (end - begin);
        return this;
    }

    public IString concat(IString str) {
        return insert(curlen, str);
    }

    public int compareTo(IString str, int begin) {
        int len1 = this.curlen;
        int len2 = str.curlen;
        int n = Math.min(len1, len2);
        char[] s1 = this.strvalue;
        char[] s2 = str.strvalie;
        int k = 0;
        while(k<n) {
            char ch1 = s1[k];
            char ch2 = s2[k];
            if (ch1 != ch2) {
                return ch1-ch2;
            }
            k++;
        }
        return len1-len2;
    }

    public int indexOf(IString str, int begin) {
        if(begin>0) {
            int n = this.length;
            int m = str.length;
            int i = begin;
            while(i<=n-m+1) {
                if(compareTo(subString(i, i+m), str) != 0) {
                    i++;
                } else {
                    return i;
                }

            }
        }
        return -1;
    }
}
