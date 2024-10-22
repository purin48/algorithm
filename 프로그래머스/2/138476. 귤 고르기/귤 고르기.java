import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // tangerine 에서 가장 큰 값
        int max = 0;
        for(int tan : tangerine) {
            if(max < tan) max = tan;
        }
        
        // 현재 최대값만큼의 배열 생성
        int[] arr = new int[max];
        
        // 중복되는 값 누적
        for(int tan : tangerine) {
            arr[tan-1] += 1;
        }
        
        // 내림차순 정렬
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrInteger, Comparator.reverseOrder());
        
        // k만큼만 넣어주고, 나머지는 X
        int cnt = 0;
        for(int boxTan : arrInteger) {
            // k만큼 담았으면, 그만 담기
            if(cnt + boxTan >= k) {
                answer += 1;
                break;
            } else {
                cnt += boxTan;
                answer += 1;
            }
        }
        
        return answer;
    }
}