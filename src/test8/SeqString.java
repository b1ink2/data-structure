package test8;

public class SeqString {
    private char[] strvalue;
    private int curlen;

    // 无参构造
    public SeqString() {
        strvalue = new char[0];
        curlen = 0;
    }

    // 以字符串构造
    public SeqString(String str) {
        char[] tempchararray = str.toCharArray();
        strvalue = tempchararray;
        curlen = tempchararray.length;
    }

    // 以字符数组构造
    public SeqString(char[] value) {
        this.strvalue = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            this.strvalue[i] = value[i];

        }
    }

    public void clear() {
        this.curlen = 0;
    }

    public boolean isEmpty() {
        return curlen == 0;
    }

    public int length() {
        return curlen;
    }

    public char charAt(int index) {
        /* 
         * 返回字符串数组的索引位置的字符
         * 需要判断索引位置是否合法
         */
        if ((index < 0) || (index >= curlen)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return strvalue[index];
    }


    public void allocate(int newCapacity) {
        char[] temp = strvalue;
        strvalue = new char[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            strvalue[i] = temp[i];
        }
    }

    // 截取字符串
    public SeqString subString(int begin, int end) {
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置大于字符串长度");
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("起始位置大于结束位置");
        }
        if (begin == 0 && end == curlen) {
            return this;
        } else {
            char[] buffer = new char[end - begin];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = this.strvalue[i + begin];
            }
            return new SeqString(buffer);
        }
    }

    public SeqString insert(int offset, SeqString str) {
        /* 
         * 先将要插入新元素的位置上的元素后移插入串长度的位置
         * 然后将串插入
         */
        if ((offset < 0) || (offset > this.curlen)) {
            throw new StringIndexOutOfBoundsException("插入位置不合法");
        }
        int len = str.length();
        int newCount = this.curlen + len;
        if (newCount > this.strvalue.length) {
            this.allocate(newCount);
        }

        for (int i = this.curlen - 1; i >= offset; i--) {
            this.strvalue[len + i] = strvalue[i];
        }

        for (int i = 0; i < len; i++) {
            strvalue[offset + i] = str.charAt(i);
        }

        this.curlen = newCount;
        return this;
    }

    public SeqString delete(int begin, int end) {
        /* 
         * 判断起点和末尾索引是否合法
         * 若都合法则将末尾索引后面的内容依次提前
         * 再将列表挡墙长度修改
         */
        if (begin < 0) {
            throw new StringIndexOutOfBoundsException("起始位置小于0");
        }
        if (end > curlen) {
            throw new StringIndexOutOfBoundsException("结束位置大于字符串长度");
        }
        if (begin > end) {
            throw new StringIndexOutOfBoundsException("起始位置大于结束位置");
        }
        for (int i = 0; i < curlen - end; i++) {
            strvalue[begin + i] = strvalue[end + i];
        }
        curlen = curlen - (end - begin);
        return this;
    }

    public SeqString concat(SeqString str) {
        /* 
         * 合并串的合并相当于在末尾插入新的串
         */
        return insert(curlen, str);
    }

    public int compareTo(SeqString str) {
        /* 
         * 通过依次遍历比较字符是否相等
         * 从而判断串是否相等
         */
        int len1 = this.curlen;
        int len2 = str.curlen;
        int n = Math.min(len1, len2);
        char[] s1 = this.strvalue;
        char[] s2 = str.strvalue;
        int k = 0;
        while (k < n) {
            char ch1 = s1[k];
            char ch2 = s2[k];
            if (ch1 != ch2) {
                return ch1 - ch2;
            }
            k++;
        }
        return len1 - len2;
    }

    public int indexOf(SeqString str, int begin) {
        /* 
         * 先通过对比是否有字串相等
         * 若有则返回字串起始索引
         * 否则返回-1
         */
        if (begin > 0) {
            int n = this.curlen;
            int m = str.curlen;
            int i = begin;
            while (i <= n - m + 1) {
                if (str.compareTo(subString(i, i + m)) != 0) {
                    i++;
                } else {
                    return i;
                }

            }
        }
        return -1;
    }
}
