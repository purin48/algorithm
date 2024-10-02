import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Graph {
        // 1. Node 생성
        class Node {
            int data;
            LinkedList<Node> adjacent; // 인접한 노드리스트
            boolean visited; // 방문 여부 체크용 필드
            public Node(int data) {
                this.data = data;
                this.visited = false;
                adjacent = new LinkedList<Node>();
            }
        }

        // 2. 그래프에는 Node들을 저장할 배열 만들기
        Node[] nodes;
        int answer = 0; // 감염 PC 수 카운트 변수 생성

        // 입력받은 cnt 만큼 node배열 생성
        Graph(int size) {
            nodes = new Node[size+1];
            for (int i=1; i<=size; i++) {
                nodes[i] = new Node(i);
            }
        }

        // 2개의 node의 관계를 저장
        void addEdge(int data1, int data2) {
            Node node1 = nodes[data1];
            Node node2 = nodes[data2];

            // 2개의 node에서 각각 인접한 노드 리스트 중 상대가 있는 지 확인 => 없으면 서로 추가
            if(!node1.adjacent.contains(node2)) {
                node1.adjacent.add(node2);
            }
            if(!node2.adjacent.contains(node1)) {
                node2.adjacent.add(node1);
            }
        }

        // 3. dfs 메소드 생성
        void dfs() {
            dfs(1);
        }

        void dfs(int idx) {
            // idx로 node 가져오기
            Node root = nodes[idx];

            // stack 생성
            Stack<Node> stack = new Stack<Node>();

            // 현재 node를 stack 에 추가
            stack.push(root);

            // 현재 node인 root의 방문여부 true로 변경
            root.visited = true;

            // stack에 데이터가 없을 때까지 dfs 반복
            while (!stack.isEmpty()) {
                Node rm = stack.pop();

                // 인접리스트 존재하는만큼 반복
                for (Node n : rm.adjacent) {
                    // 방문하지 않았던 것들만 stack에 넣어주기
                    if(n.visited == false) {
                        n.visited = true;
                        stack.push(n);
                    }
                }
                answer += 1;
            }
            System.out.println(answer - 1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        Graph graph = new Graph(cnt);
        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph.addEdge(num1, num2);
        }
        graph.dfs();
    }
}