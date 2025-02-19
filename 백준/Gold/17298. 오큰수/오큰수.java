import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 오큰수 = 현재의 수보다 오른쪽에 있는 수 중에서 가장 가까운 큰 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] answer = new int[N]; // 정답 배열
        Arrays.fill(answer, -1); // 기본값 -1로 초기화
        Stack<Integer> stack = new Stack<>(); // 스택에는 인덱스를 저장!

        for (int i = 0; i < N; i++) {
            // 현재 숫자가 스택의 top보다 크다면 -> 오큰수 찾음!
            while (!stack.isEmpty() && numArr[stack.peek()] < numArr[i]) {
                answer[stack.pop()] = numArr[i]; // 스택에서 빼면서 정답 배열 업데이트
            }
            stack.push(i); // 현재 인덱스를 스택에 넣음
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}