import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        // 1. numbers 의 숫자들을 문자로 저장
        String[] numbersStr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 문자 내림차순 정렬
        Arrays.sort(numbersStr, (o1,o2) -> (o2+o1).compareTo(o1+o2));
        
        // 3. 내림차순 정렬대로 붙이기
        for(int i=0; i<numbers.length; i++) {
            answer.append(numbersStr[i]);
        }
        
        // 4. 모두 0인 경우
        if(answer.toString().startsWith("0")) {
            return "0";
        }
        
        return answer.toString();
    }
}