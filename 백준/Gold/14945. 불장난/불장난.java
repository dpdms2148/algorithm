import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] room = new int[N + 1][N + 1];

        // n이 2인 경우
        room[2][1] = 2;

        // n이 3 이상인 경우
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < N; j++) {
                room[i][j] = 2 * room[i - 1][j] + room[i - 1][j - 1] + room[i - 1][j + 1];
                room[i][j] %= 10007;
            }
        }

        int answer = 0;
        for (int i = 1; i < N; i++) {
            answer += room[N][i];
            answer %= 10007;
        }
        System.out.print(answer);
        
        ///https://howudong.tistory.com/214
    }
}