import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String dirs) {
        // 1. 현재 위치를 (0, 0)에서 시작
        int x = 0;
        int y = 0;
        
        // 2. 방문한 길을 저장하는 Set
        Set<String> visitedPaths = new HashSet<>();
        
        // 3. 각 명령어에 따른 이동 변화를 설정 (위, 아래, 오른쪽, 왼쪽 순서)
        int[] dx = {0, 0, 1, -1}; // x축 변화량
        int[] dy = {1, -1, 0, 0}; // y축 변화량
        char[] directions = {'U', 'D', 'R', 'L'};
        
        // 4. 명령어 문자열을 순회하면서 캐릭터를 이동
        for (char dir : dirs.toCharArray()) {
            int directionIndex = -1; // 5. 현재 방향의 인덱스를 찾기 위한 변수
            
            // 6. 명령어에 따라 인덱스 설정
            for (int i = 0; i < directions.length; i++) {
                if (directions[i] == dir) {
                    directionIndex = i;
                    break;
                }
            }
            
            // 7. 이동 후 새로운 좌표 계산
            int nx = x + dx[directionIndex];
            int ny = y + dy[directionIndex];
            
            // 8. 좌표 경계를 넘어가는 경우는 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 9. 현재 위치에서 새로운 위치로 이동하는 경로를 문자열로 생성
            String path1 = x + "," + y + "->" + nx + "," + ny;
            String path2 = nx + "," + ny + "->" + x + "," + y;
            
            // 10. 양방향 경로를 모두 저장 (중복 방지용)
            visitedPaths.add(path1);
            visitedPaths.add(path2);
            
            // 11. 현재 좌표를 업데이트
            x = nx;
            y = ny;
        }
        
        // 12. 방문한 길의 길이를 반환 (양방향 경로를 모두 기록했으므로 / 2)
        return visitedPaths.size() / 2;
    }
}
