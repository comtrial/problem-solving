package Programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
class Solution {
    static int answer;
    static String[] nodeArr;
    static boolean[] visit;

    public void solution(String numbers) {
        // - 소수 판별: 에라토스체
        //  1. 들어 온 문자열에 대해서 다 스플릿
        int answer = 0;
        nodeArr = numbers.split("");
        visit = new boolean[nodeArr.length];
        // 2. 스플릿된 모든 문자열의 조합 만들기
        //      if 0 으로 시작하면 안대j
//        for (int i=0; i<nodeArr.length; i++)
        dfs(0, 0, "");
    }

    private void dfs(int depth, int index, String comb) {

        // 기본 실행
        if (comb != ""){
            if (isPrime(Integer.parseInt(comb))) this.answer += 1;
        }
        System.out.println(comb);

        // 종료 좋건
//        if (!Arrays.asList(visit).contains(false)) return;
        if (depth == nodeArr.length) return;

        // 기본 실행 재귀
        for (int i = 0; i < nodeArr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb += nodeArr[i];
                dfs(depth+1, i, comb);
                visit[i] = false;
                }
        }
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++)
            if (n % i == 0) return false;

        return true;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("17"); //3
        System.out.println("ssss" + answer);
    }
}