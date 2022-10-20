public class graph {
    public Edge E[];
    public int ver, ed;
    public graph(int v, int e){
        ver = v;
        E = new Edge[e];
        ed = e;
    }

    public void insertedge(int[] x, int[] y, int[] s){
        for(int i = 0; i < ed;i++) {
            E[i] = new Edge(x[i], y[i], s[i]);
        }
    }

    public int adjver(Edge e, boolean[] visit){
        if(visit[e.start]) return e.end;
        return e.start;
    }

    public graph prim(){
        boolean visit[] = new boolean[ver];
        for(int i = 0; i < ver; i++) visit[i] = false;
        priorityq pq = new priorityq();
        graph MST = new graph(ver, ver-1);
        unionfind uf = new unionfind(ver);
        int index = 0;
        int k = 0;
        visit[0] = true;
        while(index < ver-1){
            for(int i = 0; i < ed; i++){
                if(E[i].start == k || E[i].end == k){
                    if(visit[E[i].start] && visit[E[i].end]) continue;
                    else pq.insertedge(E[i]);
                }
            }
            for(Edge e = pq.delete(); e != null; e = pq.delete()){
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


    public void printedge(){
        for(int i = 0; i < ed; i++){
            System.out.println(E[i].start+" "+E[i].end+" "+E[i].weight);
        }
    }
}
