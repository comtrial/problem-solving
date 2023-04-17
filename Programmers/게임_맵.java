import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵 {

    public static class Point {
        int x;
        int y;
        int distance;


        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static int solution(int[][] maps) {
        int answer = -1;

        // 0. point 의 움직임을 표현
        int[][] moves = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        // 1. queue, visit 생성
        boolean[][] visit = new boolean[maps[0].length][maps.length];
        Queue<Point> q = new LinkedList<Point>();

        // 1.1 주어진 맵 visit 처리
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] != 1) visit[i][j] = true;
            }
        }

        // 2. queue 에 첫번째 node 삽입
        q.offer(new Point(0, 0, 1));

        // 3. while queue
        while (!q.isEmpty()) {
        //      해당 노드로 부터 이동할 수 있는 node queue 에 삽입
            Point point = q.poll();
            System.out.println("첫바퀴");

            for (int[] move : moves) {
                int nextX = point.x + move[0], nextY = point.y + move[1];

                if (nextX < 0 | nextX >= maps.length | nextY < 0 | nextY >= maps[0].length) continue;
                if (visit[nextX][nextY]) continue;

                if (nextX == maps.length - 1 & nextY == maps[0].length - 1) return point.distance + 1;

                visit[point.x][point.y] = true;
                q.offer(new Point(nextX, nextY, point.distance + 1));
            }

        //      -> visit 이 false 인 값
        //      -> 좌표계를 넘어서지 않는 값

        //      마지막 좌표계에 도달했는지 확인 후 min 값인지 확인
        //      or 난 도착하자마자 내보내도 된다고 생각해

        }
        return answer;
    }

    public void bfs() {
        // 1. nodeIndex {(0,0), {{1,0}, {0,1}}} ... 로 매핑 시킨 테이블 형성
        //      -> (0,0) = 0, (0,1) = 1 ... 으로 매핑 시킨 배열로 가야하는 것 같기도 하고..?
        // 2. queue 생성 -> 좌표값 기준이 아닌 map 에서의 조희를 위한 큐
        //              -> [(0,1), (2,0) ...]

        // 3. queue 에 startIndex 삽입
        // while que notEmpty:
        //      nodeIndex = queue.poll() 대상 노드 추출 (좌표 아님)
        //
        //      for
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1} ,
                        {1,1,1,0,1},
                        {0,0,0,0,1}};
        int answer = solution(maps);
        System.out.println("==");
        System.out.println(answer);
//        System.out.println(solution(maps));
        // 11
    }
}
