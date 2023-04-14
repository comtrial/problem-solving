
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
        int startNode = 1;

        System.out.println(bfs(startNode, graph));
    }

    public static String bfs(int startNode, int[][] graph) {
        StringBuilder sb = new StringBuilder();
        // 1. 큐 생성 및 시작점에서의 1촌 큐에 추가
        Queue<Integer> q = new LinkedList<Integer>();
        // 2. 이미 방문한 큐 배열
        boolean[] visited = new boolean[graph.length];


        // 3. 큐에 시작점 삽입
        q.offer(startNode);
        // 4. 시작점 방문 처리
        visited[startNode] = true;
        
        // while 큐가 비어있지 않을 경우:
        while (!q.isEmpty()) {
        //  1. 큐에서 노드 추출
            int nodeIndex = q.poll();
            sb.append(nodeIndex + "-> ");
            //  큐에서 꺼낸 노드와 연결된 노드들 확인
            for (int i = 0; i < graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                // if 노드 not in 이미 방문한 노드 배열
                if (!visited[temp]) {
                    // 큐에 graph[노드] (인접 노드) 추가
                    // 이미 방문한 배열에 추가
                    visited[temp] = true;
                    q.offer(temp);
                }
        //      else
            }
        }
        return sb.toString();
    }

}
