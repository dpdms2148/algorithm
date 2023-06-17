import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        //내림차순으로 정렬을 위해 primitive Type을 Wrapper클래스로 박싱
        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp,Collections.reverseOrder());
        
        int count = 0;
        int p = Integer.MAX_VALUE;
        for(int i = 0; i < tmp.length; i++){
            p = p > tmp[i] ? tmp[i] : p;
            count++;
            if(count >= m){// 박스에 가득차면 이익에 추가하기
                answer += p * m;
                p = Integer.MAX_VALUE;
                count = 0;
            }
        }
        return answer;
    }
}