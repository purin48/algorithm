import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        int result = 0;

        for (int i=1; i<=b.length(); i++) {
            int splitB = Character.getNumericValue(b.charAt(b.length() - i));
            int partSumResult = a * splitB;
            result += partSumResult * (int)(Math.pow(10, i-1));
            System.out.println(partSumResult);
        }
        System.out.println(result);
        sc.close();
    }
}