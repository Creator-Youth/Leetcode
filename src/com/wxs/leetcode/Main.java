package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-02-2020/2/15-2:55 下午
 *
 */



import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int height[]= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));

    }
    public static int trap(int[] height) {
        int max =0;
        for(int i =0;i<height.length;){
            if(height[i]>0){
                int j=i+1;
                while(j<height.length&&height[j]<height[i]){
                    j++;
                }
                if(j>i+1&&height[j]>height[i]){
                    for(int k=i;k<j;k++){
                        max+=(height[i]-height[k]);
                    }

                }
                if(height[j]<height[i] || j==i+1){
                    i++;
                }
                else{
                    i=j;
                }

            }
            else{
                i++;
                continue;
            }
        }
        return max;

    }
}