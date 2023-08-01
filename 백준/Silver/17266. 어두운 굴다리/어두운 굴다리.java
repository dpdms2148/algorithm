import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] position = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            position[i] = Integer.parseInt(st.nextToken());
        }

        //출발 지점에서 부터 필요한 높이
        int answer = position[0];
        for (int i = 1; i < M - 1; i++) {
            //가로등 사이 거리
            int distance = position[i] - position[i - 1];
            //가로등 사이에 필요한 높이
            int height = 0;
            if (distance % 2 == 0) height = distance / 2;
            else height = distance / 2 + 1;
            
            answer = Math.max(answer, height);
        }
        //끝 지점에서 부터 필요한 높이
        answer = Math.max(answer, N - position[M - 1]);
        
        System.out.println(answer);
    }
}