import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        getSum(0, N, R, arr, 0);
        System.out.println(R == 0 ? answer - 1 : answer);
    }

    private static void getSum(int depth, int n, int r, int[] arr, int sum) {
        if (depth == n) {
            if (sum == r) {
                answer++;
            }
            return;
        }
        getSum(depth + 1, n, r, arr, sum + arr[depth]);
        getSum(depth + 1, n, r, arr, sum);
    }
}