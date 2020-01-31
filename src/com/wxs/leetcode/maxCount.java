package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-01-2020/1/21-9:08 下午
 *
 */
import java.util.Scanner;


public class maxCount{
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N==0)System.out.print(0);
        int[] array = new int[N];
        for(int i =0; i<N; i++){
            array[i] = scanner.nextInt();
        }
        int i = 0,j= 1,max =array[0],count = array[0];

        while(j<N){
            if(count +array[j]>=max){
                max   = count+array[j];
                count =max;
                j++;
            }else{
                j++;
                i++;
                count = count -array[i]+array[j];

            }
        }
        System.out.println(max);
    }

}
