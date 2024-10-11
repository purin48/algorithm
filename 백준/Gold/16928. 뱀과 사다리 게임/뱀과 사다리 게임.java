import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] game = new int[100]; // 게임판 배열
    static boolean[] visited = new boolean[100]; // 방문여부 확인용
    static int N; // 사다리 수
    static int M; // 뱀 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 게임판 숫자 채워넣기(1~100까지)
        for(int i=1; i<101; i++) {
            game[i-1] = i;
        }

        // 사다리 정보 저장
        for (int i=0; i<N; i++) {
            StringTokenizer stN = new StringTokenizer(br.readLine());
            int startN = Integer.parseInt(stN.nextToken());
            int endN = Integer.parseInt(stN.nextToken());
            game[startN - 1] = endN;
        }

        // 뱀 정보 저장
        for (int i=0; i<M; i++) {
            StringTokenizer stM = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(stM.nextToken());
            int endM = Integer.parseInt(stM.nextToken());
            game[startM - 1] = endM;
        }
        
        // 최단 거리 찾기 : 큐 생성
        ArrayDeque<int[]> que = new ArrayDeque<>();

        // 초기값 넣어주기(시작점, 주사위 던진 횟수)
        que.add(new int[]{1,0});
        visited[0] = true;

        // 큐 빌때까지 반복
        while (!que.isEmpty()) {
            // 현재 위치값 빼오기
            int[] current = que.poll();
            int currentPosition = current[0];
            int currentDice = current[1];

            // 1 ~ 6 주사위 값만큼 + 해보기
            for(int i=1; i<=6; i++) {
                // 100인 경우 : 주사위 횟수+1 하고 리턴
                if(currentPosition+i == 100) {
                    currentDice += 1;
                    System.out.println(currentDice);
                    return;
                }

                // 100이 아닌 경우, 현재 위치 + 주사위 i값한 새로운 위치 저장
                int newLocation = game[currentPosition+i-1];

                // 방문하지 않은 위치라면 큐에 추가
                if(!visited[newLocation]) {
                    que.add(new int[]{newLocation, currentDice+1});
                    visited[newLocation] = true;
                }
            }
        }
    }
}