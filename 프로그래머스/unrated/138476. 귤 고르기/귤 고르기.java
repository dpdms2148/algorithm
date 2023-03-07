import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for(int i = 0; i < tangerine.length; i++){
            int count = map.getOrDefault(tangerine[i], 0);
            map.put(tangerine[i], count+1);
        }
        
        //귤이 많은 순서대로(내림차순으로) 정렬
        List<Integer> valueList = new ArrayList(map.values());
        Collections.sort(valueList,Collections.reverseOrder());
        
        //현재 담은 귤의 개수
        int sum = 0;
        for (Integer val : valueList) {
            sum += val;
            //귤 개수가 k를 넘은 경우
            if(sum >= k){
                answer++;
                break;
            }
            answer++;
        }
        return answer;
    }
}