import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        
        int n = tangerine.length;
        for(int i = 0; i < n; i++){
            //맵에 귤 크기가 저장되어 있는 경우
            if(map.containsKey(tangerine[i])){
                map.put( tangerine[i], map.get(tangerine[i]) + 1 );
            }
            //맵에 귤 크기가 저장되어 있지 않은 경우
            else{
                map.put( tangerine[i], 1 );
            }
        }
        
        //귤이 많은 순서대로(내림차순으로) 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        //현재 담은 귤의 개수
        int sum = 0;
        for (Integer key : keySet) {
            sum += map.get(key);
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