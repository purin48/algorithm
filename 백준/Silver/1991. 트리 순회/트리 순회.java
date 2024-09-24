import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder answer = new StringBuilder();

    // Node를 나타내는 Node 클래스 생성
    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }
    static class BTree {
        Node root; // tree의 루트 노드 저장
        private HashMap<Character, Node> nodes = new HashMap<>(); // key:문자, value:해당 문자 node로 저장

        // Node 추가 메서드
        void addNode(char root, char left, char right) {
            nodes.putIfAbsent(root, new Node(root));
            Node rootVal = nodes.get(root);

            // 처음 root 인 경우, 최상단 root로 지정
            if(this.root == null) {
                this.root = rootVal;
            }

            // 왼쪽 node로 들어갈 left가 '.' 이 아니면
            if (left != '.') {
                nodes.putIfAbsent(left, new Node(left));
                rootVal.left = nodes.get(left);
            }

            // 오른쪽 node로 들어갈 right가 '.' 이 아니면
            if(right != '.') {
                nodes.putIfAbsent(right, new Node(right));
                rootVal.right = nodes.get(right);
            }
        }

        // 전위순회(root-L-R)
        void preOrder(Node node){
            answer.append(node.value);
            if(node.left != null) {
                preOrder(node.left);
            }
            if(node.right != null) {
                preOrder(node.right);
            }
        }

        // 중위순회(L-root-R)
        void inOrder(Node node){
            if(node.left != null) {
                inOrder(node.left);
            }
            answer.append(node.value);
            if(node.right != null) {
                inOrder(node.right);
            }
        }

        // 후위순회(L-R-root)
        void postOrder(Node node){
            if(node.left != null) {
                postOrder(node.left);
            }
            if(node.right != null) {
                postOrder(node.right);
            }
            answer.append(node.value);
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 2. tree 생성
        BTree btree = new BTree();

        // 한 줄마다 node 생성
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            btree.addNode(root, left, right);
        }

        // 순회(전위-중위-후위)
        btree.preOrder(btree.root);
        answer.append("\n");
        btree.inOrder(btree.root);
        answer.append("\n");
        btree.postOrder(btree.root);
        answer.append("\n");

        System.out.println(answer);
    }
}