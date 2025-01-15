import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // VPS 조건 : 올바른 괄호 문자열 "()"가 쌍이 맞을 때 O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            String[] arr = str.split("");
            Stack<Integer> stack = new Stack<>();
            boolean isValid = true;

            // Stack 사용
            // 1. "(" : 스택에 추가
            // 2. ")" : 스택에서 빼기
            // 3. 올바르지 X : 스택이 비어있는데 ")"를 만날때 || 반복 끝에도 스택에 값이 O
            for (int j=0; j<arr.length; j++) {
                if(arr[j].equals("(")) {
                    stack.push(1);
                } else if (arr[j].equals(")")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isValid = false; // 스택이 비어 있는데 ")"를 만난 경우
                        break;
                    }
                }
            }

            // 반복 끝에도 스택에 값이 O
            if(!isValid || !stack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}