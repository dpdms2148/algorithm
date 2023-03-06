import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        int n = phone_book.length;
        
        for(int i = 0; i < n;  i++){
            map.put(phone_book[i], i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
            
        // Arrays.sort(phone_book);
        // for(int i = 0; i < n - 1; i++){
            
            
            //방법2. startWith()사용
            // if(phone_book[i+1].startsWith(phone_book[i])){
            //     return false;
            // }
            
            // 방법1. 그냥 반복문 사용
            // int m = phone_book[i].length();
            // for(int j = 0; j < m; j++){
            //     if(phone_book[i+1].charAt(j) != phone_book[i].charAt(j)){
            //         answer = true;
            //         break;
            //     }else{
            //         answer = false;
            //     }
            // }
            // if(!answer){
            //     return answer;
            // }
            
        // }
        return answer;
    }
}