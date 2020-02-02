package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-02-2020/2/2-9:45 下午
 *
 */

import java.util.Arrays;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        for(int i:coins){
            count[i]=1;
        }
        for(int i =0 ;i<amount+1;i++){
            for(int j:coins){
                if(i-j>=0 && count[i-j]!=Integer.MAX_VALUE){
                    count[i]=Math.min(count[i],count[i-j]+1);
                }
            }

        }
        return count[amount]==Integer.MAX_VALUE ? -1:count[amount];

    }
}
