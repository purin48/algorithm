import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력
        String str = br.readLine();
        int inputNum = Integer.parseInt(br.readLine());

        // 커서를 기준으로 왼쪽과 오른쪽을 스택으로 관리
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 leftStack에 넣음 (커서는 맨 끝에 위치)
        for (char ch : str.toCharArray()) {
            leftStack.push(ch);
        }

        // 명령어 입력 & 실행
        for (int i = 0; i < inputNum; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L': // 커서를 왼쪽으로 이동
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;

                case 'D': // 커서를 오른쪽으로 이동
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;

                case 'B': // 커서 왼쪽 문자 삭제
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;

                case 'P': // 커서 왼쪽에 문자 추가
                    leftStack.push(command.charAt(2)); // "P x" 에서 x만 가져옴
                    break;
            }
        }

        // 결과 출력 (leftStack + reversed rightStack)
        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            sb.append(leftStack.pop());
        }
        sb.reverse(); // leftStack은 거꾸로 저장되므로 뒤집기

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}