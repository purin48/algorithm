import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int ball = sc.nextInt();
            for(int j=0; j<(b-a+1); j++) {
                arr[a+j] = ball;
            }
        }
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}