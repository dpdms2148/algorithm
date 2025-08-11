import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wantMap = new HashMap<>();

        // 원하는 제품 및 수량 HashMap에 저장
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i <= discount.length - 10; i++){
            HashMap<String, Integer> tempMap = new HashMap<>(wantMap);
            boolean possible = true;
            
            // 10일 동안의 할인 제품 확인
            for (int j = i; j < i + 10; j++) {
                if (tempMap.containsKey(discount[j])) {
                    tempMap.put(discount[j], tempMap.get(discount[j]) - 1);
                }
            }
            
            // 구매 가능 여부 확인
            for (int num : tempMap.values()) {
                if (num > 0) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                answer++;
            }
        }
        return answer;
    }
}