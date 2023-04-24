package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
class Solution {
    static int answer;
    static HashSet<String> answerSet;
    static String[] nodeArr;
    static boolean[] visit;
    // 1. 방문한 노드에 대한 결과 값에 대한 추적이 제대로 이루어지고 있지 않다.
    //      현재는 그냥 sb 에 append 하는 형식으로 구현되어 있는데, 해당 방식이 dfs 가 return 될 때, 값의 추적이 일어나지 않음
    //
    public void solution(String numbers) {
        // - 소수 판별: 에라토스체
        //  1. 들어 온 문자열에 대해서 다 스플릿
        int answer = 0;
        nodeArr = numbers.split("");
        visit = new boolean[nodeArr.length];
        answerSet = new HashSet<String>();
        dfs(0, 0, "");

        for (String comb : answerSet) {
            if (isPrime(Integer.parseInt(comb))) {
                System.out.println(comb);
                answer++;
            }
        }
    }

    private void dfs(int depth, int index, String comb) {

        // 기본 실행
        if (comb != ""){
            if (isPrime(Integer.parseInt(comb))) {
                answerSet.add(comb);
            }
        }
//        System.out.println(comb);

        // 종료 좋건
//        if (!Arrays.asList(visit).contains(false)) return;
        if (depth == nodeArr.length || comb.equals("0")) return;

        // 기본 실행 재귀
        for (int i = 0; i < nodeArr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb += nodeArr[i];
                dfs(depth+1, i, comb);
                comb = comb.substring(0, comb.length() - 1);
                visit[i] = false;
                }
        }
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
        System.out.println("ssss" + answer);
    }
}