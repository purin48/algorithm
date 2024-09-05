import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArr = br.readLine().toCharArray();

        // 1. stack 생성
        Stack<Character> stack = new Stack<>();

        // 2. 조각 수 카운트 할 answer 생성
        int answer = 0;

        // 3. 조건 분기 처리하기
        for (int i=0; i<inputArr.length; i++) {
            // 3-1. "(" 인 경우(아직 괄호 안끝남) - 스택에 push
            if(inputArr[i] == '('){
                stack.push(inputArr[i]);
            }
            else {
                // 3-2. 이전 값이 "("인 ")" - 스택 pop & 스택 사이즈만큼 count에 더하기
                if(inputArr[i-1] == '(') {
                    stack.pop();
                    answer += stack.size();
                }
                // 3-3. 이전 값이 ")"인 ")" - 스택 pop & count 에 +1
                if(inputArr[i-1] == ')'){
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}