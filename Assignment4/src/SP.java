
class SP {
	
    public static int findSP(int n, int m, int[] x, int[] y, int u, int v, int[] ans) {
    	int[] len, before;
    	len = new int[n];
    	before = new int[n];
    	for(int i=0; i<n; i++) {
    		len[i] = n;
    		before[i] = -1;
    	}
    	len[u] = 0;
    	
    	Graph g = new Graph(n);
    	for(int i=0; i<m; i++)g.insertEdge(x[i], y[i]);
    	
    	g.BFS(u, v, len, before);
    	if(len[v]!=n) {
        	int tmp = v;
        	int cnt = len[v];
        	while(tmp!=u) {
        		ans[cnt] = tmp;
        		tmp = before[tmp];
        		cnt--;
        	}
        	ans[0]=u;
        	return len[v]+1;
    	}else {
    		return -1;
    	}
    	
    }
}
