import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[100001][3];
        dp[1][0] = dp[2][0] = dp[2][1] = dp[3][0] = dp[3][1] = dp[3][2] = 1;

        for (int i = 4; i < 100001; i++) {
            dp[i][0] = dp[i-1][0];                          // ...+1로 끝나는 경우
            dp[i][1] = dp[i-2][0] + dp[i-2][1];             // ...+2로 끝나는 경우
            dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];// ...+3로 끝나는 경우
        }

        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]+dp[n][1]+dp[n][2]).append("\n");
        }
        System.out.print(sb);
    }
}