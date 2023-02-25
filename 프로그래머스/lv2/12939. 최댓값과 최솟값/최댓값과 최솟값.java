import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        answer = min +" "+max;
        return answer;
    }
}