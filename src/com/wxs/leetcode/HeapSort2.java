package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-02-2020/2/7-12:44 下午
 *
 */

import java.util.Arrays;

public class HeapSort2 {

    private int[] data;  //排序用的辅助数组
    private int size;    //输入数值的索引
    public HeapSort2(int capacity){
        this.data = new int[capacity];
        this.size = 0;   //初始容量
    }

    @Override
    //输出堆
    public String toString() {
        return Arrays.toString(data);
    }

    //插入元素最后一个，逐步与父节点比较
    public  void insert(int value) throws Exception {
        if(size >=data.length ){
            throw new Exception("堆已满");
        }else{
            data[size]=value;
            int i =size;
            size++;
            while(i>0){
                int p = (i-1)/2;
                if(data[i]<data[p]){
                    data[i]= data[i]^data[p];
                    data[p]= data[i]^data[p];
                    data[i]= data[i]^data[p];
                    i = (i-1)/2;
                }else{
                    break;
                }
            }
        }
    }
    public int deleteMin() throws Exception {
        int res;
        if(size<=0){
            throw new Exception("堆空");
        }else{
            res=data[0];
            size --;
            data[0]=data[size];
            int i=0;
            while(i*2+1<size){
                int left = i*2+1;
                int right = i*2+2;
                if (right<size && data[left]>data[right]&&data[right]<data[i]){
                    //交换
                    data[i]= data[i]^data[right];
                    data[right]= data[i]^data[right];
                    data[i]= data[i]^data[right];
                    i=right;
                }else if(data[left]<data[i]&&(right<=size||data[left]<=data[right])){
                    //交换
                    data[i]= data[i]^data[left];
                    data[left]= data[i]^data[left];
                    data[i]= data[i]^data[left];
                    i=left;
                }else{break;}

            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {

        int data[] = {1,4,6,3,2,5,7};
        HeapSort2 sort = new HeapSort2(data.length);
        for (int a:data
             ) {
            sort.insert(a);
        }
        System.out.println("排序结束");
        System.out.println(sort.toString());
        int j=0;
        while(j<data.length){
            System.out.println(sort.deleteMin());
            j++;
        }

    }
}
