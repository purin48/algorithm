import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        
        Stack<Integer> stack = new Stack<>(); // stack
        
        
        for(int i=0; i<N; i++) {
            // 주식가격이 떨어진 경우
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            
            // 주식가격이 떨어지지 않은 경우
            stack.push(i);
        }
        
        // 끝까지 가격이 떨어지지 않은 경우
        while(!stack.isEmpty()) {
            answer[stack.peek()] = N - stack.peek() -1;
            stack.pop();
        }
        
        return answer;
    }
}