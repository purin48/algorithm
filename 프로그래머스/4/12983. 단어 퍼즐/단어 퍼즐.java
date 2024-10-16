import java.util.*;

class Solution {
    private static final int INF = 20_001;
    
    public int solution(String[] strs, String t) {
        int N = t.length(); // 타깃 문자열 t의 길이
        
        // 각 위치에 필요한 최소 조각수 저장 배열
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        
        // 빈 문자열에 대한 최소 조각수 = 0
        dp[0] = 0;
        
        // sizes에 strs 의 각 문자열 길이 저장
        HashSet<Integer> sizes = new HashSet<>();
        for(String str : strs) {
            sizes.add(str.length());
        }
        
        // dp[i] ~ dp[N] 까지 채우기
        for(int i=0; i<=N; i++) {
            // 이전에 구한 strs 조각 길이가 저장된 sizes를 보고 추가할 조각 확인하는 반복문
            for(int size : sizes) {
                if(i - size >= 0) {
                    int idx = i;
                    String sub = t.substring(idx - size, idx);
                    
                    // 이미 구한 해와 strs 문자열을 추가해서 만들 수 있다면
                    if(Arrays.asList(strs).contains(sub)) {
                        // 해당 위치의 최소 조각수 갱신
                        dp[i] = Math.min(dp[i], dp[i - size] + 1);
                    }
                }
            }
        }
        
        // 최소 조각수 반환
        return dp[N] < INF ? dp[N] : -1;
    }
}