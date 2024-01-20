import java.util.*;
import java.io.*;

public class Main {
    
    // 무엇을 우선으로 탐색하는 지에 따라 접근법이 달라짐
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1]; // 정점의 개수 + 1만큼

        for (int i = 0; i < M; i++) { // 간선의 개수만큼 반복
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true; // a와 b에 연결(간선)이 존재한다
            graph[b][a] = true; // b와 a에 연결(간선)이 존재한다
        }
        visit = new boolean[N + 1]; // 정점의 수만큼 방문을 나타내는 배열
        sb = new StringBuilder(); // 방문한 노드들
        dfs(V);
        System.out.println(sb); // 1 2 4 3 (DFS 방문)
        // dfs2(V);
        // System.out.println(sb); // 1 2 4 3 (DFS 방문)
        visit = new boolean[N + 1]; // 정점의 수만큼 방문을 나타내는 배열
        sb = new StringBuilder(); // 방문한 노드들
        bfs(V);
        System.out.println(sb); // 1 2 3 4 (BFS 방문)
    }

    static boolean[] visit;
    static boolean[][] graph;
    static StringBuilder sb;

    static void dfs(int node) { // 이제 dfs를 통해서 방문한 노드
        visit[node] = true; // 0 -> 방문 안했다 (초기값-빈 int배열을 만들면 0으로 가득 차있음)
        sb.append(node);
        sb.append(' ');
        for (int i = 1; i < graph[node].length; i++) { // 그래프 배열을 탐색해서
            if (graph[node][i] && !visit[i]) {
                dfs(i); // 인덱스가 곧 정점 이름과 매치되어 있음 -> 어떤 조건에서 dfs
            }
        }
    }

    static void dfs2(int node) { // 스택 방식으로 처리 (LIFO) : 스택은 지하철로 생각하면 된다. - 가장 먼저 들어온 게 먼저 나감
        Stack<Integer> stack = new Stack<>(); // 탐색할 노드들을 반복적으로 여기에 추가...
        stack.push(node);
        while (!stack.isEmpty()) { // stack이 비어있지 않다면 계속 진행
            int nextNode = stack.pop();
            if (visit[nextNode]) {
                continue; // 이미 방문된 노드라면 다음 노드로...
            } else {
                visit[nextNode] = true; // 신규 방문이라면 1을 표시
            }
            sb.append(nextNode);
            sb.append(' ');
            for (int i = graph[nextNode].length - 1; i >= 1; i--) { // 그래프 배열을 탐색해서
                if (!graph[nextNode][i]) { // 탐색하면 안되는 조건 (2)
                    continue; // 간선이 존재하지 않는 경우에 대해서 continue;
                }
                stack.push(i); // 다음 간선으로 연결되어 있는 노드들을 일괄 추가해주고...
            }
        }
    }

    static void bfs(int node) { // 큐 방식으로 처리 : 큐(FIFO) - 줄서기 생각하면 됨, 먼저 들어간 게 먼저 나옴
        Queue<Integer> queue = new ArrayDeque<>(); // 탐색할 노드들을 반복적으로 여기에 추가...
        queue.add(node); // 입구로 데이터를 넣어줌
        while (!queue.isEmpty()) { // stack이 비어있지 않다면 계속 진행
            int nextNode = queue.poll(); // 출구에서 데이터를 빼냄 | 얘가 핵심! -> 선입선출 (같은 레벨의 이전 노드들을 우선탐색)
            if (visit[nextNode]) {
                continue; // 이미 방문된 노드라면 다음 노드로...
            } else {
                visit[nextNode] = true; // 신규 방문이라면 1을 표시
            }
            sb.append(nextNode);
            sb.append(' ');
            for (int i = 1; i <= graph[nextNode].length - 1; i++) { // 그래프 배열을 탐색해서
                if (!graph[nextNode][i]) { // 탐색하면 안되는 조건 (2)
                    continue; // 간선이 존재하지 않는 경우에 대해서 continue;
                }
                queue.add(i); // 큐 방식으로 변환
            }
        }
    }
}