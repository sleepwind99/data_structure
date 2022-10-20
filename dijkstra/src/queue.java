public class queue {
    public vertex start, end;
    public boolean isEmpty(){return start == null;}
    public queue(){start = end =null;}
    public void enqueue(int x){
        vertex vt = new vertex(x);
        if(isEmpty()){
            start = vt;
            end = vt;
            return;
        }
        end.next = vt;
        end = vt;
    }
    public int dequeue(){
        if(isEmpty()) return -1;
        int k = start.v;
        start = start.next;
        if(start == null) end = null;
        return k;
    }
}
