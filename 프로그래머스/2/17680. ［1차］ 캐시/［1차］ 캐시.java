import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String> cache = new ArrayList<>();
        
        int N = cities.length;
        
        // 4. cache 크기가 0일때 조건 추가(cities배열에 전부 cache miss)
        if(cacheSize == 0) {
            return N * 5;
        }
        
        // 1. 도시이름 배열 반복
        for(int i=0; i<N; i++) {
            // * 대소문자 구분 X
            String currentCity = cities[i].toUpperCase();
            
            // 2. 만약 cache에 도시 존재 : time에 +1 & 기존 cache에서 제거 후, 다시 추가
            if(cache.contains(currentCity)) {
                time += 1;
                cache.remove(cache.indexOf(currentCity));
            }
            // 3.만약 cache에 도시 X : time에 +5, & 가장 오래된 값 제거 후, cache에 추가
            else {
                if(cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                time += 5;
            }
            cache.add(currentCity);
        }
        return time;
    }
}