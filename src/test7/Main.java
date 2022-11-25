package test7;

public class Main {
    public static void main(String[] args) throws Exception {
        makePrimeCircle(70);
    }

    public static void makePrimeCircle(Integer n) throws Exception {
        if (n % 2 != 0) {
            System.out.println("素数环元素必须为偶数");
            return;
        }
        // 初始化元素列表
        SqQueue lq = new SqQueue(n);
        for (int i = 2; i <= n; i++) {
            lq.offer(i);
        }

        int[] primeCircle = new int[n];
        primeCircle[0] = 1;
        boolean flag = true;
        int count = 0;
        while (!lq.isEmpty()) {
            for (int i = 0; i < lq.length(); i++) {
                if (isPrime(primeCircle[count] + (int) lq.peak())) {
                    if (count + 1 < n) {
                        count++;
                        primeCircle[count] = (int) lq.poll();
                        flag = false;
                    } else {
                        if (isPrime(primeCircle[count] + (int) lq.peak())
                                && isPrime(primeCircle[1] + (int) lq.peak())) {
                            count++;
                            primeCircle[count] = (int) lq.poll();
                            break;
                        }
                    }
                } else {
                    lq.offer(lq.poll());
                }
            }
            if (flag) {
                lq.offer(primeCircle[count]);
                count--;
                flag = true;
            }

        }
        for (int i : primeCircle) {
            System.out.print(i + " ");
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
