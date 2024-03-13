import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalMoney = sc.nextInt();
        int calculateMoney = 0;
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int price = sc.nextInt();
            int cnt = sc.nextInt();
            calculateMoney += price * cnt;
        }
        String result = calculateMoney == totalMoney ? "Yes" : "No";
        System.out.println(result);
    }
}