import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {
                case "push": {
                    que.add(Integer.parseInt(cmd[1]));
                    break;
                }
                case "pop": {
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(que.poll());  // pop한 값을 출력
                    }
                    break;
                }
                case "size": {
                    System.out.println(que.size());
                    break;  // break 추가
                }
                case "empty": {
                    System.out.println(que.isEmpty() ? 1 : 0);
                    break;
                }
                case "front": {
                    System.out.println(que.isEmpty() ? -1 : que.peekFirst());
                    break;
                }
                case "back": {
                    System.out.println(que.isEmpty() ? -1 : que.peekLast());
                    break;
                }
            }
        }
    }
}