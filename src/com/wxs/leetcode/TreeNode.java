package com.wxs.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {


    int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        if(null !=root ){
            stack.push(root);
            list.add(root.val);
            root = root.left;

        }
        while(!stack.isEmpty()){
            root = stack.pop();
            while(null != root.right){
                stack.push(root.left);
                list.add(root.val);
                root =root.left;
            }
        }
        return list;
    }
}