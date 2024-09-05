import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 정수 K 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 2. Stack 생성
        Stack<Integer> totalStack = new Stack<>();

        // 3. 입력수만큼 반복
        for(int i=0; i<K; i++) {
            int curNum = Integer.parseInt(br.readLine());

            // 3-1. 정수가 0인 경우 최근 수 지우기
            if(!totalStack.isEmpty() && curNum == 0) {
                totalStack.pop();
            }
            else {
                // 3-2. 아닌 경우 현재 수 넣어주기
                totalStack.push(curNum);
            }
        }

        // 4. 전체 합 구하기
        System.out.println(totalStack.stream().mapToInt(Integer::intValue).sum());
    }
}