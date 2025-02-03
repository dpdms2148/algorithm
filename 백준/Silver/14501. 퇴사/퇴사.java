import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[][] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        findMax(0, 0);
        System.out.println(answer);
    }

    static void findMax(int day, int sum) {
        if (day > N - 1) {
            answer = Math.max(answer, sum);
            return;
        }
        if (day + schedule[day][0] <= N) findMax(day + schedule[day][0], sum + schedule[day][1]);
        findMax(day + 1, sum);
    }
}