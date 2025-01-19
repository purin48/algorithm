import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int current = 1; // 현재 스택에 푸시해야 할 숫자
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            // 스택에 필요한 숫자를 푸시
            while (current <= target) {
                stack.push(current++);
                result.append("+\n");
            }

            // 스택의 최상단 값이 목표 값과 같다면 팝
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                result.append("-\n");
            } else {
                isPossible = false; // 불가능한 경우
                break;
            }
        }

        if (isPossible) {
            System.out.print(result.toString());
        } else {
            System.out.println("NO");
        }
    }
}