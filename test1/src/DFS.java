public class DFS {
    public int n;
    private boolean[] visit;

    public void DFS(int v){
        visit = new boolean[n];
        for(int i = 0; i < n; i++) visit[i] = false;
        doDFS(v, visit);
    }

    private void doDFS(int v, boolean[] visit){
        visit[v] = true;

    }
}
