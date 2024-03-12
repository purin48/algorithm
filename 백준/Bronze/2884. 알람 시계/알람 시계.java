import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hh = sc.nextInt();
        int mm = sc.nextInt();

        if(mm < 45) {
            mm = mm+60-45;
            if(hh-1 < 0) {
                hh = hh+24-1;
            }else {
                hh -= 1;
            }
        }else {
            mm = mm-45;
        }
        System.out.printf("%d %d", hh, mm);
    }
}
