import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] balloon = new int[N];
        for (int i = 0; i < N; i++) {
            balloon[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] arrow = new int[1000002];
        for (int i = 0; i < N; i++) {
            if(arrow[balloon[i]]>0){
                arrow[balloon[i]]--;
                arrow[balloon[i]-1]++;
            }else{
                answer++;
                arrow[balloon[i]-1]++;
            }
        }
        System.out.println(answer);

    }

}