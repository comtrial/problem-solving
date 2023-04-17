
class Solution3 {

    public static boolean solution(String[] phone_book) {

        // O(N^2)
        for (String phoneNum :phone_book) {
            for (String phoneNumCom:phone_book) {
                if (phoneNumCom != phoneNum & phoneNumCom.startsWith(phoneNum)) {
                    System.out.println(phoneNumCom);
                    System.out.println(phoneNum);
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        String[] phone_book = {"123","456","789"};
        System.out.println(solution(phone_book));
    }
}
