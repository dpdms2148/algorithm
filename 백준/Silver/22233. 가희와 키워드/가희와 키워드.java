import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
        HashSet<String> keyword = new HashSet<>();
        for(int i = 0; i < N; i++){
            keyword.add(br.readLine());
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                if(keyword.contains(word)){
                    keyword.remove(word);
                }
            }
            System.out.println(keyword.size());
        }
	}
}