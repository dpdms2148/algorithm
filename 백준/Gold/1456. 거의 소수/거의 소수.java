import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] isPrime(long end) {
        boolean[] prime = new boolean[(int) Math.sqrt(end) + 1];
        for (int i = 2; i < prime.length; i++) prime[i] = true;

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) continue;
            for (int j = i * 2; j < prime.length; j += i) {
                prime[j] = false;
            }
        }
        return prime;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        boolean[] prime = isPrime(B);

        int answer = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                long almostPrime = i;
                while (almostPrime <= (double)B / i) {
                    if (almostPrime >= (double)A / i) answer++;
                    almostPrime *= i;
                }
            }
        }

        System.out.println(answer);
    }
}