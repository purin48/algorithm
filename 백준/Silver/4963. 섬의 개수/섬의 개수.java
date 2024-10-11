import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int W;
    static int H;
    static int[][] MAP;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 입력 받기
        while(true) {
            // 지도 W, H 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 지도 생성
            MAP = new int[H][W];
            visited = new boolean[H][W];

            // 정답 초기화
            cnt = 0;

            // 0 0 일 경우, 탈출!
            if(W == 0 && H == 0) {
                break;
            }

            for(int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine());

                // 열(W)개수만큼 반복해서 입력 받기
                for (int j=0; j<W; j++){
                    MAP[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 지도 탐색(땅이 발견되면 bfs로 찾기)
            for (int i=0; i<H; i++) {
                for (int j=0; j<W; j++) {
                    if(MAP[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                        cnt += 1; // bfs 레벨 +1
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int i, int j) {
        // 큐 생성
        ArrayDeque<int[]> que = new ArrayDeque<>();

        // 초기값 넣어주기
        que.add(new int[]{i, j});
        visited[i][j] = true;

        // 큐가 빌 때까지
        while (!que.isEmpty()) {
            int[] current = que.poll();
            int currentX = current[0];
            int currentY = current[1];

            // 상, 하, 좌, 우, 각 방향 대각선 만큼 탐색
            for(int k=0; k<8; k++) {
                int newX = currentX + dx[k];
                int newY = currentY + dy[k];

                // dx, dy 더한 값이 지도 범위 이내인지
                if(newX >= 0 && newX < H && newY >= 0 && newY < W) {
                    // '땅'이어야하고 & 방문한 적 없는 값이라면 => 큐에 추가
                    if(MAP[newX][newY] == 1 && !visited[newX][newY]) {
                        que.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}