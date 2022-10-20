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

	public void BFS(int v){
		boolean[] visit = new boolean[vertex];
		for(int i = 0; i < vertex; i++) visit[i] = false;
		visit[v] = true;
		queue q = new queue();
		q.enqueue(v);
		System.out.print(v+"-");
		while(!q.empty()){
			int k= q.dequeue();
			System.out.print(k+"-");
			for(Node e = adj[k].start; e != null; e = e.next){
				if(!visit[e.v]){
					visit[e.v] = true;
					q.enqueue(e.v);
				}
			}
		}
	}

}