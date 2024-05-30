import java.util.*;
import java.io.*;
import java.math.*;

public class new_code {
    static int INF = 0x3f3f3f3f;
    static int N = 101000,M = 30;
    static int[][] f = new int[N][M];
    static int[] dep = new int[N],d = new int[N],dist = new int[N];
    static int n,m;
    static long ans;

    static void dfs0(int u,int fa){
        dep[u] = dep[fa] + 1;
        f[u][0] = fa;
        dist[u] = dist[fa] + d[u];
        for(int j=1;j<M;j++){
            f[u][j] = f[f[u][j-1]][j-1];
        }
        for(int i=h[u];i!=-1;i=ne[i]){
            int j = e[i];
            if(j==fa) continue;
            dfs0(j,u);
        }
    }

    static int lca(int a,int b){
        if(dep[a] < dep[b]){
            int t = a;
            a = b;
            b = t;
        }
        for(int i=M-1;i>=0;i--)
            if(dep[f[a][i]] >= dep[b])
                a = f[a][i];
        if(a==b) return a;

        for(int i=M-1;i>=0;i--)
            if(f[a][i] != f[b][i]){
                a = f[a][i];
                b = f[b][i];
            }
        return f[a][0];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        init();
        for(int i=1;i<=n-1;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a,b,0);
            add(b,a,0);
            d[a] += 1;
            d[b] += 1;
        }
        dfs0(1,0);

        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = lca(a,b);
            long ans = dist[a] + dist[b] - dist[c] - dist[f[c][0]];
            System.out.println(ans);
        }
    }

    static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
    static int idx;
    static void add(int a,int b,int c) {
        e[idx] = b;
        w[idx] = c ;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    static void init(){
        Arrays.fill(h,-1);
    }

}
class Read{
    StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//    PrintWriter out = new PrintWriter(System.out);
//    out.flush();
    int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    String getLine() throws IOException {
        return r.readLine();
    }
}