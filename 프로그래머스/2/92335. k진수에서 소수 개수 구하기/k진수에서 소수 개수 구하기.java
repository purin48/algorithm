import java.util.*;

class Solution {
    
    // 소수 판별 함수
    public boolean isPrime(long number) {
        // 0, 1은 소수가 X
        if(number < 2) {
            return false;
        }
        
        // 2는 소수
        if(number == 2) {
            return true;
        }
        
        // number만큼 반복해서 나눠지는 수 있는 지 확인
        // (1번 테케 시간초과) : 제곱근으로 해야 시간초과 안남..
        long sqrt = (long) Math.sqrt(number);
        for(int i=2; i<=sqrt; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        boolean isPrime = true;
        
        // 0 단위로 분리해서 숫자 추출
        String parsedNum = Integer.toString(n, k);
        String[] parsedArr = parsedNum.split("0");
        
        // 소수인지 확인 후 answer에 카운트
        for (String num : parsedArr) {
            if (!num.isEmpty() && isPrime(Long.parseLong(num))) {
                answer += 1;
            }
        }
        
        return answer;
    }
}