import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
//         int[] answer = {};
//         s = s.replaceAll("[\\{,\\}]", " ");
//         String[] stringArray = s.split(" ");
//         HashMap<String, Integer> hashMap = new HashMap<>();
        
//         for(int i = 0; i < stringArray.length; i++){
//             if(!stringArray[i].equals("")){
//                 if(hashMap.containsKey(stringArray[i])){
//                     hashMap.replace(stringArray[i], hashMap.get(stringArray[i])+1);
//                 }else{
//                     hashMap.put(stringArray[i], 1);
//                 }
//             }
//         }
        
//         List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
//         Collections.sort(list, (o1, o2) -> {return  o2.getValue() - o1.getValue();});
                                                                
//         answer = new int[list.size()];
//         for(int i = 0; i < list.size(); i++){
//             answer[i] = Integer.parseInt(list.get(i).getKey());
//         }
        
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        
        Set<String> set = new HashSet<>();
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}