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
            if(map.containsKey(tangerine[i])){
                map.put( tangerine[i], map.get(tangerine[i]) + 1 );
            }else{
                map.put( tangerine[i], 1 );
            }
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        int sum = 0;
        for (Integer key : keySet) {
            // System.out.print("Key : " + key);
            // System.out.println(", Val : " + map.get(key));
            sum += map.get(key);
            if(sum >= k){
                answer++;
                break;
            }
            answer++;
        }
        return answer;
    }
}