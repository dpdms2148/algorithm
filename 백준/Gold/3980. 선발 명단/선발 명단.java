import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] player;
    static boolean[] isPlaced;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            player = new int[11][11];
            isPlaced = new boolean[11];
            answer = 0;

            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    player[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            placing(0, 0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void placing(int index, int sum) {
        if (index == 11) {
            answer = Math.max(sum, answer);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!isPlaced[i] && player[index][i] != 0) {
                isPlaced[i] = true;
                placing(index + 1, sum + player[index][i]);
                isPlaced[i] = false;
            }
        }
    }

}