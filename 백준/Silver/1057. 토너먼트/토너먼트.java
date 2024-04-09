import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 김지민 & 임한수가 만나는 라운드
        int N = sc.nextInt();
        int kim = sc.nextInt();
        int im = sc.nextInt();
        int r = 0;

        // 같은 라운드 = 부모노드가 동일
        while(kim != im) {
            kim = kim / 2 + kim % 2;
            im = im / 2 + im % 2;
            r++;
        }
        System.out.println(r);
    }
}