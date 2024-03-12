import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hh = sc.nextInt();
        int mm = sc.nextInt();
        int time = sc.nextInt();
        int plushh = (mm + time) / 60;

        mm = (mm + time) % 60;
        if((hh + plushh) >= 24 ) {
            hh = hh+plushh-24;
        }else {
            hh = hh+plushh;
        }
        System.out.printf("%d %d", hh, mm);
    }
}
