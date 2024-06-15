import java.io.*;
import java.util.*;

/**
 * 도시 분할 계획
 */
public class Main {
    static final PScanner sc = new PScanner(System.in);
    static final PWriter out = new PWriter(System.out);

    static void solve() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        PriorityQueue<Edge> pq = new PriorityQueue<>(M);
//        Edge[] edges = new Edge[M];
        for (int m = 0; m < M; m++) {
            pq.offer(new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
//            edges[m] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
        }
//        Arrays.sort(edges);
        DisjointSet set = new DisjointSet(N);
        int total = 0;
        while (set.subsetCount() > 2) {
            Edge edge = pq.poll();
            if (set.union(edge.a, edge.b)) {
                total += edge.c;
            }
        }
        out.println(total);
    }

    static class Edge implements Comparable<Edge> {
        public int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(c, o.c);
        }
    }

    static class DisjointSet {
        private final int[] parent;
        private int subsets;

        public DisjointSet(int size) {
            parent = new int[size];
            for (int i = 1; i < size; i++) {
                parent[i] = i;
            }
            subsets = size;
        }

        public int size() {
            return parent.length;
        }

        public int subsetCount() {
            return subsets;
        }

        public int find(int a) {
            if (a == parent[a]) {
                return a;
            }
            return parent[a] = find(parent[a]);
        }

        public boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) {
                return false;
            }
            parent[b] = a;
            subsets--;
            return true;
        }

        public boolean isUnion(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) {
        solve();
        out.flush();
    }

    // @formatter:off 2024/04/08
    static class PScanner{private final InputStreamReader in;private final char[]buf;private final char[]cbuf;private int len,ptr;public PScanner(InputStream input){in=new InputStreamReader(input);buf=new char[8192];cbuf=new char[8192];}public boolean hasNext(){consume();return ptr<len&&buf[ptr]>' ';}public boolean hasNextInLine(){char c;while((c=read())<=' '&&c!=0&&c!='\n');ptr--;return ptr<len&&buf[ptr]>' ';}public String next(){consume();char[]cbuf=this.cbuf;int clen=0;int start=ptr;while(true){if(ptr<len){if(buf[ptr++]<=' '){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;break;}}else if(ptr==len){cbuf=copy(buf,start,cbuf,clen,ptr - start);clen+=ptr - start;fill();start=ptr;}else break;}ptr--;if(ptr<len)clen--;return new String(cbuf,0,clen);}private char[]copy(char[]src,int srcPos,char[]dest,int destPos,int length){if(dest.length<destPos+length)dest=Arrays.copyOf(dest,dest.length << 1);System.arraycopy(src,srcPos,dest,destPos,length);return dest;}public char nextChar(){consume();return read();}public int nextInt(){consume();int v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}public long nextLong(){consume();long v=0;char c=read();boolean neg=c=='-';if(neg)c=read();do{v=v * 10+c - '0';}while('0'<=(c=read())&&c<='9');ptr--;return neg?-v:v;}private char read(){if(ptr==len)fill();return ptr<len?buf[ptr++]:0;}private void fill(){try{len=in.read(buf);ptr=0;}catch(IOException e){throw new RuntimeException(e);}}private void consume(){char c;while((c=read())<=' '&&c!=0);ptr--;}}
    static class PWriter{private final BufferedWriter out;private final char[]buf;public PWriter(OutputStream out){this.out=new BufferedWriter(new OutputStreamWriter(out));buf=new char[32];}public void flush(){try{out.flush();}catch(IOException e){throw new RuntimeException(e);}}public PWriter print(char c){try{out.write(c);return this;}catch(IOException e){throw new RuntimeException(e);}}public PWriter print(int i){if(i>0){int len=0;while(i!=0){int d=i%10;buf[len++]=(char)('0'+d);i /= 10;}while(len-->0){print(buf[len]);}}else if(i==0){print('0');}else{print('-');print(-i);}return this;}public PWriter print(long l){if(l>0){int len=0;while(l!=0){long d=l%10;buf[len++]=(char)('0'+d);l /= 10;}while(len-->0){print(buf[len]);}}else if(l==0){print('0');}else{print('-');print(-l);}return this;}public PWriter print(float f){return print(f+"");}public PWriter print(double d){return print(d+"");}public PWriter print(Object o){return print(o+"");}public PWriter print(String s){try{out.write(s);return this;}catch(IOException e){throw new RuntimeException(e);}}public void println(){print('\n');}public void println(char c){print(c);print('\n');}public void println(int i){print(i);print('\n');}public void println(long l){print(l);print('\n');}public void println(float f){print(f+"\n");}public void println(double d){print(d+"\n");}public void println(Object o){print(o+"\n");}public void println(String s){print(s);print('\n');}public void printf(String format,Object... args){print(String.format(format,args));}}
    // @formatter:on
}