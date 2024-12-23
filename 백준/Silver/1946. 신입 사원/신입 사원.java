import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicant = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                applicant[i][0] = Integer.parseInt(st.nextToken());//서류점수
                applicant[i][1] = Integer.parseInt(st.nextToken());//면접점수
            }
            Arrays.sort(applicant, Comparator.comparingInt((int[] o) -> o[0]));

            int answer = 1;// 서류점수 1등 통과
            int point = applicant[0][1]; //서류점수 1등의 면접점수
            for (int i = 1; i < N; i++) {
                if(applicant[i][1]<point){
                    answer++;
                    point = applicant[i][1];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}