package com.wxs.leetcode;
/*
 *  @author huajishaonian
 *  time : 2020-01-2020/1/21-3:03 下午
 * 堆排序
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args) {
        //输入数据进行处理。输入数据想象成一棵树。
        System.out.println("输入要排序的值，输入的每个值用逗号隔开:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] strArray = str.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        System.out.println("排序前的数组：" + Arrays.toString(array));
        // 排序
        heapSort(array);
        System.out.println("排序后的数组：" + Arrays.toString(array));
    }

    /**
     * 堆排序
     *
     * @param array 需要进行排序的数组
     */
    private static void heapSort(int[] array) {
        for(int i =array.length/2-1;i>=0;i--){
            downAdjust(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));

        for (int i = array.length-1; i>0;i-- ) {
            array[0] = array[i]^array[0];
            array[i] = array[i]^array[0];
            array[0] = array[0]^array[i];
            downAdjust(array,0,i);
        }
    }

    /**
     * 将无序数组构造成一个大根堆
     *
     * @param array       待调整的堆数组
     * @param parentIndex 父结点的索引
     * @param length      需要调整的堆数组的大小
     */
    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];

        for(int child = 2*parentIndex+1; child<length;child = 2*child+1){
            if(child+1<length && array[child]<array[child+1]){
                child++;
            }
            if(array[child]>temp){
                array[parentIndex]=array[child];
                parentIndex = child;
            }else{break;}

        }
        array[parentIndex]= temp;
    }

}

