import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int[] profit = new int[N];
            for (int i = 0; i < N; i++) {
                profit[i] = Integer.parseInt(br.readLine());
            }

            int[] dp = new int[N];
            dp[0] = profit[0];

            int max = -10001;
            for(int i=1; i<N; i++){
                dp[i] = Math.max(profit[i], dp[i-1]+profit[i]);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
