package test15;

import test7.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] n = {11,14,20,3,7,33};
        n = bucketSort(n, 2);
        for (int i : n) {
            System.out.println(i+" ");
        }
        // System.out.println(getX(20, 4));
    }
    public static int[] bucketSort(int[] num, int x) {
        NodeQueue[] bucket = new NodeQueue[10];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new NodeQueue();
        }

        for (int i = 1; i <= x; i++) {
            for (int n : num) {
                bucket[getX(n, i)].offer(n);
            }

            int count=0;

            for (NodeQueue p : bucket) {
                while(!p.isEmpty()) {
                    num[count] = (int)p.poll();
                    count++;
                }
            }
        }

        return num;
    }

    public static int getX(int n, int x) {
        for (int i = 1; i < x; i++) {
            n /= 10;
        }
        return n % 10;
    }
}