import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // commands 배열의 길이만큼 반복
        for(int i=0; i<commands.length; i++){
            // 새로운 자른 배열 만들기
            int[] cutArr = Arrays.copyOfRange(array, (commands[i][0]-1), (commands[i][1]));
            
            // 정렬(오름차순)
            Arrays.sort(cutArr);
            
            // n번째 숫자 가져오기
            answer[i] = cutArr[commands[i][2]-1];
        }
        
        return answer;
    }
}