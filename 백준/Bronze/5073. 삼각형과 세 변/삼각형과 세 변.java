import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a + b == 0) {//종료 조건
                break;
            }

            if (a + b <= c || b + c <= a || c + a <= b) {//삼각형의 조건을 만족하지 않음
                System.out.println("Invalid");
            } else if (a == b && b == c) {//세 변의 길이가 모두 같은 경우
                System.out.println("Equilateral");
            } else if (a == b || b == c || c == a) {//두 변의 길이만 같은 경우
                System.out.println("Isosceles");
            } else {//세 변의 길이가 모두 다른 경우
                System.out.println("Scalene ");
            }
        }
    }
}