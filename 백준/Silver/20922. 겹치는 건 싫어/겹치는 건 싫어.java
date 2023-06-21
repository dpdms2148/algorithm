import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] isUsed = new int[100001];
        int start = 0;
        int end = 0;
        int answer = 0;
        while (end < n) {
            if (isUsed[arr[end]] != k) {
                isUsed[arr[end++]]++;
            } else {
                isUsed[arr[start++]]--;
            }
            answer = answer > end - start ? answer : end - start;
        }

        System.out.println(answer);
    }
}