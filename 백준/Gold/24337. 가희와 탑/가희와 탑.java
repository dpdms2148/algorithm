import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 건물의 개수
        int A = Integer.parseInt(st.nextToken());// 가희가 보는 건물의 개수
		int B = Integer.parseInt(st.nextToken());// 다희가 보는 건물의 개수
        
        ArrayList<Integer> building = new ArrayList<>();
        for(int i = 1; i < A; i++){
            building.add(i);
        }
        building.add(Math.max(A, B));
        for(int i = B - 1; i > 0; i--){
            building.add(i);
        }
        
        if(building.size() > N){
            System.out.println(-1);
            return;
        }
        
        int first = building.remove(0);
        int size = building.size();
        for(int i = 0; i < N - size - 1; i++){
            building.add(0, 1);
        }
        building.add(0, first);
        for(int i = 0; i < N; i++){
            System.out.print(building.get(i)+" ");
        }
	}
}