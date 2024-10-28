import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int[] weights = new int[k];
        int s = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            s += weights[i];
        }

        boolean[] isPossible = new boolean[s + 1];
        getBalance(0, 0, weights, isPossible, k);


        int answer = 0;
        for (int i = 1; i < s; i++) {
            if (!isPossible[i]) answer++;
        }

        System.out.println(answer);

    }

    private static void getBalance(int index, int weight, int[] weights, boolean[] isPossible, int k) {
        if (index == k) {
            if (weight >= 0) isPossible[weight] = true;
            return;
        }
        getBalance(index + 1, weight, weights, isPossible, k);
        getBalance(index + 1, weight + weights[index], weights, isPossible, k);
        getBalance(index + 1, weight - weights[index], weights, isPossible, k);
    }
}