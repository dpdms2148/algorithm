import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int MAX = 200 * 10000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] storage = new int[N + 1][N + 1];
        int[][] answer = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(storage[i], MAX);
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                answer[i][j] = j;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            storage[start][end] = storage[end][start] = Math.min(storage[start][end], cost);
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if (storage[j][k] > storage[j][i] + storage[i][k]) {
                        storage[j][k] = Math.min(storage[j][i] + storage[i][k], storage[j][k]);
                        answer[j][k] = answer[j][i];
                    }
                }
            }
        }


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    System.out.print("- ");
                } else {
                    System.out.print(answer[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}