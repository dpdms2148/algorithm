import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = map[0][0];
        //dp[0][0~m]을 구하는 과정
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        //dp[1~n][0~m]을 구하는 과정
        for (int i = 1; i < n; i++) {
            int[] left = new int[m];
            int[] right = new int[m];
            //왼쪽 부터 탐색(오른쪽 방향으로 탐색)
            left[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < m; j++) {
                left[j] = Math.max(dp[i - 1][j], left[j - 1]) + map[i][j];
            }
            //오른쪽 부터 탐색(왼쪽 방향으로 탐색)
            right[m - 1] = dp[i - 1][m - 1] + map[i][m - 1];
            for (int j = m - 2; j > -1; j--) {
                right[j] = Math.max(dp[i - 1][j], right[j + 1]) + map[i][j];
            }
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}