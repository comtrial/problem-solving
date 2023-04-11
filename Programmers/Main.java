
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
class Solution {
    public int solution(String numbers) {

        /**
         *  1. 들어 온 문자열에 대해서 다 스플릿
         *  2. split 된 숫자들로 조합 만들어
         *  3. 모든 조합에 대한 소수 여부 판별
         *      소수: 자기 자신과 1 이외에 나뉘지 않는 수
         *  4. 소수인 경우 answer ++
         */

        int answer = 0;
        String[] splitNumbers = numbers.split("");

        System.out.println(splitNumbers.length);

        for (String s : splitNumbers) {
            System.out.println("shit" + s);
        }

        return answer;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("177"));
    }
}