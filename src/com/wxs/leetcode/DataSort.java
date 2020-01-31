package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-01-2020/1/31-2:00 下午
 *
 */

public class DataSort {

    public static int partition(int data[], int low, int high)//切分方法
    {
        int i = low;
        int j = high + 1;
        int one = data[low];
        while (true) {
            while (data[++i] > one){
                if (i == high) {
                    break;
                }
            }
            while (data[--j] < one){
                if (j == low) {break ; }
            }
            if (i >= j){
                break;
            }
            {
                int t = data[j];
                data[j] = data[i];
                data[i] = t;
            }
        }
        int t = data[j];
        data[j] = data[low];
        data[low] = t;
        return j;


    }

    public static void quick(int data[], int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = partition(data, low, high);
        quick(data, low, mid - 1);
        quick(data, mid + 1, high);
    }
}
