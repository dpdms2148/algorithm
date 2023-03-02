import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int n = cities.length;
        ArrayList<String> cache = new ArrayList<>();
        
        //캐시 사이즈가 0이라면 아무것도 저장할 수 없으므로 바로 종료
        if(cacheSize == 0){
            return n * 5;
        }
        for(int i = 0; i < n; i++){
            cities[i] = cities[i].toUpperCase();
        }
        
        for(int i = 0; i < n; i++) {
            //캐시에 있는 경우
            if(cache.contains(cities[i])) {
                answer += 1;
                cache.remove(cities[i]);
            }
            //캐시에 없는 경우
            else {
                answer += 5;
                //캐시가 가득찬 경우
                if(cache.size() >= cacheSize){
                    cache.remove(0);
                }
            }
            cache.add(cities[i]);
        }
        
        return answer;
    }
}