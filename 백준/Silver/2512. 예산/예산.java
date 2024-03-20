import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.parseInt(br.readLine()); // 지방의 수 3 <= N <= 10,000

        int left = 0;
        int right = 0;
        int[] budget = new int[N];               // 각 지방의 예산 3 <= budget <=100,000
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, budget[i]);
        }

        int M = Integer.parseInt(br.readLine()); // 총 예산  N <= M <= 1,000,000,000

        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (budget[i] > mid) total += mid;      //상한가 보다 크면 상한가만큼 더한다
                else                 total += budget[i];//상한가 보다 같거나 작으면 예산만큼 더한다
            }
            if (total <= M) left = mid + 1; // 총 예산 보다 작으면 왼쪽 인덱스를 옮긴다
            else            right = mid - 1;// 총 예산 보다 크면 오른쪽 인덱스를 옮긴다
        }

        System.out.println(right);
    }
}