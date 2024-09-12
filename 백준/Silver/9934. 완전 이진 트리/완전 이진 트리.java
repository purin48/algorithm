import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // K 깊이만큼 넣어줄 배열 리스트
    static List<Integer>[] treeList;

    // 중위 순회의 결과인 노드배열
    static int[] tree;

    public static void main(String[] args) throws IOException {

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // 2. tree 사이즈만큼 배열 생성(총 노드 수 : 2^K - 1)
        int size = (int)Math.pow(2, K) - 1;
        tree = new int[size];

        // 3. 중위순회한 노드들 입력 받아오기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<tree.length; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 4. K 깊이만큼 넣어줄 배열 초기화
        // K 가 3이면 1깊이에 들어갈 배열, ...
        treeList = new ArrayList[K];
        for (int i=0; i<K; i++) {
            treeList[i] = new ArrayList<>();
        }

        // 5. 기존 트리 재구성
        inorder(0, size -1, 0);

        StringBuilder answer = new StringBuilder();
        // 6. 각 깊이마다 재구성된 노드들 출력
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < treeList[i].size(); j++) {
                answer.append(treeList[i].get(j)).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    // 재귀적으로 중위순회를 이용해서 트리 깊이 별로 노드 다시 재구성
    static void inorder(int start, int end, int depth) {
        if (start > end) return;

        // 해당 깊이의 루트노드인 mid 값을 구해서 treeList 에 추가
        int mid = (start + end) / 2;
        treeList[depth].add(tree[mid]);

        // 왼쪽 & 오른쪽 자식 노드 분할해서 다시 재귀탐색 시작
        inorder(start, mid-1, depth+1);
        inorder(mid+1, end, depth+1);
    }
}