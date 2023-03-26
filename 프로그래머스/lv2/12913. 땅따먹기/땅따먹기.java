class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        
        //dp[i][j] = (i,j) 까지 도달했을 때의 최댓값
        int[][] dp = new int[n][4];
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    // 이전에 선택했던 열은 선택할 수 없으므로 continue
                    if(j == k) continue;
                    //dp[i][j] = max(dp[i-1][0], ... dp[i-1][k]) + land[i][j]
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k]+land[i][j]);
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
    
}