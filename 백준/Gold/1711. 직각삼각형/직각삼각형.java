import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 점의 개수
        long[][] point = new long[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Long.parseLong(st.nextToken()); // x 좌표
            point[i][1] = Long.parseLong(st.nextToken()); // y 좌표
        }

        long answer = 0;
        for (int a = 0; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                for (int c = b + 1; c < N; c++) {
                    // 세 점 고르기
                    long ax = point[a][0];
                    long ay = point[a][1];
                    long bx = point[b][0];
                    long by = point[b][1];
                    long cx = point[c][0];
                    long cy = point[c][1];

                    // 두 점 사이의 거리
                    long ab = (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
                    long bc = (bx - cx) * (bx - cx) + (by - cy) * (by - cy);
                    long ca = (cx - ax) * (cx - ax) + (cy - ay) * (cy - ay);
                    
                    // 피타고라스의 정리
                    if ((ab + bc == ca) || (bc + ca == ab) || (ca + ab == bc)) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}