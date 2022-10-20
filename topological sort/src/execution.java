public class execution {
    public static void main(String[] args){
        graph g = new graph(9, 11);
        int[] x ={2,2,0,1,1,4,3,3,6,5,7};
        int[] y ={0,1,1,4,3,5,5,6,7,7,8};
        g.insert(x,y);
        g.topological();
        for(vertex vt = g.result.start; vt != null; vt = vt.next){
            System.out.println(vt.v);
        }
    }
}
