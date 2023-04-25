package BaekJoon;

import java.util.Scanner;

// 조합, 순열, 일차 방적식 등의 만들어 볼 수 있냐라는 말을 주어진 후보군 값들을 각각의 노드로
// 하위에 모든 노드를 자식으로 갖는 그래프롤 그려봄으로 탐색을 진행할 수 있다.

public class N과M2 {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int maxDepth;
    static boolean[] visit;
    static int[] answerArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(); //4 2
        maxDepth = m;
        //1 2
        //1 3
        //1 4
        //2 3
        //2 4
        //3 4

        // 1. 배열 만들어 주기
        arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = i+1;
        visit = new boolean[n]; // 예시가 2 이기 때문에 그려지지는 않지만, 3 depth 이상의 탐색을 진행시 방문한 노드에 대한 탐색이 어렵다.
        answerArr = new int[maxDepth];

        // 2. 각각의 노드를 탐색하는 dfs 를 재귀한다.
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int nodeIndex) {
        // 종료 조건
        if (depth == maxDepth) {
            for (int answer: answerArr) {
                sb.append(answer + " ");
            }
            sb.append("\n");
            return;
        }
        // 기본 실행: 하위 노드를 어떻게 정의하여 dfs 를 또 태워 탐색할 것이냐
        for (int i = nodeIndex; i < arr.length; i++) {
            System.out.println(visit[i]);
            if (!visit[i]) {
                visit[i] = true;
                answerArr[depth] = arr[i];
                dfs(depth+1, i+1);
                visit[i] = false;
            }
        }
    }
}
