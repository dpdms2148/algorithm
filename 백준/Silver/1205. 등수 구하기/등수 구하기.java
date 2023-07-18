import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {// N이 0이면 둘째줄이 주어지지 않음
            System.out.print(1);
            return;
        }

        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        // 태수의 점수가 가장 작은 점수보다 같거나 작은 경우
        if (N == P && score[N - 1] >= T) {
            System.out.print(-1);
            return;
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            //점수가 태수보다 큰 경우
            if (score[i] > T) rank++;
            //점수가 태수보다 작은 경우
            else break;

        }

        System.out.println(rank);
    }
}