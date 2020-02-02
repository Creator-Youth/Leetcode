package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-02-2020/2/2-10:09 下午
 *快排思想，快速查找中位数
 *先进行一次快排，确定中位数的位置，看中位数在左边还是右边，进行选择---》第二次快排，知道中间的数刚好是中位数
 时间复杂度未O（n）
 *
 */

import java.util.Random;

public class SelectQuick {
    public class Solution {
        public int findKthSmallest(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return Integer.MIN_VALUE;
            }
            int len = nums.length;
            return quickSelect(nums, k, 0, len - 1);
        }

        private int quickSelect(int[] nums, int k, int start, int end) {
            //Choose a pivot randomly
            Random rand = new Random();
            int index = rand.nextInt(end - start + 1) + start;//随机获取数组里的随机数
            int pivot = nums[index];
            swap(nums, index, end);
            int left = start, right = end;
            while(left < right) {
                if (nums[left++] >= pivot) {
                    swap(nums, --left, --right);
                }
            }
            //left is now pointing to the first number that is greater than or equal to the pivot
            swap(nums, left, end);
            //m is the number of numbers that is smaller than pivot
            int m = left - start;
            if (m == k - 1) { //in order to find the kth smallest number, there must be k - 1 number smaller than it
                return pivot;
            }
            else if (k <= m) { //target is in the left subarray
                return quickSelect(nums, k, start, left - 1);
            }
            else {
                //target is in the right subarray, but need to update k
                //Since we have discarded m numbers smaller than it which is in the right subarray
                return quickSelect(nums, k - m, left, end);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
