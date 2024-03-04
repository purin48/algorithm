import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int buddaYear = 544;
        int year = sc.nextInt();
        System.out.println(year - buddaYear + 1);
        sc.close();
    }
}