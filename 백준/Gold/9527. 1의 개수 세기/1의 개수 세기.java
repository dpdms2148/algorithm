import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        //dp[n] = dp[n-1] × 2 + 2ⁿ을 이용하여 누적합 저장
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }

        System.out.println(getCount(B) - getCount(A - 1));
    }

    //1~N 정수에 대한 1의 개수 구하는 함수
    private static long getCount(long n) {
        long count = n & 1;
        //N보다 작은 2ⁿ의 n의 최대값
        int size = (int) (Math.log(n) / Math.log(2));
        for (int i = size; i > 0; i--) {
            //DP[i-1] : 000 ~ 111 개수
            //N - (1L << i) : 지정된 1이 반복 사용될 개수 
            // + 1 : 1000... 
            if((n & (1L << i))!=0L){
                count += dp[i - 1] + (n - (1L << i)) + 1;
                n -= (1L << i);
            }
            
        }

        return count;
    }
}
//참고 : https://tussle.tistory.com/1022