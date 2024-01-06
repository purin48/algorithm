import java.util.*;

public class Main { 
    public static void main(String[] n) {
        Scanner sc = new Scanner(System.in); // sc 객체 생성
        int N = sc.nextInt();
        int count = 0;
        for (int i = 3; i <= N-6; i += 3) {
            for (int j=3; j <= N-i-3; j+=3) {
                // i 와 j가 결정이 되면 자연스럽게 k가 결정
                // 이 내부에 중첩 for 문이 돈다 -> i,j가 3의 배수이며
                // i,j,k를 합쳤을 때 N이 된다
                count ++;
            }
        }
        System.out.println(count);
    }
}