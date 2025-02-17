import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dequeue 로 구현
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            // 조건 분기 처리
            switch (st.nextToken()) {
                case "push_front" : {
                    queue.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "push_back" : {
                    queue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop_front" : {
                    if(!queue.isEmpty()) {
                        System.out.println(queue.pollFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                }
                case "pop_back" : {
                    if(!queue.isEmpty()) {
                        System.out.println(queue.pollLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                }
                case "size" : {
                    System.out.println(queue.size());
                    break;
                }
                case "empty" : {
                    if(!queue.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                    break;
                }
                case "front" : {
                    if(!queue.isEmpty()) {
                        System.out.println(queue.peekFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                }
                case "back" : {
                    if(!queue.isEmpty()) {
                        System.out.println(queue.peekLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                }
            }
        }
    }
}