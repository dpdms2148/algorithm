import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 임스와 같이 플레이하기를 신청한 횟수
        String game = sc.next(); // 플레이할 게임의 종류
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i< n; i++){
            String name = sc.next();
            set.add(name);
        }
        // Y - 2, F - 3, O - 4
        if(game.equals("Y")){
            System.out.println(set.size());
        }else if(game.equals("F")){
            System.out.println(set.size()/2);
        }else if(game.equals("O")){
            System.out.println(set.size()/3);
        }

    }
}