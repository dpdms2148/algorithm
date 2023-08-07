import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N - 1];
        long[] price = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        int answer = 0;
        long minPrice = Long.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            answer += minPrice * distance[i];
        }

        System.out.print(answer);
    }
}