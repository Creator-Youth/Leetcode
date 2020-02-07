package com.wxs.leetcode;
/*
 *  @author huajishaonian
 *  time : 2020-01-2020/1/31-1:52 下午
 *
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BitTree
{
    private int data;
    private BitTree lchild;
    private BitTree rchild;
    HashMap<Integer,Integer> hashMap = new HashMap<>();

    HashMap<Integer,Integer> Map = new HashMap<>();
    public BitTree()
    {
    }


    public BitTree(int data)
    {
        this.data=data;
        this.lchild=this.rchild=null;
        hashMap.put(1,2);
        hashMap.put(1,4);
    }

    public BitTree createBitTree(Scanner reader)  //创建二叉树
    {
        BitTree root=null;
        int m=reader.nextInt();
        if(m<=0) return null;
        root=new BitTree(m);
        root.lchild=createBitTree(reader);
        root.rchild=createBitTree(reader);
        return root;
    }

    public static void preVisited(BitTree root)     //前序遍历
    {
        if (root==null)
        {
            return;
        }
        System.out.println(root.data);
        preVisited(root.lchild);
        preVisited(root.rchild);

    }

    public void preVisited1(BitTree root)     //前序遍历
    {
        if (root==null)
        {
            return;
        }
        Stack <BitTree> stack =new Stack <BitTree>();
        while (root!=null)
        {
            System.out.println(root.data);
            stack.push(root);
            root=root.lchild;
        }
        while(!stack.isEmpty())
        {
            root=stack.pop();
            while (root.rchild!=null)
            {
                root=root.rchild;
                System.out.println(root.data);
                stack.push(root);
                root=root.lchild;
            }
        }

    }

    public static void preVisited3(BitTree root)     //前序遍历
    {
        if (root==null)
        {
            return;
        }
        Stack <BitTree> stack =new Stack <BitTree>();
        while (root!=null)
        {
            stack.push(root);
            root=root.lchild;
        }
        while(!stack.isEmpty())
        {
            root=stack.pop();
            while(root.rchild!=null)
            {

            }
        }
    }

    public void aftVisited(BitTree root)   //后前序遍历
    {
        if (root==null)
        {
            return;
        }
        Stack <BitTree> stack =new Stack <BitTree>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            BitTree temp=stack.pop();

            if(temp.lchild==null && temp.rchild==null)
            {
                System.out.print(temp.data+"+");
                continue;
            }

            {
                BitTree NewOne= new BitTree(temp.data);
                stack.push(NewOne);
                if(temp.rchild!=null)stack.push(temp.rchild);
                if(temp.lchild!=null)stack.push(temp.lchild);

            }
        }
    }

    public static void main(String[] agrs)
    {
        Scanner reader= new Scanner(System.in);
        BitTree bt= new BitTree();
        bt.preVisited1(bt.createBitTree(reader));
    }

}
