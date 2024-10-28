class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String numbers = "";
        
        // 1. 준비해야하는 전체 숫자 만들어놓기
        for(int num=0; num<(t*m); num++) {
            numbers += Integer.toString(num, n);
        }
        
        // 2. 전체 숫자 중, 순서(p)에 맞게 외칠 숫자 저장
        for(int i=p-1; answer.length() < t; i+=m) {
            answer += numbers.charAt(i);
        }
        
        // 3. 10 ~15는 대문자 A ~ F 로 출력
        return answer.toUpperCase();
    }
}