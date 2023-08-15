import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。

public class NthSuperUglyNumber {
    public static void main(String[] args) {
        int n = 100000;
        int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,
            83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,
            181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,
            281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,
            401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541};
            System.out.println(nthSuperUglyNumber(n, primes));
        }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        pq.offer(1);
        set.add(1);
        
        int cur=-1;
        // nklog(nk)
        for(int i=0; i<n; i++) {
            cur = pq.poll();
            for(int p:primes) {
                if((p>Integer.MAX_VALUE/cur) || cur%p==0) break;
                if(!set.contains(p*cur)) {
                    pq.offer(p*cur);
                    set.add(p*cur);
                }
            }
        }
        return cur;
    }

    // 带入队控制的优先队列，不用set ???????
    public static int nthSuperUglyNumber2(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                if (x % k == 0) break;
            }
        }
        return -1; // never
    }

作者：宫水三叶
链接：https://leetcode.cn/problems/super-ugly-number/solutions/924673/gong-shui-san-xie-yi-ti-shuang-jie-you-x-jyow/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
