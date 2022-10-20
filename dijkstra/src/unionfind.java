public class unionfind {
    public int[] root;
    public unionfind(int v){
        root = new int[v];
        for(int i = 0; i < v; i++) root[i] = -1;
    }

    public int find(int x){
        if(root[x] != -1) return find(root[x]);
        return x;
    }

    public boolean union(Edge e){
        int root1 = find(e.start);
        int root2 = find(e.end);
        if(root1 == root2) return false;
        root[root1] = root2;
        return true;
    }
}
