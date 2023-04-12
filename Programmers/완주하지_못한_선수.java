import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 각 배열 간의 차이에 대한 접근에 대한 문제
 */

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

//        //=== loop ====//
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        // 예외에 따라서
//        int i = 0;
//        for (; i < completion.length; i++)
//            if (!participant[i].equals(completion[i])) {
//                System.out.println(participant[i]);
//                System.out.println(completion[i]);
//                break;
//            }
//        return participant[i];

        //=== hash === //
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);

        for (String player : completion)
            map.put(player, map.get(player) - 1);

        System.out.println(map.keySet());
        for (String key : map.keySet()) {
            if (map.get(key).equals(1)) {
                answer = key;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"mislav", "stanko", "mislav", "ana"};
        String[] comp = {"stanko", "ana", "mislav"};
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(part, comp));
    }
}
