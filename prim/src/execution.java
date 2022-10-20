public class execution {
    public static void main(String[] args){
        int[] x = {0,0,0,1,1,2,3,3,4};
        int[] y = {1,2,3,2,4,5,4,5,5};
        int[] s = {2,10,9,4,7,8,3,6,5};
        int e = 9;
        int v = 6;
        graph ph = new graph(v, e);
        ph.insertedge(x,y,s);
        graph MST = ph.prim();
        MST.printedge();
    }
}
