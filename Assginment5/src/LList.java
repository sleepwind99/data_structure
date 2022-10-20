public class LList {
    public Node start;

    public LList(){ start = null; }
    public boolean isempty(){return start == null;}
    public void insert(int x){
        Node newnode = new Node();
        newnode.v = x;
        if(start == null){
            start = newnode;
            return;
        }
        newnode.next = start;
        start = newnode;
    }

    public int delete(){
        if(start == null) return -1;
        int k = start.v;
        start = start.next;
        return k;
    }
}
