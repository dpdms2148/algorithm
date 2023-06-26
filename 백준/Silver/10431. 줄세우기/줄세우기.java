import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            sb.append(n + " ");

            int[] students = new int[20];
            for (int i = 0; i < 20; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;
            for (int i = 1; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (students[i] < students[j]) count++;
                }
            }


            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}