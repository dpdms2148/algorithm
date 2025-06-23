import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = triangle[i][j] + dp[i - 1][j];
                else if (j == j + i) dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                else dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        int[] answer = dp[N-1];
        Arrays.sort(answer);

        System.out.println(answer[N-1]);
    }
}
