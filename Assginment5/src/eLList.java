public class eLList {
    public edge start;
    public eLList(){start = new edge();}
    public boolean isempty(){return start == null;}

    public void insert(int x, int y){
        edge newedge = new edge();
        newedge.n = x;
        newedge.m = y;
        if(start == null){
            start = newedge;
            return;
        }
        newedge.next = start;
        start = newedge;
    }

    public edge delete(){
        if(start == null) return null;
        edge newedge = start;
        start = start.next;
        return newedge;
    }
}
