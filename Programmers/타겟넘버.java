


class Solution5 {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        // 1. 모든 조합 방법 (완전 탐색)
        // 1. nums 의 len 만큼 의 [+, - ..] 배열 생성
        // 2. +, - 2가지의 경우로 2^nums.len (최대 2^20)
        // 3. 비교

        // 2. DFS
        //      2.1 dfs 는 크게 1. 수행 동작 즉, dfs에서 여러번을 call 할 텐데 한 번의 call에서
        //          어떤 동작을 할 것이냐를 잘 정의 해야 한다.

        //      2.2 재귀 함수 (수행동작을 먼저 구현해 보지만, 탈출 조건이 코드 앞줄에 오게 된다.)
        //          1. 수행동작을 먼저 구현해 본다.
        //          2. 탈출 조건을 구현한다.
        //          3. 재귀함수를 자세하게 그려 본다. (with hello coding 분할정복)
        int[][] plusMinus;

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3; // 5

//        int[] nums = {4, 1, 2, 1};
//        int target = 3; // 2
        System.out.println(solution(nums, target));
    }
}
