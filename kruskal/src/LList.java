public class LList {
    public Edge start;
    public boolean isEmpty(){return start == null;}
    public void insert(Edge e){
        if(start == null){
            start = e;
            return;
        }
        e.next = start;
        start = e;
    }
    public void insertpq(Edge e){
        if(start == null){
            start = e;
            return;
        }
        if(start.weight > e.weight){
            e.next = start;
            start = e;
            return;
        }
        if(start.next == null){
            start.next = e;
            return;
        }
        insert(start, e);
    }
    private void insert(Edge cur, Edge e){
        if(cur.next == null){
            cur.next = e;
            return;
        }
        if(cur.next.weight > e.weight){
            e.next = cur.next;
            cur.next = e;
            return;
        }
        insert(cur.next,e);
    }
    public Edge delete(){
        if(start == null) return null;
        Edge e = start;
        start = start.next;
        return e;
    }
}
