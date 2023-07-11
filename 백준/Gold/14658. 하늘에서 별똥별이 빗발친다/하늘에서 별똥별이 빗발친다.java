import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<int[]> stars = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            stars.add(new int[]{x, y});
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int count = 0;
                //트램펄린을 설치할 때 기준이 되는 두개의 별
                int x = stars.get(i)[0];
                int y = stars.get(j)[1];
                for (int t = 0; t < K; t++) {
                    //별의 개수 세기
                    int nx = stars.get(t)[0];
                    int ny = stars.get(t)[1];
                    if (x <= nx && nx <= x + L && y <= ny && ny <= y + L) count++;
                }
                answer = Math.max(answer, count);
            }
        }
        System.out.print(K - answer);
    }
}