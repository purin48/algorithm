import java.util.Scanner;

public class Main {
    // 팩토리얼을 구하는 함수
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        // 이항 계수 계산
        int result = factorial(n) / (factorial(k) * factorial(n - k));
        System.out.println(result);
    }
}
