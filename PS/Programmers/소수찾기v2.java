package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
class Solution6 {
    public void solution(String numbers) {
        int answer = 0;
//        nodeArr = numbers.split("");
    }

    public boolean isPrime(int n) {
        if (n==0 || n ==1) return false;

        for (int i = 2; i <= (int) Math.sqrt(n); i++)
            if (n==1 | n % i == 0) return false;

        return true;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("011"); //3
//        System.out.println("ssss" + answer);
    }
}