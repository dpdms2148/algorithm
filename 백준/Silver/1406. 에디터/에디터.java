import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            leftStack.add(input.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String orderLine = br.readLine();

            char order = orderLine.charAt(0);
            if (order == 'L') {// 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
            } else if (order == 'D') {// 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
            } else if (order == 'B') {// 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                if(!leftStack.isEmpty()) leftStack.pop();
            } else if (order == 'P') {// $라는 문자를 커서 왼쪽에 추가함
                leftStack.push(orderLine.charAt(2));
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            bw.write(rightStack.pop());
        }
        
        br.close();
        bw.close();
    }
}