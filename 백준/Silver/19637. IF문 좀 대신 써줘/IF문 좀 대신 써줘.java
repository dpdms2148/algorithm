import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] powerName = new String[N];
        int[] powerLevel = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            powerName[i] = st.nextToken();
            powerLevel[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                if (power > powerLevel[(start + end) / 2]) {
                    start = (start + end) / 2 + 1;
                }else{
                    end = (start + end) / 2 - 1;
                }
            }

            sb.append(powerName[start]).append("\n");
        }

        System.out.print(sb.toString());
    }
}