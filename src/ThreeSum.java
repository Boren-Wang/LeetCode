// Given an integer array nums, 
// return all the triplets [nums[i], nums[j], nums[k]] 
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        HashSet<List<Integer>> listHashSet = new HashSet<>();

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 2, 1);
        List<Integer> list3 = Arrays.asList(4, 5, 6);

        listHashSet.add(list1);
        listHashSet.add(list2);
        listHashSet.add(list3);

        System.out.println("HashSet size: " + listHashSet.size()); // 输出为3，去重失败
    }

    // Input: nums = [-1,0,1,2,-1,-4]
    // Output: [[-1,-1,2],[-1,0,1]]
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res= new ArrayList<>();

        // O(nlogn)
        // [-4,-1,-1,0,1,2]
        Arrays.sort(a); 
        
        // // time complextiy: O(n^2logn) binary search
        // for(int i=0; i<a.length-2; i++) {
        //     if(i>0 && a[i]==a[i-1]) continue;
        //     for(int j=i+1; j<a.length-1; j++) {
        //         if(j>i+1 && a[j]==a[j-1]) continue;
        //         if(a[i]+a[j]>0) break;
        //         int target = 0-a[i]-a[j];
        //         int l=j+1;
        //         int r=a.length-1;
        //         while(l<=r) {
        //             int m = l+(r-l)/2;
        //             if(a[m]==target) {
        //                 res.add(Arrays.asList(a[i],a[j],a[m]));
        //             } else if(a[m]>target) {
        //                 r=m-1;
        //             } else {
        //                 l=m+1;
        //             }
        //         }
        //     }
        // }

        // time complextiy: O(n^2) two pointers
        for(int i=0; i<a.length-2; i++) {
            if(i>0 && a[i]==a[i-1]) continue;
            int x = a[i];
            int l = i+1;
            int r = a.length-1;
            while(l<r) {
                int sum = x+a[i]+a[j];
                if(sum>0) r--;
                else if(sum<0) l++;
                else {
                    res.add(Arrays.asList(a[l],a[r],x));
                    l++;
                    r--;
                    while(l<r && a[l]==a[l-1]) l++;
                    while(l<r && a[r]==a[r+1]) r--;
                }
            }
        }

        return res;
    }
}
