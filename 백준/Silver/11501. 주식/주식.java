import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] stock = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }
            //뒤에서부터 탐색할 것이므로 마지막 값을 가장 큰 값으로 저장
            int max = stock[N - 1];
            long answer = 0;
            for (int i = N - 2; i >= 0; i--) {
                if (stock[i] <= max) { // 현재 최대 값 보다 작은 경우 파는 것이 이득
                    answer += max - stock[i];
                } else {// 현재 최대 값 보다 큰 경우 앞으로 이 가격으로 사는 것이 이득
                    max = stock[i];
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}