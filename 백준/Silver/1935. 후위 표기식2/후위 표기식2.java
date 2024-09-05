import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1-1.피연산자 개수 받기
        int cnt = Integer.parseInt(br.readLine());

        // 1-2.후위표기식 받기
        String form = br.readLine();

        // 1-3.피연산자 숫자만큼 받기(계산 결과를 소숫점 둘째 자리까지 출력!)
        double[] numberArr = new double[cnt];
        for(int i=0; i<cnt; i++) {
            numberArr[i] = Double.parseDouble(br.readLine());
        }

        // 2. 스택 생성
        Stack<Double> calStack = new Stack<>();

        // 3. 피연산자 개수만큼 반복해서 숫자 & 연산자 처리
        for(int i=0; i<form.length(); i++){
            // 3-1. 숫자인 경우, stack에 쌓기
            if(form.charAt(i) >= 'A' && form.charAt(i) <= 'Z') {
                calStack.push(numberArr[(form.charAt(i) - 'A')]);
            }
            // 3-2. 연산자인 경우, 숫자 2개 pop해서 연산 후 stack에 push하기
            else {
                // 먼저 pop한 숫자가 2번째 연산될 숫자
                Double secondNum = calStack.pop();
                Double firstNum = calStack.pop();

                // 연산자에 따라서 연산 분기 처리 => 연산 후, 스택에 push 하기
                switch (form.charAt(i)) {
                    case '+' :
                        calStack.push(firstNum + secondNum);
                        break;
                    case '-' :
                        calStack.push(firstNum - secondNum);
                        break;
                    case '*' :
                        calStack.push(firstNum * secondNum);
                        break;
                    case '/' :
                        calStack.push(firstNum / secondNum);
                        break;
                }
            }
        }
        System.out.printf("%.2f",calStack.stream().mapToDouble(Double::doubleValue).sum());
    }
}