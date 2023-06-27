import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//신호등의 개수
        int l = Integer.parseInt(st.nextToken());//도로의 길이

        int time = 0;
        int position = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());//신호등의 위치
            int r = Integer.parseInt(st.nextToken());//빨간불 지속 시간
            int g = Integer.parseInt(st.nextToken());//초록불 지속 시간

            // 신호등까지 걸린 시간
            time += d - position;
            position = d;

            int temp = time % (r + g);
            if (temp < r) time += r - temp;
        }

        System.out.println(time + (l - position));
    }
}