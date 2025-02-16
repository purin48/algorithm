import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. 1 ~ N 번까지 큐에 넣기
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 2. queue 에 K번째 수 반복해서 제거(queue에 남은 수가 있을때까지)
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (queue.size() > 1) {

            // 2-1. queue 에 K번째 이전 숫자들은 poll하고 바로 add 시키기
            for (int j=0; j<K-1; j++) {
                queue.add(queue.poll());
            }

            // 2-2. queue에 K번째 숫자 poll시키고 출력
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll());
        sb.append(">");
        System.out.println(sb);
    }
}