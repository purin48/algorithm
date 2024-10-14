import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        // 영역 값 채우기
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대 높이 찾기
        int maxH = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                maxH = Math.max(maxH, area[i][j]);
            }
        }

        // 강수량(1 ~ 최대높이)만큼 시뮬레이션 돌리기 => 물에 잠기지 않은 영역을 bfs로 탐색
        int maxSafeArea = 0;
        for (int rain=0; rain<maxH; rain++) {
            visited = new boolean[N][N]; // 방문 여부, 강수량이 변화할 때마다 초기화
            int safeArea = 0; // 현재 강수량의 안전지대 카운트용

            // 강수량 증가할 때마다 전체 탐색
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    // 방문한 적 X && 강수량이 넘지 않는 곳
                    if (!visited[i][j] && area[i][j] > rain) {
                        bfs(i, j, rain);
                        safeArea += 1;
                    }
                }
            }

            // 현재 최대 안전지대 값보다 크면, 최대값으로 바꾸기
            maxSafeArea = Math.max(maxSafeArea, safeArea);

        }
        System.out.println(maxSafeArea);
    }

    private static void bfs(int i, int j, int rain) {
        // 큐 생성
        ArrayDeque<int[]> que = new ArrayDeque<>();

        // 큐 초기 세팅
        que.add(new int[]{i,j});
        visited[i][j] = true;

        // 큐가 빌 때까지 반복
        while(!que.isEmpty()){
            int[] current = que.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 상하좌우 탐색
            for (int k=0; k<4; k++) {
                int newX = currentX + dx[k];
                int newY = currentY + dy[k];

                // 방문한 적 X && 땅 범위 이내에 있는 경우 && 비에 안잠긴 부분만 큐에 추가
                if(newX >= 0 && newY >=0 && newX < N && newY < N && !visited[newX][newY] && area[newX][newY] > rain) {
                    visited[newX][newY] = true;
                    que.add(new int[]{newX, newY});
                }
            }
        }
    }
}