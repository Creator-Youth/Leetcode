package com.wxs.leetcode;/*
 *  @author huajishaonian
 *  time : 2020-02-2020/2/26-5:51 下午
 *
 */

import java.util.Stack;

public class leetcode32 {
    public int longestValidParentheses1(String s) {
        if(s==null || s.length()<=0){
            return 0;
        }
        int result =0,left =0,right =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                result = Math.max(result,2*right);
            }else if(right>left){
                left=right=0;
            }
        }
        left=right=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                result = Math.max(result,2*left);
            }else if(right<left){
                left=right=0;
            }
        }

        return result;
    }

    public int longestValidParentheses(String s) {
        if(s==null || s.length()<=0){
            return 0;
        }
        int result =0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    result = Math.max(result,i-stack.peek());
                }
            }
        }
        return result;
    }
}
