class Solution {
    public long solution(int n) {
        long answer = 0;
        
        // 경우의 수를 저장하는 배열 초기화
        long[] dp = new long[n];
        dp[0] = 1;
        if(n == 1){
            return 1;
        }
        dp[1] = 2;
        // i칸에 도착하는 경우의 수
        // = (i-1)칸에서 1칸 뛰어서 오기 + (i-2)칸에서 2칸 뛰어오기
        for(int i = 2; i < n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        answer =  dp[n - 1];
        return answer;
    }
}