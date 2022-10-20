public class graph {
    public LList[] adj;
    public int ver, ed;
    public LList result;
    public graph(int v, int e){
        ver = v;
        ed = e;
        result = new LList();
        adj = new LList[v];
        for(int i = 0; i < v; i++) adj[i] = new LList();
    }

    public void insert(int[] x, int[] y){
        for(int i = 0; i < ed; i++) {
            adj[x[i]].insertver(y[i]);
            adj[y[i]].insertver(x[i]);
        }
    }

    public void topological(){
        boolean[] visit = new boolean[ver];
        for(int i = 0; i < ver; i++) visit[i] = false;
        for(int k = 0; k < ver; k++) if(!visit[k]) dfs(k, visit);
    }

    private void dfs(int x, boolean[] visit){
        visit[x] = true;
        for(vertex vt = adj[x].start; vt != null; vt = vt.next){
            if(!visit[vt.v]) dfs(vt.v, visit);
        }
        result.insertver(x);
    }

}
