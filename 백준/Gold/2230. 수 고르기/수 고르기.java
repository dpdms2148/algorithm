import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int leftIndex = 0;
        int rightIndex = 0;
        int answer = 2000000001;
        while (rightIndex<N) {
            int currentDiv = arr[rightIndex]-arr[leftIndex];
            
            if(currentDiv<M){
                rightIndex++;
                continue;
            }
            if(currentDiv==M){
                answer = M;
                break;
            }
            answer = Math.min(answer, currentDiv);
            leftIndex++;
        }

        System.out.println(answer);
        
    }
}
