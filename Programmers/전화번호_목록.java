import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution3 {

    public static boolean solution(String[] phone_book) {

        // 1. O(N^2)
//        for (String phoneNum :phone_book) {
//            for (String phoneNumCom:phone_book) {
//                if (phoneNumCom != phoneNum & phoneNumCom.startsWith(phoneNum)) {
//                    System.out.println(phoneNumCom);
//                    System.out.println(phoneNum);
//                    return false;
//                }
//            }
//        }
//        return true;


        // 2. sorting
//        Arrays.sort(phone_book);
//        for (int i = 0; i < phone_book.length - 1; i++) {
//            if (phone_book[i+1].startsWith(phone_book[i])) return false;
//        }
//        return true;

        // 3. hash
        // - 기본적으로 hash 에서 값을 찾아오는 시간은 O(1) 이라고 생각
        // 1. 모든 전화번호를 hash table 로 구현 - 찾는 시간이 무지하게 빠른 dict 를 만든다고 생각하면 된다.
        //      2.0. 각 전화번호의 길이는 1 이상 20 이하로 고정된 값이기에
        // 2.1 각 전화번호를 잘라가며 dict 에서 확인하면 된다.

        HashMap<String, Integer> phoneDict = new HashMap<>();
        for (String phoneNum : phone_book) phoneDict.put(phoneNum, 1);

        for (String phoneNum : phone_book) {
            for (int i = 1; i < phoneNum.length(); i++) {
                System.out.println(phoneNum.substring(0, i));
                if (phoneDict.containsKey(phoneNum.substring(0, i))) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String[] phone_book = {"123","456","789", "12312"}; //false
        System.out.println(solution(phone_book));
    }
}
