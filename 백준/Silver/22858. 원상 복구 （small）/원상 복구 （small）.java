import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N];
        int[] D = new int[N];
        int[] P = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] tempS = new int[N];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                tempS[D[j] - 1] = S[j];
            }
            for (int j = 0; j < N; j++) {
                S[j] = tempS[j];
            }
        }

        for (int i = 0; i < N; i++) {
            P[i] = S[i];
        }

        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }
}