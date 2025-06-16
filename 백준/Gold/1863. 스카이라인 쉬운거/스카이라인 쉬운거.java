import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                // 현재 높이 보다 큰 경우
                answer++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) {
                //현재 높이와 같은 경우
                continue;
            }
            stack.push(y);
        }
        while (!stack.isEmpty() && stack.peek() > 0) {
            answer++;
            stack.pop();
        }

        System.out.println(answer);
    }
}
