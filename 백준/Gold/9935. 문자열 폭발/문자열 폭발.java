import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String originalString = br.readLine();
        String boomString = br.readLine();

        int n = originalString.length();
        int m = boomString.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(originalString.charAt(i));

            if (stack.size() >= m) {
                boolean isSame = true;
                // 폭발 문자열 길이만큼 검사
                for (int j = 0; j < m; j++) {
                    if (stack.get(stack.size() - m + j) != boomString.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int j = 0; j < m; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }

    }
}