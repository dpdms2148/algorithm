import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        //최소값을 저장할 변수는 최대값으로, 최댓값을 저장할 변수는 최솟값으로 초기화
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //공백을 기준으로 자르기
        StringTokenizer st = new StringTokenizer(s);
        //다음 토근이 있으면 계속 진행
        while(st.hasMoreTokens()){
            //현재 토큰을 int형으로
            int n = Integer.parseInt(st.nextToken());
            //최대값과 최솟값을 저장
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        answer = min +" "+max;
        return answer;
    }
}