

public class 게임_맵 {

    public static int solution(int[][] maps) {
        int answer = 0;

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
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1} ,{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
        // 11
    }
}
