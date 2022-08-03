package section7.이진트리레벨탐색;

import java.util.LinkedList;
import java.util.Queue;

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
    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L + "Level : ");
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println("");
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
        tree.BFS(tree.root);
    }
}