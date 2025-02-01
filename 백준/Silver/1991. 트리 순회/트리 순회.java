import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Main {
    static StringBuilder sb;
    static class Node{
        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void setNode(Node left, Node right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Node left = s[1].equals(".")?null:new Node(s[1],null,null);
        Node right = s[2].equals(".")?null:new Node(s[2],null,null);
        Node top = new Node(s[0],left,right);
        sb = new StringBuilder();
        for(int i = 0 ; i < n-1 ; i++){
            s = br.readLine().split(" ");
            Node node = findParent(top,s[0]);
            node.setNode(s[1].equals(".")?null:new Node(s[1],null,null),s[2].equals(".")?null:new Node(s[2],null,null));
        }
        pre(top);
        sb.append("\n");
        mid(top);
        sb.append("\n");
        aft(top);
        System.out.println(sb);
    }

    public static Node findParent(Node top,String parent){
        Queue<Node> q = new LinkedList<>();
        q.add(top);
        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.value.equals(parent)){
                return node;
            }
            if(node.left!=null) {
                q.add(node.left);
            }
            if(node.right!=null) {
                q.add(node.right);
            }

        }
        return null;
    }



    public static void pre(Node top){
        sb.append(top.value);
        if(top.left!=null){
            pre(top.left);
        }
        if(top.right!=null){
            pre(top.right);
        }
    }
    public static void mid(Node top){
        if(top.left!=null){
            mid(top.left);
        }
        sb.append(top.value);
        if(top.right!=null){
            mid(top.right);
        }
    }

    public static void aft(Node top){
        if(top.left!=null){
            aft(top.left);
        }
        if(top.right!=null){
            aft(top.right);
        }
        sb.append(top.value);
    }


}