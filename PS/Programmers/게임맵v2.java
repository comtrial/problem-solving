package Programmers;

public class 게임맵v2 {
    public static class Point {
        int col;
        int row;

        public Point(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }
    static Point[][] graph;

    public static int solution(int[][] maps) {
        int answer = -1;
        graph = new Point[maps.length * maps[0].length][4];
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 1. 주어진 2차원 그래프를 연결된 그래프 {{1,2}, {3,4} ..} 로 만든다.
        //    - 연결 여부를 어떻게 파악할 것이냐
        int i = 0;
        for (int col = 0; col < maps.length; col++) {
            for (int row = 0; row < maps[0].length; row++) {
                // 해당 노드에서 움직여서 1 인 (col, row) Point 를 가지고 있는 graph 를 만드는 것이 목표ㅓ
                for (int j=0; j< moves.length;j++){
                    int[] move = moves[j];
                    int newCol = col + move[0], newRow = row + move[1];

                    if (maps[col][row] == 0) continue;
                    if (newCol < 0 | newRow <0 | newCol >= maps.length | newRow >=maps[0].length ) continue;
                    if (maps[newCol][newRow] == 1){
                        graph[i][j] = new Point(newCol, newRow);
                    }
                }
                i++;
            }
        }

//        for (Point[] ps : graph) {
//            System.out.println("-----");
//            for (Point p : ps) {
//                if (p== null) continue;
//                System.out.print(p.col);
//                System.out.print(p.row+"  ");
//            }
//        }
        // 2. DFS 를 통해 (n,m) 노드에 닿았다면 최솟 값을 갱신해 주면서 노드를 탐색한다.
        dfs(0);
        return answer;
    }

    private static void dfs(int nodeIndex) {
        // 종료조건
        // if 현재노드 index == len

        // 기본
        for (Point candPoint: graph[nodeIndex]) { // Point[]
            if (candPoint ==null) continue;
            dfs();
        }
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1} ,
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        int answer = solution(maps);
        System.out.println("==");
        System.out.println(answer);
//        System.out.println(solution(maps));
        // 11
    }
}
