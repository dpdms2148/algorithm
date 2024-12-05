import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 인식할 수 있는 알파벳 종류 최대 갯수
        char[] catString = br.readLine().toCharArray(); // 소문자로 이루어진 문자열
        int[] alphabet = new int[26];
        int answer = 0;
        int count = 0;

        for (int start = 0, end = 0; end < catString.length; end++) {
            // 처음 인식하는 알파벳이라면 count 증가
            if (alphabet[catString[end] - 'a']++ == 0) count++;

            // count가 N보다 크면 줄어들 때 까지 start를 이동
            while (N < count&& start < end) {
                if (--alphabet[catString[start++] - 'a'] == 0) count--;
            }
            //최댓값 저장
            answer = Math.max(answer, end - start + 1);
        }

        System.out.println(answer);
    }
}