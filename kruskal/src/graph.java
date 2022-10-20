public class graph {
    public Edge E[];
    public int ver, ed;
    public graph(int v, int e){
        ver = v;
        E = new Edge[e];
        ed = e;
    }

    public void insertedge(int[] x, int[] y, int[] s){
        for(int i = 0; i < ed;i++) E[i] = new Edge(x[i], y[i], s[i]);
    }

    public graph kruskal(){
        int index = 0;
        priorityq pq = new priorityq();
        unionfind uf = new unionfind(ver);
        graph MST = new graph(ver, ver-1);
        for(int i = 0; i < ed; i++) pq.insertedge(E[i]);
        while(index < ver-1){
            Edge newedge = pq.delete();
            if(uf.union(newedge)){
                MST.E[index++] = newedge;
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
