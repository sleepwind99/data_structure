public class graph {
    public Edge[] E;
    public LList[] adj;
    public int ver, ed;
    public graph(int v, int e){
        ver = v;
        ed = e;
        E = new Edge[e];
        adj = new LList[v];
        for(int i = 0; i < v; i++) adj[i] = new LList();
    }

    public void insert(int[] x, int[] y, int[] s){
        for(int i = 0; i < ed; i++) {
            E[i] = new Edge(x[i], y[i], s[i]);
            adj[x[i]].insertver(y[i]);
            adj[y[i]].insertver(x[i]);
        }
    }

    public int weight(int x,int y){
        for(int i = 0; i < ed; i++){
            if(E[i].start == x && E[i].end == y) return E[i].weight;
            if(E[i].end == x && E[i].start == y) return E[i].weight;
        }
        return Integer.MAX_VALUE;
    }

    public Edge getedge(int x, int y){
        for(int i = 0; i < ed; i++){
            if(E[i].start == x && E[i].end == y) return E[i];
            if(E[i].end == x && E[i].start == y) return E[i];
        }
        return null;
    }

    public int dijkstra(int u, int v){
        int[] dest = new int[ver];
        int[] prev = new int[ver];
        boolean[] visit = new boolean[ver];
        for(int i = 0; i < ver; i++){
            dest[i] = Integer.MAX_VALUE;
            prev[i] = -1;
            visit[i] = false;
        }
        dest[u] = prev[u] = 0;
        visit[u] = true;
        priorityq pq = new priorityq(dest, ver);
        for(int i = 0; i < ver; i++) pq.insert(i);
        for(int k = 0; k < ver; k++){
            int minver = pq.delete();
            visit[minver] = true;
            for(vertex vt = adj[minver].start; vt != null; vt = vt.next){
                if(!visit[vt.v]){
                    if(dest[minver]+weight(minver, vt.v) < dest[vt.v]){
                        dest[vt.v] = dest[minver] + weight(minver, vt.v);
                        prev[vt.v] = minver;
                    }
                }
            }
        }
        return dest[v];
    }

    public int adjver(Edge e, boolean[] visit){
        if(visit[e.start]) return e.end;
        else return e.start;
    }

    public graph prim(){
        boolean visit[] = new boolean[ver];
        for(int i = 0; i < ver; i++) visit[i] = false;
        priorityedge pe = new priorityedge();
        graph MST = new graph(ver, ver-1);
        unionfind uf = new unionfind(ver);
        int index = 0;
        int k = 0;
        visit[0] = true;
        while(index < ver-1){
            for(vertex vt = adj[k].start; vt != null; vt = vt.next){
                if(!visit[vt.v]) pe.insertedge(getedge(vt.v,k));
            }
            for(Edge e = pe.delete(); e != null; e = pe.delete()){
                if(uf.union(e)){
                    MST.E[index++] = e;
                    k = adjver(e, visit);
                    visit[k] = true;
                    break;
                }
            }
        }
        return MST;
    }

    public graph kruskal(){
        int index = 0;
        priorityedge pe = new priorityedge();
        unionfind uf = new unionfind(ver);
        graph MST = new graph(ver, ver-1);
        for(int i = 0; i < ed; i++) pe.insertedge(E[i]);
        while(index < ver-1){
            Edge newedge = pe.delete();
            if(uf.union(newedge)){
                MST.E[index++] = newedge;
            }
        }
        return MST;
    }

    public LList topological(){
        boolean[] visit = new boolean[ver];
        LList result = new LList();
        for(int i = 0; i < ver; i++) visit[i] = false;
        for(int k = 0; k < ver; k++) if(!visit[k]) dfs(k, visit, result);
        return result;
    }

    private void dfs(int x, boolean[] visit, LList result){
        visit[x] = true;
        for(vertex vt = adj[x].start; vt != null; vt = vt.next){
            if(!visit[vt.v]) dfs(vt.v, visit, result);
        }
        result.insertver(x);
    }

    public void DFS(int v){
        boolean[] visit = new boolean[ver];
        for(int i = 0; i < ver; i++) visit[i] = false;
        visit[v] = true;
        System.out.print(v+"-");
        for(vertex vt = adj[v].start; vt != null; vt = vt.next) if(!visit[vt.v]) DFS(vt.v);
    }

    public void BFS(int v){
        boolean[] visit = new boolean[ver];
        for(int i = 0; i < ver; i++) visit[i] = false;
        visit[v] = true;
        queue q = new queue();
        q.enqueue(v);
        while(!q.isEmpty()){
            int k = q.dequeue();
            System.out.print(k+"-");
            for(vertex vt = adj[k].start; vt != null; vt = vt.next){
                if(!visit[vt.v]){
                    visit[vt.v] = true;
                    q.enqueue(vt.v);
                }
            }
        }
    }

    public void printedge(){
        for(int i = 0; i < ed; i++){
            System.out.println(E[i].start+" "+E[i].end+" "+E[i].weight);
        }
    }
}
