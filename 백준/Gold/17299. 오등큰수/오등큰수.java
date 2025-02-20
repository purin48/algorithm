import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 1. 등장 횟수 배열 생성
        int[] freq = new int[1000001]; // 등장 횟수 저장 (입력값이 1 ≤ A[i] ≤ 1,000,000)
        for (int num : numArr) {
            freq[num]++;
        }

        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        // 2. 스택을 활용해서 등장 횟수를 비교하며 오등큰수 채우기
        for (int i = 0; i < N; i++) {
            // 3. 현재 숫자의 등장 횟수 > 스택의 top 등장 횟수 -> 스택에서 pop하면서 answer 업데이트!
            // 현재 숫자의 등장 횟수가 스택의 top보다 크면 오등큰수 결정!
            while (!stack.isEmpty() && freq[numArr[stack.peek()]] < freq[numArr[i]]) {
                answer[stack.pop()] = numArr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}