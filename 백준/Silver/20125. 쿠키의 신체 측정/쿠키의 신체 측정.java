import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 5 ≤ n ≤ 1000
        int n = Integer.parseInt(br.readLine());
        boolean[][] cookie = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            String subcookie = br.readLine();
            for(int j = 0; j < n; j++){
                if(subcookie.charAt(j) == '*'){
                    cookie[i][j] = true;
                }else{
                    cookie[i][j] = false;
                }
            }
        }
        
        // 심장 위치 찾기
        int x = 0;
        int y = 0;
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(cookie[i][j]&&cookie[i-1][j]&&cookie[i+1][j]&&cookie[i][j-1]&&cookie[i][j+1]){
                    x = i;
                    y = j;
                    sb.append(x+1).append(" ").append(y+1).append("\n");
                    break;
                }
            }
        }
        
        // 신체 길이 구하기
        int len = 0;
        // 왼쪽 팔
        for(int i = y - 1; i >= 0; i--){
            if(cookie[x][i]) len++;
            else break;
        }
        sb.append(len+" ");
        // 오른쪽 팔
        len = 0;
        for(int i = y + 1; i < n; i++){
            if(cookie[x][i]) len++;
            else break;
        }
        sb.append(len+" ");
        // 허리
        len = 0;
        for(int i = x + 1; i < n; i++){
            if(cookie[i][y]) len++;
            else break;
        }
        sb.append(len+" ");
        x += len + 1;
        len = 0;
        // 왼쪽 다리
        for(int i = x; i < n; i++){
            if(cookie[i][y-1]) len++;
            else break;
        }
        sb.append(len+" ");
        // 오른쪽 다리
        len = 0;
        for(int i = x; i < n; i++){
            if(cookie[i][y+1]) len++;
            else break;
        }
        sb.append(len+" ");
        
        System.out.println(sb);
    }
}