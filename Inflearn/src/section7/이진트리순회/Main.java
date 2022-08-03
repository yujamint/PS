package section7.이진트리순회;

class Node{
    int data;
    Node lt, rt; // 노드 클래스의 객체 주소를 저장하는 변수(왼쪽 자식, 오른쪽 자식의 주소가 써있다고 생각하면 될 듯)
    public Node(int val){
        data = val;
        lt=rt=null;
    }
}

public class Main {
    Node root;
    public void DFS(Node root){
        if(root==null) return;
        else {
            System.out.print(root.data + " "); // 들어오는 노드(부모)를 출력하기 때문에 이 출력문을 어디에 두냐에 따라 전위,중위,후위 순회가 결정된다.
            DFS(root.lt);
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root=new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
