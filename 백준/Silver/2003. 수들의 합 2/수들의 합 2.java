
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int sum = nums[leftIndex];
        while (true) {
            if (rightIndex >= N) break;

            if (sum == M) {
                answer++;
                sum += nums[++rightIndex];
            } else if (sum < M) {
                sum += nums[++rightIndex];
            } else if (sum > M) {
                sum -= nums[leftIndex++];
            }
        }
        System.out.println(answer);
    }
}
