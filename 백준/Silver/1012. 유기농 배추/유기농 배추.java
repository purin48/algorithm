import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0,0,-1,1}; // 좌우
    static int[] dy = {-1,1,0,0}; // 상하
    static int[][] field;
    static boolean[][] visited;
    static int W,H;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCnt = Integer.parseInt(br.readLine());

        // 1. 가로, 세로, 배추 수
        for (int i=0; i<testCaseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken()); // 배추밭 가로
            H = Integer.parseInt(st.nextToken()); // 배추밭 세로
            int V = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 개수

            // 배추밭 배열을 생성
            field = new int[H][W];

            // 2. 배추 심어진 위치에 배추 표시
            for (int j=0; j<V; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st2.nextToken());
                int Y = Integer.parseInt(st2.nextToken());

                field[Y][X] = 1;
            }

            // 방문 여부 확인용(중복 X)
            visited = new boolean[H][W];

            // 3. 인접한 배추 모두 확인하기
            int wormCnt = 0; // 배추벌레 카운트
            for (int k=0; k<H; k++) {
                for (int l=0; l<W; l++) {
                    // 4. 배추 위치에 있는 것만 && 방문한 적 없는 배추만 bfs로 탐색
                    if(field[k][l] == 1 && !visited[k][l]) {
                        bfs(k,l);
                        wormCnt++; // 배추벌레 +1
                    }
                }
            }

            System.out.println(wormCnt);
        }
    }

    // BFS
    private static void bfs(int k, int l) {
        // 1. 큐 생성 : 탐색할 위치 저장
        ArrayDeque<int[]> que = new ArrayDeque<>();

        // 2. 초기 위치 큐에 추가 및 방문 처리
        que.add(new int[]{k,l});
        visited[k][l] = true;

        // 3. 큐가 빌때까지 반복
        while (!que.isEmpty()) {
            // 현재 위치를 큐에 꺼내서 처리
            int[] current = que.poll();
            int currentY = current[0]; // 현재위치의 Y좌표
            int currentX = current[1]; // 현재위티의 X좌표

            // 현재위치의 상하좌우 탐색
            for (int i=0; i<4; i++) {
                // dx, dy 배열을 통해 상하좌우 움직인 위치 구하기
                int newY = currentY + dy[i];
                int newX = currentX + dx[i];

                // 배추가 심어져있고 & 중복 X & 유효한 배추밭 안에 있는 경우에만
                if(newY >= 0 && newY < H && newX >= 0 && newX < W) {
                    if(!visited[newY][newX] && field[newY][newX] == 1 ) {
                        // 새로운 위치를 큐에 추가
                        que.add(new int[]{newY, newX});
                        visited[newY][newX] = true;
                    }
                }
            }

        }
    }
}