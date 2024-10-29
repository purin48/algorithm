/*
// 시간 초과 뜸..
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        
        // numbers 배열에서 현재 것보다 뒤의 값이 더 크면 그거 넣어주기
        // 없으면 -1 넣기
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                } else {
                    answer[i] = -1;
                }
            }
        }
        
        return answer;
    }
}
*/

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        // Stack 으로 풀기
        int N = numbers.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        
        // numbers 배열 뒤부터 비교
        for(int i=N-1; i>=0; i--) {
            
            // stack에 값이 있는 경우
            while(!stack.empty()) {
                
                // stack의 값이 더 크면 answer에 넣어주고 while문 탈출
                if(numbers[i] < stack.peek()) {
                    answer[i] = stack.peek();
                    break;
                }
                // stack의 값이 더 작으면 pop
                else {
                    stack.pop();
                }
            }
            
            // stack이 빈 경우 : answer에 -1 넣어주기
            if(stack.empty()) {
                answer[i] = -1;
            }
            
            // 현재 숫자를 스택에 추가
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}