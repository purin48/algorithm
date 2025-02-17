import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();  // 입력 문자열

        Stack<Character> stack = new Stack<>();
        boolean isTag = false; // 태그 안에 있는지 여부 체크

        StringBuilder result = new StringBuilder();  // 최종 출력할 결과 저장

        for (char ch : input.toCharArray()) {
            // 1-1. 태그 시작 : "<"
            if(ch == '<') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                isTag = true;
                result.append(ch);
            }
            // 1-2. 태그 종료 : ">"
            else if(ch == '>') {
                isTag = false;
                result.append(ch);
            }
            // 1-3. 태그 내부 문자는 그대로 출력
            else if(isTag) {
                result.append(ch);
            }

            // 2. 문자열인 경우
            else {
                // 2-1. 문자열의 공백
                if (ch == ' ') {
                    while (!stack.isEmpty()) { // 스택에 쌓인 단어를 뒤집어서 출력
                        result.append(stack.pop());
                    }
                    result.append(' '); // 공백 그대로 출력
                } else {
                    stack.push(ch);
                }
            }
        }
        
        // 마지막으로 남은 단어가 있다면 뒤집어서 출력
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result); // 최종 결과 출력
    }
}