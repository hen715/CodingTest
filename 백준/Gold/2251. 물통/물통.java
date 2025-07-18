import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int a;
        int b;
        int c;
        public Node(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static Queue<Node> q;
    public static boolean[][][] visit;
    public static int a;
    public static int b;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);
        visit = new boolean[a + 1][b + 1][c + 1];
        TreeSet<Integer> set = new TreeSet<>();
        q = new LinkedList<>();
        q.add(new Node(0,0,c));
        visit[0][0][c] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.a==0){
                set.add(now.c);
            }
            if(now.a>0){
                if(now.b<b){
                    if(now.a+now.b<b){
                        if(!visit[0][now.a+now.b][now.c]){
                            visit[0][now.a+now.b][now.c] = true;
                            q.add(new Node(0,now.a+now.b,now.c));
                        }

                    }
                    else{
                        if(!visit[now.a-(b-now.b)][b][now.c]) {
                            visit[now.a-(b-now.b)][b][now.c] = true;
                            q.add(new Node(now.a - (b - now.b), b, now.c));
                        }
                    }
                }
                if(now.c<c){
                    if(now.a+now.c<c){
                        if(!visit[0][now.b][now.a+now.c]){
                            visit[0][now.b][now.a+now.c] = true;
                            q.add(new Node(0,now.b,now.a+now.c));
                        }

                    }
                    else{
                        if(!visit[now.a-(c-now.c)][now.b][c]) {
                            visit[now.a-(c-now.c)][now.b][c] = true;
                            q.add(new Node(now.a - (c - now.c), now.b, c));
                        }
                    }
                }
            }

            if(now.b>0){
                if(now.a<a){
                    if(now.a+now.b<a){
                        if(!visit[now.a+now.b][0][now.c]){
                            visit[now.a+now.b][0][now.c] = true;
                            q.add(new Node(now.a+now.b,0,now.c));
                        }

                    }
                    else{
                        if(!visit[a][now.b-(a-now.a)][now.c]) {
                            visit[a][now.b-(a-now.a)][now.c] = true;
                            q.add(new Node(a, now.b-(a-now.a), now.c));
                        }
                    }
                }
                if(now.c<c){
                    if(now.b+now.c<c){
                        if(!visit[now.a][0][now.b+now.c]){
                            visit[now.a][0][now.b+now.c] = true;
                            q.add(new Node(now.a,0,now.b+now.c));
                        }

                    }
                    else{
                        if(!visit[now.a][now.b-(c-now.c)][c]) {
                            visit[now.a][now.b-(c-now.c)][c] = true;
                            q.add(new Node(now.a, now.b-(c-now.c), c));
                        }
                    }
                }
            }
            if(now.c>0){
                if(now.b<b){
                    if(now.c+now.b<b){
                        if(!visit[now.a][now.c+now.b][0]){
                            visit[now.a][now.c+now.b][0] = true;
                            q.add(new Node(now.a,now.c+now.b,0));
                        }
                    }
                    else{
                        if(!visit[now.a][b][now.c-(b-now.b)]) {
                            visit[now.a][b][now.c-(b-now.b)] = true;
                            q.add(new Node(now.a , b, now.c-(b-now.b)));
                        }
                    }
                }
                if(now.a<a){
                    if(now.a+now.c<a){
                        if(!visit[now.a+now.c][now.b][0]){
                            visit[now.a+now.c][now.b][0] = true;
                            q.add(new Node(now.a+now.c,now.b,0));
                        }

                    }
                    else{
                        if(!visit[a][now.b][now.c-(a-now.a)]) {
                            visit[a][now.b][now.c-(a-now.a)] = true;
                            q.add(new Node(a, now.b, now.c-(a-now.a)));
                        }
                    }
                }

            }

        }
        StringBuilder sb = new StringBuilder();
        for(int a : set){
            sb.append(a).append(' ');
        }
        System.out.print(sb);
    }


}