import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int[] sortedArr = d;
        
        // 1. 오름차순 정렬
        Arrays.sort(sortedArr);
        
        // 2. 이전값 + 현재값 더한 값 <= 예산 이면, answer+1
        int sum = 0;
        for(int num : sortedArr) {
            if(sum + num <= budget) {
                sum = sum + num;
                answer += 1;
            }
        }
        
        return answer;
    }
}