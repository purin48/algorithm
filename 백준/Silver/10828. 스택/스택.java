import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();

            // push X: 정수 X를 스택에 넣는 연산이다.
            if(keyword.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            if(keyword.equals("pop")) {
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                } else {
                    System.out.println(-1);
                }
            }

            //size: 스택에 들어있는 정수의 개수를 출력한다.
            if(keyword.equals("size")) {
                System.out.println(stack.size());
            }

            //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
            if(keyword.equals("empty")) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }

            //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            if(keyword.equals("top")) {
                if(!stack.isEmpty()){
                    System.out.println(stack.peek());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}