import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] map = new int[M];
        for (int i = 0; i < M; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int rain = 0;
        for (int i = 1; i < M - 1; i++) {
            //현재 위치를 기준으로 왼쪽, 오른쪽 최대 높이 찾기
            int left = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(map[j], left);
            }
            int right = 0;
            for (int j = i + 1; j < M; j++) {
                right = Math.max(map[j], right);
            }
            // 현재 위치가 왼쪽, 오른쪽 보다 낮을 때 빗물양 계산하기
            if (map[i] < left && map[i] < right) {
                rain += Math.min(left, right) - map[i];
            }
        }

        System.out.println(rain);
    }
}