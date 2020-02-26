package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-02-2020/2/26-4:52 下午
 *
 */

class Solution {
    public int jump(int[] nums) {
        int step =0;
        int max=0;
        int root=0;
        for(int i=0;i<nums.length;){
            if(i+nums[i]>=nums.length-1){
                break;
            }else{
                for(int j=1;j<=nums[i];j++){
                    //j:跳跃步数。
                    if(j+nums[i+j]>max){
                        root=j;
                        max=j+nums[i+j];
                        continue;
                    }
                }
                max=0;
                i=i+root;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] data= {2,3,1,1,4};
        System.out.println((new Solution()).jump(data));
    }
}