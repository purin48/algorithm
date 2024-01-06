// 백준 제출 전 package 주석처리
import java.util.*;

public class Main { 
    public static void main(String[] n) {
        Scanner sc = new Scanner(System.in);
        // boolean값으로 채워진 42길이의 배열 생성
        boolean[] visited = new boolean[42];

        int count = 0;
        // 숫자 10번 입력 받기
        for (int i=0; i<10; i++) {
            int num = sc.nextInt();

            // 42로 나눈 나머지를 구하기
            int remain = num % 42;

            if(visited[remain]) {
                // 이미 기록된 나머지이기 때문에 뒤에 작업하지 X
                continue; 
            }
            if(!visited[remain]) {
                // 중복이 없는 수는 true로 변경
                visited[remain] = true;
                count++;
            }
        }
        System.out.println(count);
    }
}