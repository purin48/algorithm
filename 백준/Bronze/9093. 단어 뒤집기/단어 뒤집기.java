import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                Stack<Character> stack = new Stack<>();
                char[] arr = st.nextToken().toCharArray();

                // 각각의 단어 개수만큼 반복해서 stack에 쌓기
                for(int j=0; j<arr.length; j++) {
                    stack.push(arr[j]);
                }
                // 뒤집기로 출력
                for(int k=0; k<arr.length; k++) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}