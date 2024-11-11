import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] height = new int[N][2];
        for (int i = 0; i < N; i++) {
            height[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i][1] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        //성장 길이 기준으로 정렬
        Arrays.sort(height, Comparator.comparingInt((int[] o) -> o[1]));
        for (int i = 0; i < N; i++) {
            //나무 자르기
            answer += height[i][0] + height[i][1] * i;
        }

        System.out.println(answer);


    }
}