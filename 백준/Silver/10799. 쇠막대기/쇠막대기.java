import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '(') {//열린 괄호인 경우
                count++;
            } else {//닫힌 괄호인 경우
                count--;
                if (input.charAt(i - 1) == '(') {//레이저인 경우
                    answer += count;
                } else {//레이저가 아닌 경우
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
