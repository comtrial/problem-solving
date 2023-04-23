package Programmers;

import java.util.HashMap;
import java.util.Iterator;

class Solution4 {

    public static int solution(String[][] clothes) {
        // - map 의 getOrDefault 사용
        // - iterator

        // 1. 카테고리 별로 갯수를 세는 작업은 해쉬 테이블의 가장 기본적인 활용이다.
        HashMap<String, Integer> map = new HashMap<>();

        // 2. 갯수에 대해 하나도 입지 않은 경우 까지 포함해서 사용해야 함
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1); // map.getOrDefault
        }

        int answer = 1;
        // 3. 총 갯수에서 어떠한 카테고리의 옷도 입지 않은 경우를 제외해서 return
        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext())
//            System.out.println(it.next());
            answer *= it.next().intValue() + 1;

        return answer - 1;
    }
    public static void main(String[] args) {
        String[][] clothes =  {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
