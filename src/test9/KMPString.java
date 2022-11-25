package test9;

import test8.SeqString;

public class KMPString extends SeqString {

    public int indexOf_BF(SeqString t, int start) {
        if (this != null && t != null && t.length() > 0 && this.length() >= t.length()) {
            int slen, tlen, i = start, j = 0;
            slen = this.length();
            tlen = t.length();
            while ((i < slen) && (j < tlen)) {
                if (this.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i = i - j + 1;
                    j = 0;
                }
            }
            if (j > t.length())
                return i - tlen;
            else
                return -1;
        }
        return -1;
    }

    public int[] getNext(SeqString T) {
        int[] next = new int[T.length()];
        int j = 1;
        int k = 0;
        next[0] = -1;
        next[1] = 0;
        while (j < T.length() - 1) {
            if (T.charAt(j) == T.charAt(k)) {
                next[j + 1] = k + 1;
                j++;
                k++;
            } else if (k == 0) {
                next[j + 1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return (next);
    }

    public int index_KMP(SeqString T, int start) {
        int[] next = getNext(T); // 计算模式串的next[]函数值
        int i = start; // 主串指针
        int j = 0; // 模式串指针
        while (i < this.length() && j < T.length()) { // 若对应字符串匹配
            if (j == -1 || this.charAt(i) == T.charAt(j)) { // j==-1代表S[i]!=T[0]
                i++;
                j++; // 转到下一对字符
            } else { // 当S[i]不等于T[j]时
                j = next[j];
            }
        }
        if (j < T.length()) {
            return -1;
        } else {
            return (i - T.length());
        }
    }
}
