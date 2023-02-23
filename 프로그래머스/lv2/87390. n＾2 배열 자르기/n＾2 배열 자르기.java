import java.util.Arrays;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        
        for(int i = 0; i < answer.length; i++){
            //현재 위치
            int x = (int)(left / n);
            int y = (int)(left % n);
            //다음 위치
            left++;
            answer[i] = Math.max(x, y) + 1;
        }
        return answer;
    }
}