class graph {
	public int vertex;
	public LList[] adj;

	public graph(int x) {
		vertex = x;
		adj = new LList[x];
		for (int i = 0; i < x; i++) adj[i] = new LList();
	}

	public void edge(int x, int y) {
		adj[x].insert(y);
		adj[y].insert(x);
	}

	public void DFS(int v){
		boolean[] visit = new boolean[vertex];
		for(int i = 0; i < vertex; i++) visit[i] = false;
		visit[v] = true;
		System.out.print(v+"-");
		for(Node e = adj[v].start; e != null; e = e.next) if(!visit[e.v]) DFS(e.v);
	}

}