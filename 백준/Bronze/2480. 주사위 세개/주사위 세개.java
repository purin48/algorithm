import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = 0;
        int selectedNum = 0;

        if(a == b && b == c) {
            result = 10000+a*1000;
        } else if(a == b || b == c || a == c) {
            selectedNum = a == b ? a : b == c ? b : a;
            result = 1000+selectedNum*100;
        } else {
            if(a>b && a>c) selectedNum = a;
            else if (b>a && b>c) selectedNum = b;
            else selectedNum = c;

            result = selectedNum * 100;
        }
        System.out.println(result);
    }
}