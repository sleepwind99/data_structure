public class execution {
    public static void main(String[] args){
        //dijkstra
//        graph g = new graph(8, 13);
//        int[] x ={0,0,1,1,1,1,3,4,6,6,2,2,7};
//        int[] y ={1,3,3,4,2,5,4,6,2,7,5,7,5};
//        int[] s ={1,2,3,1,4,6,5,2,1,1,1,2,9};
//        g.insert(x,y,s);
//        int k = g.dijkstra(0,6);
//        System.out.println(k);
        //prim
        int[] x = {0,0,0,1,1,2,3,3,4};
        int[] y = {1,2,3,2,4,5,4,5,5};
        int[] s = {2,10,9,4,7,8,3,6,5};
        int e = 9;
        int v = 6;
        graph ph = new graph(v, e);
        ph.insert(x,y,s);
        graph MST = ph.prim();
        MST.printedge();
        MST.DFS(0);
        MST.BFS(0);
        MST.topological();
        MST.kruskal();
        MST.dijkstra(0,6);

        //kruskal

    }
}
