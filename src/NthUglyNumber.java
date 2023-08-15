import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    public static int nthUglyNumber(int n) { // 优先队列 / 最小堆
        int[] nums = {2, 3, 5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        pq.offer(1L);
        set.add(1L);
        
        long cur=-1L;

        // time complexity: O(nlogn)
        // sapce complexity: O(n)
        for(int i=0; i<n; i++) {
            cur = pq.poll();
            for(int num:nums) {
                if(!set.contains(cur*num)) {
                    pq.offer(cur*num);
                    set.add(cur*num);
                }
            }
        }

        return (int) cur;
    }
}
