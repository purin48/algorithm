import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // node 클래스 생성
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree {
        // tree의 root node 설정
        public Node root;

        // 트리에 값 삽입
        public void add(int data){
            root = addRecursive(root, data);
        }

        // 재귀적으로 트리에 노드 추가
        public Node addRecursive(Node current, int data) {
            // 만약 current 가 null 이면,
            if(current == null) {
                return new Node(data);
            }

            // 현재 data를 기존의 node와 비교
            if(data < current.data) {
                current.left = addRecursive(current.left, data);
            }else if(data > current.data) {
                current.right = addRecursive(current.right, data);
            }

            return current;
        }

        // 후위순회 : L-R-ROOT
        public void postOrder(Node node) {
            if(node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }

        public Node getRoot() {
            return root;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전위 순회한 결과가 입력값으로 주어짐(Root-Left-Right)
        // 전위순회한 결과를 바탕으로 트리만들기
        Tree tree = new Tree();
        String input;
        while((input = br.readLine()) != null) {
            // 빈 줄 무시
            if(input.trim().isEmpty()) break;

            int nodeData = Integer.parseInt(input);
            tree.add(nodeData);
        }

        // 후위순회로 값 출력
        tree.postOrder(tree.getRoot());
    }
}