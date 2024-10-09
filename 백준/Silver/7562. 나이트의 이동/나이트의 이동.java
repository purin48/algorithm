import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    // 나이트의 이동방향
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int L;
    static int[][] chase;
    static boolean[][] visited;
    static int[] SP,EP;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<testCnt; i++) {
            // 체스판 생성
            L = Integer.parseInt(br.readLine());
            chase = new int[L][L];
            visited = new boolean[L][L];

            // 시작점 받기
            String[] startInput = br.readLine().split(" ");
            SP = new int[]{Integer.parseInt(startInput[0]), Integer.parseInt(startInput[1])};

            // 목표지점 받기
            String[] endInput = br.readLine().split(" ");
            EP = new int[]{Integer.parseInt(endInput[0]), Integer.parseInt(endInput[1])};

            // BFS로 목표지점까지 최단거리 찾기 호출
            bfs(SP, EP);
            System.out.println(result);
        }
    }

    // BFS
    private static void bfs(int[] sp, int[] ep) {
        // 1. 큐 생성
        ArrayDeque<int[]> que = new ArrayDeque<>();

        // 2. 큐에 초기값 넣어주기 & 방문 표시
        que.add(new int[]{sp[0], sp[1], 0}); // 시작점 x, y, 이동횟수
        visited[sp[0]][sp[1]] = true;

        // 3.que가 빌 때까지 반복 && 목표 지점에 도달할 때까지
        while (!que.isEmpty()) {
            int[] currentPlace = que.poll();
            int currentX = currentPlace[0];
            int currentY = currentPlace[1];
            int currentMove = currentPlace[2];

            // 현재위치 == 목표위치 확인하기
            if(currentX == ep[0] && currentY == ep[1]) {
                result = currentMove;
                return;
            }

            // 8가지 방향만큼 반복
            for (int i=0; i<8; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                // 새로운 위치가 체스판 내 유효한 범위인지 확인
                if(newX >= 0 && newX < L && newY >= 0 && newY < L) {
                    // 방문했던 건 아닌지
                    if(!visited[newX][newY]) {
                        que.add(new int[]{newX, newY, currentMove+1});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}