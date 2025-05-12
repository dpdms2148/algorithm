import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[][] answer = new long[1001][1001];
        answer[1][1] = 1;
        answer[2][1] = 1;
        answer[2][2] = 1;
        answer[3][1] = 1;
        answer[3][2] = 2;
        answer[3][3] = 1;

        for (int i = 4; i < 1001; i++) {
            for (int j = 2; j < i; j++) {
                answer[i][j] = (answer[i - 3][j - 1] + answer[i - 2][j - 1] + answer[i - 1][j - 1]) % 1000000009;
            }
            answer[i][i] = 1;
        }

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(answer[n][m]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
