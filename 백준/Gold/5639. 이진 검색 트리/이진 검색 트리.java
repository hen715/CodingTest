import java.io.*;


class Main {

    public static class Node{
        int root;
        Node right;
        Node left;
        public Node(int root){
            this.root = root;
        }
        public void setLeft(Node node){
            this.left =node;
        }
        public void setRight(Node node){
            this.right = node;
        }
        public void setNode(int num){
            if(num>root){
                this.setRight(new Node(num));
            }
            else{
                this.setLeft(new Node(num));
            }
        }
    }

    public static void makeTree(Node node, int num){
        if(num>node.root && node.right==null){
            node.setRight(new Node(num));
        }
        else if(num<node.root && node.left==null){
            node.setLeft(new Node(num));
        }
        if(num>node.root){
            makeTree(node.right,num);
        }
        else if(num<node.root){
            makeTree(node.left,num);
        }
    }

    public static void pre(Node node){
        if(node.left!=null){
            pre(node.left);
        }
        if(node.right!=null){
            pre(node.right);
        }
        sb.append(node.root).append("\n");
    }
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Node root = new Node(Integer.parseInt(s));
        sb = new StringBuilder();
        s = br.readLine();
        while (s != null&&!s.equals("")){
            makeTree(root,Integer.parseInt(s));
            s = br.readLine();
        }
        pre(root);
        System.out.print(sb);
    }
}