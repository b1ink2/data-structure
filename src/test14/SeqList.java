package test14;

public class SeqList {
    public RecordNode[] r;
    public int curlen;

    public SeqList(int maxSize) {
        this.r = new RecordNode[maxSize];
        this.curlen = 0;
    }

    public void insert(int i, RecordNode x) throws Exception {
        if (curlen == r.length) {
            throw new Exception("full");
        }

        if (i < 0 || i > curlen) {
            throw new Exception("out of index");
        }

        for (int j = curlen; j > i; j--) {
            r[j] = r[j - 1];
        }
        r[i] = x;
        this.curlen++;
    }

    public void insertSortWithGuard() {
        int i, j;
        for (i = 1; i < this.curlen; i++) {
            r[0] = r[i];
            for (j = i - 1; r[0].key.compareTo(r[j].key) < 0; j--) {
                r[j + 1] = r[j];
            }
            r[j + 1] = r[0];
        }
    }

    public void shellSort(int[] d) {
        RecordNode temp;
        int i, j;
        for (int k = 0; k < d.length; k++) {
            int dk = d[k];
            for (i = dk; i < this.curlen; i++) {
                temp = r[i];
                for (j = i - dk; j >= 0 && temp.key.compareTo(r[j].key) < 0; j -= dk) {
                    r[j + dk] = r[j];
                }
            }
        }
    }

    public void bubbleSort() {
        RecordNode temp;
        boolean flag = true;
        for (int i = 1; i < this.curlen && flag; i++) {
            flag = false;
            for (int j = 0; j < this.curlen - i; j++) {
                if (r[j].key.compareTo(r[j + 1].key) > 0) {
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public int partition(int i, int j) {
        RecordNode pivot = r[i];
        while (i < j) {
            while (i < j && pivot.key.compareTo(r[j].key) <= 0) {
                j--;
            }
            if (i < j) {
                r[i] = r[j];
                i++;
            }

            while (i < j && pivot.key.compareTo(r[i].key) > 0) {
                i++;
            }
            if (i < j) {
                r[j] = r[i];
                j--;
            }
        }

        r[i] = pivot;
        return i;
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotloc = partition(low, high);
            quickSort(low, pivotloc - 1);
            quickSort(pivotloc + 1, high);
        }
    }

    public void selectSort() {
        RecordNode temp;
        for (int i = 0; i < this.curlen - 1; i++) {
            int min = i;
            for (int j = i + 1; j < this.curlen; j++) {
                if (r[j].key.compareTo(r[min].key) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
        }
    }

    public void mergeSort(RecordNode[] r,RecordNode[] order, int h, int m, int t) {
		int i = h;
		int j = m+1;
		int k = h;

		while(i<=m && j<= t) {
			if(r[i].key.compareTo(r[k].key)<=0) {
				order[k++] = r[i++];
			} else {
                order[k++] = r[j++];
            }
            while (i<=m) {
                order[k++] = r[i++];
            }
            while (j<=t) {
                order[k++] = r[j++];
            }
		}
	}
}
