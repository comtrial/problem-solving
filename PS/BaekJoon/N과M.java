package BaekJoon;

import java.util.Scanner;

public class N과M {
    static StringBuilder sb = new StringBuilder();
    static int maxDepth;
    static int[] arr;
    static boolean[] visit;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        maxDepth = m;
        // 백트래킹: 어떤 노드의 유망성을 판단한 뒤, 해당 노드가 유망하지 않다면,
        //         **부모노드로 돌아가** 다른 자식의 노드를 탐색하는 방법
        // 1. 1...n 까지의 배열 생성
        // 2. for 돌면서 node 방문 (depth 1)
        // 3. depth 가 m 일 경우 유효성 검증 조건이므로 더 깊이 들어가지 않고 다음 형제 노드 방문
        // 4. 상위에 이미 존재하는 부모 노드임을 판단하기 위해 visit 사용
        arr = new int[n];
        visit = new boolean[n];

        for (int i : arr) {
            System.out.println(i);
        }
//        for (int i=0; i<n; i++) arr[i] = i+1;

        dfs(0, new int[maxDepth]);

        System.out.println(sb);
    }

    // 1. dfs 구현시 그림으로 이해했기 때문에 연결이 되어있는 것을 알지만, 아래와 같이 무지성 for 문으로
    // dsf 재귀를 돌려 하위 노드 (depth 를 통해 하위임을 파악) 로 보내버리면 연결이 되어있음을 직관적으로 알기 어렵지만,
    // visit 이라는 고유의 노드들의 index 를 가지고 있는 배열의 boolean 을 통해서 현재 depth 에서 연결 되어 잇는 부모 노드의
    // 연결 여부를 visit arr 를 통해서 알 수 잇는 거야

    private static void dfs(int depth, int[] answerArr) {
        // 종료조건
        if (depth == maxDepth) {
            for (int answer: answerArr) sb.append(answer + " ");
            sb.append("\n");
            return;
        }
        // 기본실행
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answerArr[depth] = arr[i];
                dfs(depth+1, answerArr);
                visit[i] = false;
            }
        }
    }
}
