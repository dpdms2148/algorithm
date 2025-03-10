import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] order;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());// 주문의 수
        M = Integer.parseInt(st.nextToken());// 남은 치즈버거 갯수
        K = Integer.parseInt(st.nextToken());// 남은 감자튀김 갯수

        order = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][M + 1][K + 1];
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                for (int k = 0; k <= K; k++) {
                    dp[n][m][k] = -1;
                }
            }
        }
        int answer = processingOrder(0, M, K);
        System.out.println(answer);

    }

    private static int processingOrder(int index, int x, int y) {
        if (index == N) return 0;
        if (dp[index][x][y] >= 0) return dp[index][x][y];

        if (order[index + 1][0] <= x && order[index + 1][1] <= y) {
            dp[index][x][y] = processingOrder(index + 1, x - order[index + 1][0], y - order[index + 1][1]) + 1;
        }
        dp[index][x][y] = Math.max(dp[index][x][y], processingOrder(index + 1, x, y));
        return dp[index][x][y];
    }
}
