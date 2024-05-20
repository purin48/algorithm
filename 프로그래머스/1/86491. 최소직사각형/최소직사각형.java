class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxV = 0;
        int maxH = 0;
        
        // 두 배열 중에 더 큰 수 : 가로로 설정
        // 두 배열 중에 더 작은 수 : 세로로 설정
        for(int i=0; i<sizes.length; i++) {
            int v = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            maxV = Math.max(maxV, v);
            maxH = Math.max(maxH, h);
        }
        answer = maxV * maxH;
        return answer;
    }
}