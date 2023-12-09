import java.awt.image.renderable.RenderableImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solution = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int leftIndex = 0;
        int rightIndex = N - 1;
        int minSum = Integer.MAX_VALUE;

        int answerLeft = solution[leftIndex];
        int answerRight = solution[rightIndex];
        while (leftIndex < rightIndex) {
            //현재 용액 혼합
            int curSum = solution[leftIndex] + solution[rightIndex];
            if (Math.abs(curSum) <= minSum) {
                minSum = Math.abs(curSum);
                answerLeft = solution[leftIndex];
                answerRight = solution[rightIndex];
            }

            if(curSum < 0) leftIndex++;
            else rightIndex--;
        }

        System.out.println(answerLeft + " " + answerRight);
    }
}