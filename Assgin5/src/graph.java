public class graph {
    public int vertex, ans;
    public LList[] adj;

    public graph(int vt) {
        vertex = vt;
        ans = 0;
        adj = new LList[vt];
        for (int i = 0; i < vt; i++) adj[i] = new LList();
    }

    public void edge(int x, int y) {
        adj[x].insert(y);
        adj[y].insert(x);
    }

    public void bic(){
        int[] dfs, low;
        estack st = new estack();
        dfs = new int[vertex];
        low = new int[vertex];
        for(int i = 0; i < vertex; i++){ dfs[i] = low[i] = 0; }
        bic(0,-1, 1,dfs,low,st);
    }
    private void bic(int cur,int pt,int seq,int[] dfs,int[] low, estack st){
        dfs[cur] = low[cur] = seq++;
        for(Node child = adj[cur].start; child != null; child = child.next){
            if(cur != child.v && dfs[child.v] < dfs[cur]) st.push(cur, child.v);
            if(dfs[child.v] == 0){
                bic(child.v,cur,seq,dfs,low,st);
                if(low[cur] > low[child.v]) low[cur] = low[child.v];
                if(low[child.v] >= dfs[cur]) {
                    while(!st.isempty()){
                        edge newedge = st.pop();
                        if(newedge.n == cur && newedge.m == child.v){
                            ans++;
                            break;
                        }
                    }
                }
            }
            else if(pt != child.v) if(dfs[child.v] < low[cur]) low[cur] = dfs[child.v];
        }
    }
}
