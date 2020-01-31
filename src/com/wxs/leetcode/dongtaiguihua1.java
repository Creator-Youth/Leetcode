package com.wxs.leetcode;
/*
 *  @author huajishaonian
 *  time : 2020-01-2020/1/20-10:56 下午
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class dongtaiguihua1 {
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] param = bufferedReader.readLine().split(" ");
        int len = Integer.valueOf(param[0]);
        int target = Integer.valueOf(param[1]);
        String[] numbers = bufferedReader.readLine().split(" ");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = Integer.valueOf(numbers[i]);
        }
        System.out.println(getMinMoneyNum(array, target));*/
        //System.out.println(uniquePaths(3, 4));
        System.out.println(isValid("()[]{}"));
    }

    private static int getMinMoneyNum(int[] array, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp ,Integer.MAX_VALUE);
        dp[0] =-1;
        for(int i : array){
            dp[i]=1;
        }
        for(int i =1 ;i<dp.length;i++){
            for(int j : array){
                if(i-j>0&& dp[i-j]!=Integer.MAX_VALUE){
                    dp[i]= Math.min(dp[i],dp[i-j]+1);
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 :dp[target];
    }

    public static  int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for(int i =1 ;i<m;i++){
            dp[i][0]+=dp[i-1][0];
        }

        for(int i =1 ;i<n;i++){
            dp[0][i]+=dp[0][i-1];
        }

        for(int i=1;i<m;i++){
            for(int j =1 ; j<n;j++){
                dp[i][j] =dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charstr = s.toCharArray();
        if(!(charstr[0] == '(' || charstr[0] == '['|| charstr[0] == '{' )){
            return false;

        }else{
            stack.push(charstr[0]);
            for(int i =1 ;i<charstr.length;i++){
                if(!stack.isEmpty()&&stack.size()>charstr.length/2+1){
                    break;
                }else{
                    if(charstr[i] == '(' || charstr[i] == '['|| charstr[i] == '{' ){
                        stack.push(charstr[i]);
                    }else if(charstr[i]==(stack.peek())){
                        stack.pop();
                    }else {
                        stack.push(charstr[i]);
                    }
                }
            }
            if(stack.isEmpty()){
                return true;
            }
            return false;
        }
    }
}