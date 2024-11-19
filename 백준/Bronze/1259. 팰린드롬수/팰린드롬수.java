import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean answer;

        while (true) {
            // 입력 받기
            int[] arr = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // 종료 조건
            if (arr[0] == 0) break;

            // 스택 생성 및 초기화
            Stack<Integer> stack = new Stack<>();
            answer = true; // 초기값 설정

            // 1. 전반부 수 넣기
            for (int i = 0; i < arr.length / 2; i++) {
                stack.push(arr[i]);
            }

            // 2. 후반부 수 확인
            for (int i = (arr.length + 1) / 2; i < arr.length; i++) {
                if (!stack.isEmpty() && arr[i] == stack.peek()) {
                    stack.pop();
                } else {
                    answer = false; // 불일치 발견
                    break; // 즉시 종료
                }
            }

            // 결과 출력
            System.out.println(answer ? "yes" : "no");
        }
    }
}
